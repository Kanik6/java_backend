package com.shoppp.demoShop;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class DemoShopApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(DemoShopApplication.class, args);

	}

	@Bean
	public Docket shopApi()
	{
		Docket docket = new Docket(DocumentationType.SWAGGER_2);

		ApiInfo metaData = new ApiInfo
				(
						"Shop Api Documentation",
						"Spring boot rest Api",
						"1.0",
						"Terms of conditions",
						new Contact("Kanik", "Kanik.qq.com", "Kanik@qq.com"),
						"Attractor license",
						"Attractor.com License"
				);

		return docket.select().apis(RequestHandlerSelectors
				.basePackage("com.shoppp.demoShop.controller")).build().apiInfo(metaData);
	}


}
