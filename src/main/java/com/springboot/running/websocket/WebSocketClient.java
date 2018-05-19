package com.springboot.running.websocket;

import java.net.URI;
import java.util.concurrent.CountDownLatch;

import javax.websocket.ClientEndpoint;
import javax.websocket.ContainerProvider;
import javax.websocket.WebSocketContainer;

import org.aspectj.apache.bcel.generic.InstructionConstants.Clinit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @ClassName: Cint
 * @Description: (这里用一句话描述这个类的作用)
 * @author liguo.jin
 * @date 2018年5月16日 下午8:11:59
 * 
 */
@Controller
@RequestMapping("websocketclient")
@ClientEndpoint
public class WebSocketClient {

	@Autowired
	private ClientMethod client;

	//@Autowired
	@RequestMapping("/client")
	public void clinitWebsoct() {
		try {
			WebSocketContainer container = ContainerProvider.getWebSocketContainer();
			client = new ClientMethod();
			container.connectToServer(client, new URI("ws://localhost:8082/webSocketServer/222"));
			new CountDownLatch(1).await();
			// container.setDefaultMaxSessionIdleTimeout(5000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@RequestMapping("/send")
	public void send() {
		try {
			client.send("client send: " + "说话");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	

	public static void main(String[] args) {
		try {
			WebSocketContainer container = ContainerProvider.getWebSocketContainer();
			ClientMethod client = new ClientMethod();
			container.connectToServer(client, new URI("ws://localhost:8082/webSocketServer/222"));
			// container.setDefaultMaxSessionIdleTimeout(5000L);
			int turn = 0;
			while (turn++ < 10) {
				client.send("client send: " + turn);
				// Thread.sleep(1000);
				new CountDownLatch(1).await();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
