package com.zhangxf.dingcan.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.zhangxf.dingcan.common.websocket.message.RequestMessage;
import com.zhangxf.dingcan.common.websocket.message.ResponseMessage;

@Controller
public class WSController {
	//@SendTo注解表示当服务器有消息需要推送的时候，会对订阅了@SendTo中路径的浏览器发送消息
    @MessageMapping("welcome")
    @SendTo("/topic/getResponse")
    public ResponseMessage say(RequestMessage msg) {
    	System.out.println(msg.getMessage());
    	
        return new ResponseMessage("welcome," + msg.getMessage() + " !");
    }
}
