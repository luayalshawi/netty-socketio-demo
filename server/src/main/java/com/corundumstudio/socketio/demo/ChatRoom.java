package com.corundumstudio.socketio.demo;

/**
 * Created by Luay on 10/23/2016.
 */
public class ChatRoom {
    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
    public ChatRoom()
    {}
    public ChatRoom(String roomName) {
        this.roomName = roomName;
    }

    String roomName;
    String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    String senderName;
}
