/**
 * Project Name: fastdfs
 * File Name: SwaggerConfig
 * Package Name: com.example.fastdfs.config
 * Date: 2020/11/3 10:02
 * Author: 方瑞冬
 */
package com.example.fastdfs.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author 方瑞冬
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())         //Swagger 汇总信息
                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))  //指定接口包名
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))     //指定接口，这种方式更好
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger 标题")                        //swagger 标题
                .version("v1.0.0")                            //版本
                .description("这里是标题的补充描述")          //标题的补充描述
                .termsOfServiceUrl("https://www.baidu.com")   //服务协议
                .contact(new Contact(                         //联系人信息
                        "小明",                               //联系人姓名
                        "https://www.baidu.com",              //联系人 URL
                        "swagger@swagger.com"                 //联系人邮箱
                ))
                .license("license 许可")                      //许可
                .licenseUrl("https://www.baidu.com")          //许可 URL
                .build();
    }
}
