package org.opensource.demo.api.vo;

import java.sql.Timestamp;

/**
 * @ClassName: TODO
 * @Description: TODO
 * @author caoshuo@163.com  
 * @date 2017年12月1日 下午6:32:32
 * @since V1.0
 */

public class BaseVO {

	protected String linkChannel;
	protected Timestamp createdGmt;
	protected Timestamp modifiedGmt;
	
	public String getLinkChannel() {
		return linkChannel;
	}
	public void setLinkChannel(String linkChannel) {
		this.linkChannel = linkChannel;
	}
	public Timestamp getCreatedGmt() {
		return createdGmt;
	}
	public void setCreatedGmt(Timestamp createdGmt) {
		this.createdGmt = createdGmt;
	}
	public Timestamp getModifiedGmt() {
		return modifiedGmt;
	}
	public void setModifiedGmt(Timestamp modifiedGmt) {
		this.modifiedGmt = modifiedGmt;
	}
	
	@Override
	public String toString() {
		return "linkChannel=" + linkChannel 
				+ ", createdGmt=" + createdGmt 
				+ ", modifiedGmt=" + modifiedGmt;
	}
	
}