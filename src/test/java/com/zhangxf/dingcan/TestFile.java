package com.zhangxf.dingcan;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class TestFile {

	public static void main(String[] args) {

		String file="C:/Users/Liar/Desktop/黄色1.txt";
		String str=new TestFile().readTxtFile(file);
		String[] str1=str.split(",");
		for (String string : str1) {
			System.out.println(string);
		}
	}


	/**
	 * 功能：Java读取txt文件的内容 步骤：1：先获得文件句柄 2：获得文件句柄当做是输入一个字节码流，需要对这个输入流进行读取
	 * 3：读取到输入流后，需要读取生成字节流 4：一行一行的输出。readline()。 备注：需要考虑的是异常情况
	 * 
	 * @param filePath
	 */
	public static String readTxtFile(String filePath) {
		StringBuilder content = new StringBuilder("");
		try {
			File file = new File(filePath);
			if (file.isFile() && file.exists()) {
				InputStreamReader read = new InputStreamReader(new FileInputStream(file));
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					//System.out.println("---"+lineTxt);
				    //String result = getNamePhone(lineTxt);
					//System.out.println(result);
					content.append(lineTxt);
					//content.append("\r\n");// txt换行
				}
				read.close();
				System.out.println(content);
			} else {
				System.out.println("找不到指定的文件");
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}
		return content.toString();
	}
}
