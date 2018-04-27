package com.zhangxf.dingcan.mail;

import java.io.File;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.commons.collections.map.HashedMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import freemarker.template.Template;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SendSimpleMail {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private FreeMarkerConfigurer freeMarkerConfigurer;  //自动注入FreeMarker模版
	/**
	 * 发送简单邮件
	 * @throws Exception
	 */
	@Test
	@Bean
	public void sendSimpleMail() throws Exception {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("mr_zxf0105@163.com");
		message.setTo("2532466427@qq.com");
		message.setSubject("主题：网易发腾讯邮件");
		message.setText("测试邮件内容：网易发腾讯邮件");

		mailSender.send(message);
	}
	/**
	 * 附件邮箱
	 * @throws Exception
	 */
	@Test
	public void sendAttachmentsMail() throws Exception {

		MimeMessage mimeMessage = mailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setFrom("mr_zxf0105@163.com");
		helper.setTo("mr_zxf0105@163.com");
		helper.setSubject("主题：有附件");
		helper.setText("有附件的邮件");

		FileSystemResource file = new FileSystemResource(new File("C:/Users/Liar/Desktop/file/tit.png"));
		helper.addAttachment("附件-1.jpg", file);
		helper.addAttachment("附件-2.jpg", file);

		mailSender.send(mimeMessage);

	}
	
	/**
	 * 引入静态资源的邮箱
	 * @throws Exception
	 */
	@Test
	public void sendInlineMail() throws Exception {

		MimeMessage mimeMessage = mailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setFrom("mr_zxf0105@163.com");
		helper.setTo("mr_zxf0105@163.com");
		helper.setSubject("主题：嵌入静态资源");
		//这里需要注意的是addInline函数中资源名称weixin需要与正文中cid:weixin对应起来
		helper.setText("<html><body><img src=\"cid:weixin\" ></body></html>", true);

		FileSystemResource file = new FileSystemResource(new File("C:/Users/Liar/Desktop/file/tit.png"));
		helper.addInline("weixin", file);

		mailSender.send(mimeMessage);

	}
	
	/**
	 * 模版邮件
	 * freemarker
	 * @throws Exception
	 */
	@Test
	public void sendTemplateMail() throws Exception {

		MimeMessage mimeMessage = mailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setFrom("mr_zxf0105@163.com");
		helper.setTo("mr_zxf0105@163.com");
		helper.setSubject("主题：模板邮件");

		Map<String, Object> model = new HashedMap();
		model.put("username", "Liar");
		//读取 html 模板
        Template template =freeMarkerConfigurer.getConfiguration().getTemplate("mail.html");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
		helper.setText(html, true);

		mailSender.send(mimeMessage);
	}
}
