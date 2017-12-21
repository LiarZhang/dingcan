package com.zhangxf.dingcan.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(-99) // 控制多个Aspect的执行顺序，越小越先执行
@Component
public class TestAspect {
		
		@Before("execution(public * com.zhangxf.dingcan..*(..))")// 拦截方法；如果你需要拦截指定package指定规则名称的方法，可以使用表达式execution(...)
	    public void beforeTest(JoinPoint point) throws Throwable {
	        System.out.println("before:---->");
	    }

	    @After("execution(public * com.zhangxf.dingcan..*(..))")
	    public void afterTest(JoinPoint point) {
	        System.out.println("after:----->");
	    }
}
