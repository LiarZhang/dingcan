package com.zhangxf.dingcan;

public class TestSubString {

	public static void main(String[] args) {
		String url="http://10.2.9.190:8080/managerManager/getManagerList";
		/*String[] str=url.split("/");
		for (String string : str) {
			System.out.println(string);
		}*/
		System.out.println("/"+url.split("/")[3]+"/"+url.split("/")[4]);
	}

}
