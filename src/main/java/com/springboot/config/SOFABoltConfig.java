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
* @Title: SOFABoltConfig.java 
* @Package com.springboot.config 
* @Description: TODO(用一句话描述该文件做什么) 
* @author liguo.jin
* @date 2018年5月24日 下午8:41:00 
* @version V1.0   
*/
package com.springboot.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alipay.remoting.ConnectionEventType;
import com.alipay.remoting.rpc.RpcClient;
import com.springboot.running.sofaBolt.common.BoltServer;
import com.springboot.running.sofaBolt.common.CONNECTEventProcessor;
import com.springboot.running.sofaBolt.common.DISCONNECTEventProcessor;
import com.springboot.running.sofaBolt.common.SimpleClientUserProcessor;
import com.springboot.running.sofaBolt.common.SimpleServerUserProcessor;


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
* @ClassName: SOFABoltConfig 
* @Description: (这里用一句话描述这个类的作用) 
* @author liguo.jin
* @date 2018年5月24日 下午8:41:00 
*  
*/
@Configuration 
public class SOFABoltConfig {
	
    /** logger */
    private static final Logger logger  = LoggerFactory.getLogger(SOFABoltConfig.class);

	@Autowired
	private SimpleServerUserProcessor simpleServerUserProcessor;
	@Autowired
	private CONNECTEventProcessor cONNECTEventProcessor ;
	@Autowired
	private DISCONNECTEventProcessor dISCONNECTEventProcessor;
	
	
	
	/**
	 *  sever
	 */
	@Bean(name="BoltServer")
	public BoltServer boltServer() {  
		
		// 1. create a Rpc server with port assigned
		BoltServer server = new BoltServer(8999);
		// 2. add processor for connect and close event if you need
		/*server.addConnectionEventProcessor(ConnectionEventType.CONNECT,    serverConnectProcessor);
		server.addConnectionEventProcessor(ConnectionEventType.CLOSE,   serverDisConnectProcessor);
		// 3. register user processor for client request
		server.registerUserProcessor(serverUserProcessor);*/
		server.addConnectionEventProcessor(ConnectionEventType.CONNECT,    cONNECTEventProcessor);
		server.addConnectionEventProcessor(ConnectionEventType.CLOSE,   dISCONNECTEventProcessor);
		// 3. register user processor for client request
		server.registerUserProcessor(simpleServerUserProcessor);
		// 4. server start
		server.start();
		
		logger.info("server start ok!");
        return server;  
    }  
	
	/*@Bean(name ="SimpleServerUserProcessor")
	public SimpleServerUserProcessor simpleServerUserProcessor(){
		return new SimpleServerUserProcessor();
	}
	
	@Bean(name="CONNECTEventProcessor")
	public CONNECTEventProcessor CONNECTEventProcessor(){
		return new  CONNECTEventProcessor();
	}
	
	@Bean(name="DISCONNECTEventProcessor")
	public  DISCONNECTEventProcessor DISCONNECTEventProcessor(){
		return new DISCONNECTEventProcessor();
	}*/
	
	
	/**
	 *  client
	 */
	//@Bean(name="rpcClient")
	public RpcClient rpcClient(){
		RpcClient client = new RpcClient();
        // 2. add processor for connect and close event if you need
        //client.addConnectionEventProcessor(ConnectionEventType.CONNECT, clientConnectProcessor);
        //client.addConnectionEventProcessor(ConnectionEventType.CLOSE, clientDisConnectProcessor);
        // 3. do init
        client.init();
		return client;
	}
	
	@Bean(name="SimpleClientUserProcessor")
	public SimpleClientUserProcessor SimpleClientUserProcessor(){
		return new SimpleClientUserProcessor();
	}
	
	
}
