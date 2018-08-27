package com.dhu.websocket;

import org.springframework.stereotype.Component;
import java.util.Map;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.ConcurrentHashMap;

//@Component
//@ServerEndpoint("/websocket/{user_id}")
public class Websocket {
    private int user_id;
    private Session session;
    private static Map<Integer, Websocket> onlineUsers=new ConcurrentHashMap<>();

    @OnOpen
    public void onopen(Session session, @PathParam("user_id") int user_id){
        this.user_id=user_id;
        this.session=session;
        onlineUsers.put(user_id,this);
        System.out.println(user_id+"连接");
    }

    @OnClose
    public void onclose(Session session)throws Exception{
       onlineUsers.remove(user_id);
        System.out.println(user_id+"断开");
    }

    @OnMessage
    public void onmessage(String message){
        sendMessages(message);
    }

    public void sendMessages(String message){
        onlineUsers.forEach((user_id,websocket)->{
            sendMessage(websocket.session,message);
        });
    }

    public void sendMessage(Session session,String message){
        session.getAsyncRemote().sendText(message);
    }
}
