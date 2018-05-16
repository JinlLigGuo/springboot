package com.springboot.running.websocket;

import java.net.URI;

import javax.websocket.ClientEndpoint;
import javax.websocket.ContainerProvider;
import javax.websocket.WebSocketContainer;


/** 
 * code is far away from bug with the animal protecting
 * ┏┓　　　┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　　┃
 * ┃　　　━　　　┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　　┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　　┃
 * ┗━┓　　　┏━┛
 * 　　┃　　　┃神兽保佑
 * 　　┃　　　┃代码无BUG！
 * 　　┃　　　┗━━━┓
 * 　　┃　　　　　　　┣┓
 * 　　┃　　　　　　　┏┛
 * 　　┗┓┓┏━┳┓┏┛
 * 　　　┃┫┫　┃┫┫
 * 　　　┗┻┛　┗┻┛
* @ClassName: Cint 
* @Description: (这里用一句话描述这个类的作用) 
* @author liguo.jin
* @date 2018年5月16日 下午8:11:59 
*  
*/
@ClientEndpoint
public class WebSocketClient {
	
	
	
	 public static void main(String[] args){
	        try {
	            WebSocketContainer container = ContainerProvider.getWebSocketContainer();
	            MyClient client = new MyClient();
	            container.connectToServer(client, new URI("ws://localhost:8082/webSocketServer/222"));
//	            container.setDefaultMaxSessionIdleTimeout(5000L);
	            int turn = 0;
	            while(turn++ < 10){
	                client.send("client send: " + turn);
	                Thread.sleep(1000);
	            }
	        }catch (Exception e){
	            e.printStackTrace();
	        }
	    }
}

