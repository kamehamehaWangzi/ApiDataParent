package org.pbccrc.api.base.bean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 本地API
 * @author charles
 * 
 */
public class LocalApi implements Serializable{

	private static final long serialVersionUID = -915738031210139391L;
	
	/** 主键  */
	private int ID;
	
	/** API名称 */
	private String apiName;
	
	/** 服务连接名 */
	private String service;
	
	/** 数据库表名称 */
	private String tblName;
	
	/** 服务url */
	private String url;
	
	/** 查询参数列表 */
	private String prarms;
	
	/** 返回值类型(1String, 2json, 3 xml) */
	private int returnType;
	
	/** 返回字段列表 */
	private String returnParam;
	
	/** 计费条件 */
	private String costCondition;
	
	/** 基础价格 */
	private BigDecimal basePrice;
	
	/** 发布状态(1 开启, 2 停用) */
	private int isOpen;
	
	/** 创建时间 */
	private String createDate;
	
	/** 停用时间 */
	private String stopDate;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getApiName() {
		return apiName;
	}

	public void setApiName(String apiName) {
		this.apiName = apiName;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getTblName() {
		return tblName;
	}

	public void setTblName(String tblName) {
		this.tblName = tblName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPrarms() {
		return prarms;
	}

	public void setPrarms(String prarms) {
		this.prarms = prarms;
	}

	public int getReturnType() {
		return returnType;
	}

	public void setReturnType(int returnType) {
		this.returnType = returnType;
	}

	public String getReturnParam() {
		return returnParam;
	}

	public void setReturnParam(String returnParam) {
		this.returnParam = returnParam;
	}

	public String getCostCondition() {
		return costCondition;
	}

	public void setCostCondition(String costCondition) {
		this.costCondition = costCondition;
	}

	public BigDecimal getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(BigDecimal basePrice) {
		this.basePrice = basePrice;
	}

	public int getIsOpen() {
		return isOpen;
	}

	public void setIsOpen(int isOpen) {
		this.isOpen = isOpen;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getStopDate() {
		return stopDate;
	}

	public void setStopDate(String stopDate) {
		this.stopDate = stopDate;
	}
	
}
