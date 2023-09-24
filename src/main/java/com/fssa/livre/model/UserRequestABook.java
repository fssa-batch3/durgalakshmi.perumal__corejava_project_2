package com.fssa.livre.model;

public class UserRequestABook {
    private int requestId;
    private int userId;
    private String bookName;
    private String imageUrl;
    private String description;
    private String status;



    public UserRequestABook() {
        // Default constructor
    }

    public UserRequestABook(int requestId, int userId, String bookName, String imageUrl, String description, String status) {
        this.requestId = requestId;
        this.userId = userId;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
