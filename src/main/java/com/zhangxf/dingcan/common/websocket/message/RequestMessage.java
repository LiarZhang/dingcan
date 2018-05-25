package com.zhangxf.dingcan.common.websocket.message;
/**
 * 浏览器发送来的消息用这个类来接收：
 * @author Liar
 *
 */
public class RequestMessage {

	 private String message;

	 public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		 return message;
	 }
}
