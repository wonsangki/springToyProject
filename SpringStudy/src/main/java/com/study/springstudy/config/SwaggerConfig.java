package com.study.springstudy.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final String API_NAME = "Spring Study";
    private static final String API_VERSION = "0.0.1";
    private static final String API_DESCRIPTION = "Spring Study 명세서";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any()) // 특정 패키지경로를 API문서화 한다. 1차 필터
                .paths(PathSelectors.any()) // apis중에서 특정 path조건 API만 문서화 하는 2차 필터
                .build()
                .groupName("API 1.0.0") // group별 명칭을 주어야 한다.
                .pathMapping("/")
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false); // 400,404,500 .. 표기를 ui에서 삭제한다.
    }

    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(API_NAME)
                .version(API_VERSION)
                .description(API_DESCRIPTION)
                .termsOfServiceUrl("")
                .license("")
                .licenseUrl("")
                .build()
                ;
    }

}
