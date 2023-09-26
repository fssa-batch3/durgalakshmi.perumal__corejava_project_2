package com.fssa.livre.model;

public class UserRequestABook {
    private int requestId;
    private String email;
    private String bookName;
    private String imageUrl;
    private String description;
    private String status;
    private String author;




    public UserRequestABook(int requestId, String email, String bookName, String imageUrl, String status, String declineReason, String description) {
        this.requestId = requestId;
        this.email = email;
        this.bookName = bookName; 
        this.imageUrl = imageUrl;
        this.description = description;
        this.status = status;
    }

    

    public UserRequestABook( String email, String bookName, String imageUrl,String status, String description) {
        this.email = email;
        this.bookName = bookName;
        this.imageUrl = imageUrl;
        this.description = description;
        this.status = status;

       
    }
    
    
    public UserRequestABook(String email) {
		
	}

	public UserRequestABook(String email, int requestId, String bookName, String imageUrl, String status,
			String declineReason) {
		// TODO Auto-generated constructor stub
	}
 
	public UserRequestABook() {
		// TODO Auto-generated constructor stub
	}





	  public UserRequestABook(int id, String email, String bookName, String imageUrl, String description, String status) {
	        this.requestId = id;
	        this.email = email;
	        this.bookName = bookName;
	        this.imageUrl = imageUrl;
	        this.description = description;
	        this.status = status;
	    }

	public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
