package com.sxmaps.mms.vo.resp;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@SuppressWarnings("serial")
@ApiModel(description = "协议管理返回VO")
public class RespProtocolLevelVO implements Serializable {

	@ApiModelProperty(name = "proName", value = "协议名称", example = "成人本科协议", allowEmptyValue = false)
	private String proName;

	@ApiModelProperty(name = "content", value = "协议内容", example = "AAAAABBBBB", allowEmptyValue = false)
	private String content;

	@ApiModelProperty(name = "version", value = "协议版本号", example = "1.0", allowEmptyValue = false)
	private String version;

	@ApiModelProperty(name = "levelId", value = "层级ID", example = "202", allowEmptyValue = false)
	private String levelId;

	@ApiModelProperty(name = "levelName", value = "层级名称", example = "远程本科", allowEmptyValue = false)
	private String levelName;
	
	@ApiModelProperty(value = "附加协议", example = "协议补充")
	private String supplyProtocol;  
	
	@ApiModelProperty(value = "签名url")
	private String signUrl;
	@ApiModelProperty(value = "签署时间")
	private String signTime;
	@ApiModelProperty(value = "协议标题")
	private String contractName;
	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getLevelId() {
		return levelId;
	}

	public void setLevelId(String levelId) {
		this.levelId = levelId;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public String getSupplyProtocol() {
		return supplyProtocol;
	}

	public void setSupplyProtocol(String supplyProtocol) {
		this.supplyProtocol = supplyProtocol;
	}

	public String getSignUrl() {
		return signUrl;
	}

	public void setSignUrl(String signUrl) {
		this.signUrl = signUrl;
	}

	public String getSignTime() {
		return signTime;
	}

	public void setSignTime(String signTime) {
		this.signTime = signTime;
	}

	public String getContractName() {
		return contractName;
	}

	public void setContractName(String contractName) {
		this.contractName = contractName;
	}

	@Override
	public String toString() {
		return "RespProtocolLevelVO [proName=" + proName + ", content=" + content + ", version=" + version
				+ ", levelId=" + levelId + ", levelName=" + levelName + ", supplyProtocol=" + supplyProtocol
				+ ", signUrl=" + signUrl + ", signTime=" + signTime + ", contractName=" + contractName + "]";
	}

}