package com.zhangxf;

import java.util.concurrent.Future;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhangxf.dingcan.task.AsyncTask;
import com.zhangxf.dingcan.task.SynchronizedTask;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DingcanApplicationTests {

	@Autowired
	private SynchronizedTask synchronizedTask;
	
	@Autowired
	private AsyncTask asyncTask;
	
	@Test
	public void contextLoads() throws Exception {
		
		synchronizedTask.doTaskOne();
		synchronizedTask.doTaskTwo();
		synchronizedTask.doTaskThree();
	}
	
	@Test
    public void test() throws Exception {
		
		long start = System.currentTimeMillis();

		Future<String> task1 = asyncTask.doTaskOne();
		Future<String> task2 = asyncTask.doTaskTwo();
		Future<String> task3 = asyncTask.doTaskThree();

		while(true) {
			if(task1.isDone() && task2.isDone() && task3.isDone()) {
				// 三个任务都调用完成，退出循环等待
				break;
			}
			Thread.sleep(1000);
		}

		long end = System.currentTimeMillis();

		System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");

	}

}
