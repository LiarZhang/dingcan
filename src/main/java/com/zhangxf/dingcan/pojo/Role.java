package com.zhangxf.dingcan.pojo;

import java.util.List;

/**
 * 
 * @author Zhangxf
 *
 */
public class Role {
	private Integer id;
	private String rolename;
	private List<Permission> permissionList;// 一个角色对应多个权限
	private List<User> userList;// 一个角色对应多个用户
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public List<Permission> getPermissionList() {
		return permissionList;
	}
	public void setPermissionList(List<Permission> permissionList) {
		this.permissionList = permissionList;
	}
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", rolename=" + rolename + ", permissionList=" + permissionList + ", userList="
				+ userList + "]";
	}

}
