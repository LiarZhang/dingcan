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

import com.zhangxf.dingcan.utils.MD5Util;
@Controller
public class LoginController {
	private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);
	@ResponseBody
	@RequestMapping(value = "/login")
	public String login(HttpServletRequest request, Model model) {
		String username = request.getParameter("username");
		username = "soso";
		String password = request.getParameter("password");
		password = MD5Util.MD5("123456");
		//password = "123456";
		System.out.println(password);
		
		if ((username != null && password != null)) {
			UsernamePasswordToken token = new UsernamePasswordToken(username, password.toCharArray());
			Subject subject = SecurityUtils.getSubject();
			try {
				subject.login(token);
			} catch (AuthenticationException e) {
				LOG.info("认证-----失败");
				return "/refuse";
			}
			if (subject.isAuthenticated()) {
				subject.logout();
				LOG.info("认证成功");
				model.addAttribute("username", username);
				return "/loginsuccess";
			}
		}
		return "login";
	}
}
