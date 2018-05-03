package com.zhangxf;
import java.io.UnsupportedEncodingException;
public class TestUnicode {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String chinese = "中文";//java内部编码
		String gbkChinese = new String(chinese.getBytes("GBK"),"ISO-8859-1");//转换成gbk编码
		String unicodeChinese = new String(gbkChinese.getBytes("ISO-8859-1"),"GBK");//java内部编码
		System.out.println(unicodeChinese);//中文
		String utf8Chinese = new String(unicodeChinese.getBytes("UTF-8"),"ISO-8859-1");//utf--8编码
		System.out.println(utf8Chinese);//乱码
		unicodeChinese = new String(utf8Chinese.getBytes("ISO-8859-1"),"UTF-8");//java内部编码
		System.out.println(unicodeChinese);//中文
		
	}

	

}
