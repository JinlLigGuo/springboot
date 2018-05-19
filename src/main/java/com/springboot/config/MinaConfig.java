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
* @Title: MinaConfig.java 
* @Package com.springboot.config 
* @Description: TODO(用一句话描述该文件做什么) 
* @author liguo.jin
* @date 2018年5月17日 下午5:34:08 
* @version V1.0   
*/
package com.springboot.config;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.keepalive.KeepAliveFilter;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springboot.running.mina.CalculatorHandler;
import com.springboot.running.mina.codec.CommandCodecFactory;
import com.springboot.running.mina.filter.MyFilter;
import com.springboot.running.mina.filter.keepalive.KeepAliveMessageFactoryImpl;

/**
 * 
 * @ClassName: MinaConfig
 * @Description: (这里用一句话描述这个类的作用)
 * @author liguo.jin
 * @date 2018年5月17日 下午5:34:08
 * 
 */
@Configuration
@ConfigurationProperties(prefix = "mina")
public class MinaConfig {
	
	private static Logger log = LoggerFactory.getLogger(MinaConfig.class);
	
	private int port;
	
	
    @Bean(initMethod = "bind", destroyMethod = "unbind")
	public IoAcceptor mina() throws IOException{
		
        IoAcceptor acceptor = new NioSocketAcceptor();

        acceptor.getFilterChain().addLast("logger", new LoggingFilter());
        acceptor.getFilterChain().addLast("myfliter", new MyFilter());
        acceptor.getFilterChain().addLast("codec", new ProtocolCodecFilter(new CommandCodecFactory("UTF-8")));

        KeepAliveMessageFactoryImpl kamfi = new KeepAliveMessageFactoryImpl();
        KeepAliveFilter kaf = new KeepAliveFilter(kamfi, IdleStatus.BOTH_IDLE);
        /** 是否回发 */
        kaf.setForwardEvent(true);
        acceptor.getFilterChain().addLast("heart", kaf);

        acceptor.setHandler(new CalculatorHandler());
        acceptor.bind(new InetSocketAddress(port));

        log.info("socket通信服务端已启动，端口是" + port);
        //System.out.println( "socket通信服务端已启动，端口是" + port );
        return acceptor;
	}

	public int getPort() {
		return port;
	}


	public void setPort(int port) {
		this.port = port;
	}
	

}
