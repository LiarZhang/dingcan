package com.zhangxf.dingcan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * Swagger2配置文件
 * @author Liar
 *
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.zhangxf.dingcan.controller"))
				.paths(PathSelectors.any())
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("基础数据API说明文档")
				.description("2018.07.17测试版本")
				//.termsOfServiceUrl("http://mindao.com.cn")
				//.contact("研发部")
				.version("1.0")
				.license("The Apache License, Version 2.0")
		        .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
				.build();
	}

}
