package com.zhangxf.dingcan.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zhangxf.dingcan.pojo.User;
import com.zhangxf.dingcan.service.UserService;

@Component
public class CustomRealm extends AuthorizingRealm  {

	    @Autowired  
	    private UserService userService;  
	  
	    //登录认证  
	    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {  
	  
	        String username= (String) authenticationToken.getPrincipal();  
	        User user=userService.findByUsername(username);  
	        if(user==null){  
	            return null;  
	        }  
	        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username,user.getPassword(),this.getName());  
	        return simpleAuthenticationInfo;  
	    }  
	  
	    //授权  
	    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {  
	        return null;  
	    }  
	  
}
