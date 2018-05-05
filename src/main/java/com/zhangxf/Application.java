package com.zhangxf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling//定时
@EnableAsync//异步
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
