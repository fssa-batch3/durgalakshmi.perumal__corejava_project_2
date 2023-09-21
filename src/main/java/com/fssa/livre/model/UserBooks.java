package com.fssa.livre.model;

import com.google.protobuf.Timestamp;

public class UserBooks {
	  private int userBookId;
	    private  int userId;
	    private int readBookId;
	    private boolean status;
	    private Timestamp createdAt;
		public int getUserBookId() {
			return userBookId;
		}
		public UserBooks(int userBookId, int userId,int readBookId, boolean status) {
			super();
			this.userBookId = userBookId;
			this.userId = userId;
			this.readBookId = readBookId;
			this.status = status;
		
		}
		
	    public UserBooks(int userId, int readBookId) {
	        this.userId = userId;
	        this.readBookId = readBookId;
	  
	    }
	
	
		public void setUserBookId(int userBookId) {
			this.userBookId = userBookId;
		}
		public int getUserId() {
			return userId;
		}
		public void setUserId(int userId) {
			this.userId = userId;
		}
		public int getReadBookId() {
			return readBookId;
		}
		public void setReadBookId(int readBookId) {
			this.readBookId = readBookId;
		}
		public boolean isStatus() {
			return status;
		}
		public void setStatus(boolean status) {
			this.status = status;
		}
		public Timestamp getCreatedAt() {
			return createdAt;
		}
		public void setCreatedAt(Timestamp createdAt) {
			this.createdAt = createdAt;
		}
}
