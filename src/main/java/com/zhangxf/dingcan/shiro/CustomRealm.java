package com.zhangxf.dingcan.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zhangxf.dingcan.pojo.User;
import com.zhangxf.dingcan.service.UserService;

//@Component
public class CustomRealm extends AuthorizingRealm {
	
	private static final Logger LOG = LoggerFactory.getLogger(CustomRealm.class);
	
	@Autowired
	private UserService userService;

	// 登录认证
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
			throws AuthenticationException {
		UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;
		String username = userToken.getUsername();
		
		
		User user = userService.findByUsername(username);
		if (null == user) {
			LOG.info("账号或密码不正确");
			return null;
		}else{
			String DBpassword = user.getPassword();
			LOG.info("realm中DB的password："+DBpassword);
			LOG.info("realm中token的password："+String.valueOf(userToken.getPassword()));
			
			if(!DBpassword.equals(String.valueOf(userToken.getPassword()))){
				LOG.info("密码不正确");
			}
		}
		// 如果查询到了，封装查询结果，返回给我们的调用
        Object principal = username;
        Object credentials = user.getPassword();
		// 获取盐值，即用户名
        ByteSource salt = ByteSource.Util.bytes(username);
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(principal,
				credentials,salt, this.getName());
		return simpleAuthenticationInfo;
		
		
	}

	// 授权
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		return null;
	}
	
	

}
