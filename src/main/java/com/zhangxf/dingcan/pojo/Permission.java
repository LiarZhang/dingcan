package com.zhangxf.dingcan.pojo;

public class Permission {

	private Integer id;
    private String permissionname;
    private Role role;// 一个权限对应一个角色
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPermissionname() {
		return permissionname;
	}
	public void setPermissionname(String permissionname) {
		this.permissionname = permissionname;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Permission [id=" + id + ", permissionname=" + permissionname + ", role=" + role + "]";
	}
    
}
