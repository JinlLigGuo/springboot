/**  
 * Project Name:jlg_lab  
 * File Name:NettyGlobal.java  
 * Package Name:com.jin.jlg.netty.websock  
 * Date:2018年1月8日下午5:11:37  
 * Copyright (c) 2018, chenzhou1025@126.com All Rights Reserved.  
 *  
*/  
  
package com.springboot.running.sofaBolt;  

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import org.apache.ibatis.javassist.expr.NewArray;

import com.alipay.remoting.Connection;

import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**  
 * ClassName:NettyGlobal 
 * Function: TODO ADD FUNCTION. 
 * Reason:   TODO ADD REASON. 
 * Date:     2018年1月8日 下午5:11:37 
 * @author   .jin  	
 * @version    
 * @see        
 */
public class SofaBoltGlobal {
	
	
	public static List<Connection> connections  = new CopyOnWriteArrayList< Connection>();
	
	public static Map<String,Connection> connectionsMap  = new ConcurrentHashMap<String,Connection> ();
	
	
	public static List<Map<String,Connection>> connectionsList  = new CopyOnWriteArrayList<Map<String, Connection>>();
	
	/*public static ChannelGroup group = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);  
	
	//管道
	//Map<直播间id,管道>
	public static Map<Integer, ChannelGroup> groupMap = new ConcurrentHashMap<Integer, ChannelGroup>();
	
	// 所有直播间信息(暂时用于广播)
	// Map<设备id,直播间id>
	// 作用：直播间对应多台机器
	public static List<Map<Integer, Integer>> roomList = new CopyOnWriteArrayList<Map<Integer, Integer>>();
	
	//各个直播间人数
	//Map<直播间id，人数>
	//作用：随机生成基数
	public static Map<Integer, Integer> peopleNum = new ConcurrentHashMap<Integer, Integer>();
	
	static {
		groupMap.put("room1", new DefaultChannelGroup(GlobalEventExecutor.INSTANCE));
		groupMap.put("room2", new DefaultChannelGroup(GlobalEventExecutor.INSTANCE));
		groupMap.put("room3", new DefaultChannelGroup(GlobalEventExecutor.INSTANCE));
		groupMap.put("room4", new DefaultChannelGroup(GlobalEventExecutor.INSTANCE));
		groupMap.put("room5", new DefaultChannelGroup(GlobalEventExecutor.INSTANCE));
		groupMap.put("room6", new DefaultChannelGroup(GlobalEventExecutor.INSTANCE));
	}
	
	*/
}


  
