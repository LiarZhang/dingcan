package com.zhangxf.dingcan.pojo;

import java.util.Date;
import java.util.List;

/**
 * 
 * @author Zhangxf
 *
 */
public class User {
    private Integer id;
    private String nikename;
    private String email;
    private String password;
    private Date create_time;
    private Date last_login_time;
    private int status;
  
   // private List<Role> roleList;// 一个用户具有多个角色

    public User() {
        super();
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNikename() {
		return nikename;
	}

	public void setNikename(String nikename) {
		this.nikename = nikename;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Date getLast_login_time() {
		return last_login_time;
	}

	public void setLast_login_time(Date last_login_time) {
		this.last_login_time = last_login_time;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
}
