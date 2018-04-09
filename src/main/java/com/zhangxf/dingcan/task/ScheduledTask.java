package com.zhangxf.dingcan.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/*
 * @date: 2018年1月8日
 * @author: Zhangxf
 * @version :1.0.0
*/
@Component
public class ScheduledTask {
	//@Scheduled(fixedRate = 3000)//关闭
	public void helloTask(){
		String date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		System.out.println("时间:"+date);
	}
}
