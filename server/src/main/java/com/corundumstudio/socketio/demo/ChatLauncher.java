package com.corundumstudio.socketio.demo;

import com.corundumstudio.socketio.listener.*;
import com.corundumstudio.socketio.*;

import java.util.Iterator;

public class ChatLauncher {

    public static void main(String[] args) throws InterruptedException {

        Configuration config = new Configuration();
        config.setHostname("localhost");
        config.setPort(9092);

        final SocketIOServer server = new SocketIOServer(config);
        server.addEventListener("chatevent", ChatObject.class, new DataListener<ChatObject>() {
            @Override
            public void onData(SocketIOClient client, ChatObject data, AckRequest ackRequest) {
                // This is used to send a message to all connected users
                System.out.println("chatevent");
                Iterator iter = client.getAllRooms().iterator();
                while (iter.hasNext()) {
                    System.out.println(iter.next());
                }
                server.getBroadcastOperations().sendEvent("chatevent", data);
            }
        });
        server.addEventListener("joinRoom", ChatRoom.class, new DataListener<ChatRoom>() {
            @Override
            public void onData(SocketIOClient client, ChatRoom roomName, AckRequest ackRequest) {
                // join a room
                System.out.println("Joining a room");
                System.out.println(client.getHandshakeData());
                System.out.println(roomName.getRoomName());
                client.joinRoom(roomName.getRoomName());
            }
        });
        server.addEventListener("sendToRoom", ChatObject.class, new DataListener<ChatObject>() {
            @Override
            public void onData(SocketIOClient client, ChatObject data, AckRequest ackRequest) {
                System.out.println("Send to Room");
                System.out.println("    userName:"+data.getUserName());
                System.out.println("    send To:"+data.getSendTo());
                System.out.println("    from:"+data.getSendFrom());
                System.out.println("    message:"+data.getMessage());
                server.getRoomOperations(data.getSendTo()).sendEvent("sendToRoom", data);
                server.getRoomOperations(data.getSendFrom()).sendEvent("sendToRoom", data);
            }
        });
        server.start();

        Thread.sleep(Integer.MAX_VALUE);

        server.stop();
    }

}
