package com.zhangxf.dingcan.controller;


import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhangxf.dingcan.pojo.User;


@Controller
@RequestMapping("/hello")
public class HelloController {
	private static final Logger LOG = LoggerFactory.getLogger(HelloController.class);
	@RequestMapping("/get")
	@ResponseBody
	public User get(){
		User user=new User();
		user.setId(1);
		user.setNikename("1998.01.08");
		user.setStatus(1);
		user.setEmail("张三@163.com");
	//	LOG.info("执行helloController");
		return user;
	}
	@RequestMapping(value = "/login")  
	   public String login(HttpServletRequest request, Model model){ 
		System.out.println("-------------.>");
	       String username=request.getParameter("username");  
	       String password=request.getParameter("password"); 
	       System.out.println(username+"-------------.>"+password);
	       if((username!=null && password!=null)){  
	           UsernamePasswordToken token=new UsernamePasswordToken(username,password);  
	           System.out.println(username+"-------------.>"+token);
	           Subject subject= SecurityUtils.getSubject();
	           System.out.println(subject+"------------1>");
	           try{  
	        	   System.out.println(username+"-------------2>"+token);
	               subject.login(token);  
	           }catch (AuthenticationException e){  
	               
	           }  
	           if( subject.isAuthenticated()){  
	               subject.logout();  
	               System.out.println("认证成功");  
	               model.addAttribute("username",username);  
	               return "/loginsuccess";  
	           }else {  
	              // model.addAttribute("exception",customException.getMessage());  
	               return "/refuse";  
	           }  
	       }  
	       return "login";  
	   }  
	
}
