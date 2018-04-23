package com.zhangxf.dingcan.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zhangxf.dingcan.pojo.User;
import com.zhangxf.dingcan.service.UserService;

@Component
public class CustomRealm extends AuthorizingRealm {
	
	private static final Logger LOG = LoggerFactory.getLogger(CustomRealm.class);
	
	@Autowired
	private UserService userService;

	// 登录认证
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
			throws AuthenticationException {
		UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;
		String username = userToken.getUsername();
		String password = String.valueOf(userToken.getPassword());
		User user = userService.findByUsername(username);
		if (null == user) {
			LOG.info("账号不存在");
			return null;
		}
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username,
				password.toCharArray(), this.getName());
		return simpleAuthenticationInfo;
	}

	// 授权
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		return null;
	}

}
