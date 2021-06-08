package com.sxmaps.mms.vo;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;

@SuppressWarnings("serial")
public class OssFilePathVo implements Serializable {

	@ApiModelProperty("文件路径: image/20180420041201654.png ")
	private List<String> filePaths;

	@ApiModelProperty("私有照片缩放: image/resize,m_fixed,w_100,h_100/rotate,90")
	private String imgStyle;

	public List<String> getFilePaths() {
		return filePaths;
	}

	public void setFilePaths(List<String> filePaths) {
		this.filePaths = filePaths;
	}

	public String getImgStyle() {
		return imgStyle;
	}

	public void setImgStyle(String imgStyle) {
		this.imgStyle = imgStyle;
	}

	@Override
	public String toString() {
		return "OssFilePathVo [filePaths=" + filePaths + ", imgStyle=" + imgStyle + "]";
	}

}
