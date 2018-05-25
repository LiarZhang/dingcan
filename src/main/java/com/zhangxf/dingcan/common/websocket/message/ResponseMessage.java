package com.zhangxf.dingcan.common.websocket.message;
/**
 * 服务器返回给浏览器的消息由这个类来承载：
 * @author Liar
 *
 */
public class ResponseMessage {
	private String responseMessage;

	public ResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

}
