package com.zhangxf.dingcan.aop;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class LogAspect {
	
	private static final Logger LOG = LoggerFactory.getLogger(LogAspect.class);
	
	//切入点
	@Pointcut("execution(public * com.zhangxf.dingcan.controller..*(..))")//两个..代表所有子目录，最后括号里的两个..代表所有参数
	public void  logPointCut(){
	}
	
	@Before("logPointCut()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        LOG.info("请求地址 : " + request.getRequestURL().toString());
        LOG.info("请求方式HTTP METHOD : " + request.getMethod());
        LOG.info("IP : " + request.getRemoteAddr());
        LOG.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "."
                + joinPoint.getSignature().getName());
        LOG.info("参数 : " + Arrays.toString(joinPoint.getArgs()));

    }

    @AfterReturning(returning = "ret", pointcut = "logPointCut()")// returning的值和doAfterReturning的参数名一致
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        LOG.info("返回值 : " + ret.toString());
    }

    @Around("logPointCut()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object ob = pjp.proceed();// ob 为方法的返回值
        LOG.info("耗时 : " + (System.currentTimeMillis() - startTime));
        return ob;
    }
    /**
     *  异常通知 记录操作报错日志
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(pointcut = "logPointCut()", throwing = "e")  
    public  void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
    	StringBuffer sb=new StringBuffer();
    	sb.append(e.toString()).append("\n");
    	for (int i = 0; i < e.getStackTrace().length; i++) {
			if(i<5){
				sb.append("     "+"at  ");
	    		sb.append(e.getStackTrace()[i]);
				sb.append("\n");
			}
		}
    	LOG.info("异常:"+sb.toString());
    }
}
