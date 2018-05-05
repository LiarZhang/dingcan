package com.zhangxf.dingcan.config;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
/**
 * 线程池
 * @author Liar
 *
 */
@EnableAsync
@Configuration
public class ExecutorPoolConfig {

	private static final Logger logger = LoggerFactory.getLogger(ExecutorPoolConfig.class);
	
	
	@Bean
    public Executor taskExecutor() {
		logger.info("start asyncExecutor");
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        
        executor.setCorePoolSize(10);//配置核心线程数
        
        executor.setMaxPoolSize(20);//配置最大线程数
        executor.setQueueCapacity(200);//配置队列大小
        executor.setKeepAliveSeconds(60);
        executor.setThreadNamePrefix("asyncExecutor-");//配置线程池中的线程的名称前缀
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
      
        executor.initialize();//执行初始化
        return executor;
    }
}
