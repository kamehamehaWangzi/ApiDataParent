package org.pbccrc.api.base.service;

import java.util.Map;

public interface SendMessageCoreService {
	
	/**
	 * 
	 * @param telNos		电话号码用","分割
	 * @param msgContent	短信内容
	 */
	Map<String, Object> sendMessage(String telNos, String msgContent) throws Exception;

}