package com.corundumstudio.socketio.demo;

public class ChatObject {
    private String userId;
    private String userName;
    private String message;
    private String sendFrom;
    private String sendTo;

    public ChatObject() {
    }

    public ChatObject(String userId,String userName, String message,String sendFrom,String sendTo) {
        super();
        this.userId = userId;
        this.userName = userName;
        this.message = message;
        this.sendFrom = sendFrom;
        this.sendTo = sendTo;
    }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getSendFrom() {
        return sendFrom;
    }

    public void setSendFrom(String sendFrom) {
        this.sendFrom = sendFrom;
    }

    public String getSendTo() {
        return sendTo;
    }

    public void setSendTo(String sendTo) {
        this.sendTo = sendTo;
    }
}
