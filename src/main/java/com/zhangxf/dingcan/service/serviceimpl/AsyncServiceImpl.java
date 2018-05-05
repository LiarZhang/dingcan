package com.zhangxf.dingcan.service.serviceimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.zhangxf.dingcan.service.AsyncService;

@Service
public class AsyncServiceImpl implements AsyncService {

	private static final Logger logger = LoggerFactory.getLogger(AsyncServiceImpl.class);

	@Override
	@Async("taskExecutor")
	public void executeAsync() {
		logger.info("start executeAsync");
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("end executeAsync");
	}
}