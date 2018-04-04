package org.opensource.demo.api.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @ClassName: TODO
 * @Description: TODO
 * @author caoshuo@163.com  
 * @date 2017年12月1日 下午6:32:32
 * @since V1.0
 */

public abstract class BaseModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	protected Timestamp createdGmt;
	protected Timestamp modifiedGmt;

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
		return "createdGmt=" + createdGmt + ", modifiedGmt=" + modifiedGmt;
	}
	
}