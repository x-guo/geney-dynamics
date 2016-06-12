package com.ufenqi.marketauth.dal.param;

import java.util.Date;

import com.cheng.common.dal.query.MapperQuery;


public class MarketAuthParam extends MapperQuery{
    private static final long serialVersionUID = 0L;

	    private Long id;
        private Date createDate;
        private Date updateDate;
        private Long version;
        private String authPic1;
        private String authPic2;
        private String authPic3;
        private Long userId;
        private String status;
        private String note;
        
    
        public void  setId(Long id){
    	this.id=id;
    }
    
    public Long getId(){
    	return id;
    }
        public void  setCreateDate(Date createDate){
    	this.createDate=createDate;
    }
    
    public Date getCreateDate(){
    	return createDate;
    }
        public void  setUpdateDate(Date updateDate){
    	this.updateDate=updateDate;
    }
    
    public Date getUpdateDate(){
    	return updateDate;
    }
        public void  setVersion(Long version){
    	this.version=version;
    }
    
    public Long getVersion(){
    	return version;
    }
        public void  setAuthPic1(String authPic1){
    	this.authPic1=authPic1;
    }
    
    public String getAuthPic1(){
    	return authPic1;
    }
        public void  setAuthPic2(String authPic2){
    	this.authPic2=authPic2;
    }
    
    public String getAuthPic2(){
    	return authPic2;
    }
        public void  setAuthPic3(String authPic3){
    	this.authPic3=authPic3;
    }
    
    public String getAuthPic3(){
    	return authPic3;
    }
        public void  setUserId(Long userId){
    	this.userId=userId;
    }
    
    public Long getUserId(){
    	return userId;
    }
        public void  setStatus(String status){
    	this.status=status;
    }
    
    public String getStatus(){
    	return status;
    }
        public void  setNote(String note){
    	this.note=note;
    }
    
    public String getNote(){
    	return note;
    }
    }
