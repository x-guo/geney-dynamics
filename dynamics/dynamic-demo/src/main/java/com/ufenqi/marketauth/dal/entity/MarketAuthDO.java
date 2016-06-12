package com.ufenqi.marketauth.dal.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.cheng.common.dal.entity.BaseEntity;



@Entity
@Table(name="ac_auth_offline")
public class MarketAuthDO  extends BaseEntity{

	/**
	 * guozhenyu 2015-07-22
	 */
	private static final long serialVersionUID = -5262590880628997725L;

	private String authPic1;
	private String authPic2;
	private String authPic3;
	private Long userId;
	private String status;
	private String note;
	public String getAuthPic1() {
		return authPic1;
	}
	public void setAuthPic1(String authPic1) {
		this.authPic1 = authPic1;
	}
	public String getAuthPic2() {
		return authPic2;
	}
	public void setAuthPic2(String authPic2) {
		this.authPic2 = authPic2;
	}
	public String getAuthPic3() {
		return authPic3;
	}
	public void setAuthPic3(String authPic3) {
		this.authPic3 = authPic3;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
}
