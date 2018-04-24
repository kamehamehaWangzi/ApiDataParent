package org.pbccrc.api.core.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.pbccrc.api.base.service.CostService;
import org.pbccrc.api.base.util.Constants;
import org.pbccrc.api.base.util.RedisClient;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

@Service
public class CostServiceImpl implements CostService {
	
	/**
	 * 计费
	 * @param userID
	 * @param apiKey
	 */
	public Map<String, Object> cost(String userID, String apiKey) {
		// 返回map
		Map<String, Object> map = new HashMap<String, Object>();
		
		StringBuilder relationKey = new StringBuilder("relation");
		relationKey.append(Constants.UNDERLINE + userID);
		relationKey.append(Constants.UNDERLINE + apiKey);
		
		JSONObject relation = JSONObject.parseObject(String.valueOf(RedisClient.get(relationKey.toString())));
		String costType = relation.getString("costType");
		
		
		// 判断计费类型
		if (Constants.COST_TYPE_COUNT.equals(costType)) {
			// 按次数计费
			// 获得剩余查询次数,-1为免费查询
			int count = Integer.parseInt(String.valueOf(relation.get("count")));
			
			// 每日查询次数-1
			int visitCount = Integer.parseInt(String.valueOf(relation.get("visitCount")));
			relation.put("visitCount", --visitCount);
			if (-1 == count) {
				// -1为免费查询,不减少count直接保存
				RedisClient.set(relationKey.toString(), relation);
			} else {
				// 不为-1为计次数查询,剩余查询次数-1并提交
				relation.put("count", --count);
				RedisClient.set(relationKey.toString(), relation);
			}
			
		} else if (Constants.COST_TYPE_PRICE.equals(costType)) {
			// 按金额计费
			// 获取apiUser
			String apiUserKey = "apiUser" + Constants.UNDERLINE + userID;
			JSONObject apiUser = JSONObject.parseObject(String.valueOf(RedisClient.get(apiUserKey).toString()));
			// 余额
			BigDecimal blance = new BigDecimal(apiUser.getString("blance"));
			// 获取用户价格
			BigDecimal price = new BigDecimal(relation.getString("price"));
			// 从余额中扣除
			blance = blance.subtract(price);
			apiUser.put("blance", blance);
			
			RedisClient.set(apiUserKey.toString(), apiUser);
		} else {
			// to be extended
		}
		
		// 增加查询次数
		int queryCount = relation.getIntValue("queryCount");
		relation.put("queryCount", ++queryCount);
		RedisClient.set(relationKey.toString(), relation);
		
		// 返回查询次数
		map.put("queryCount", queryCount);
		
		return map;
	}
}
