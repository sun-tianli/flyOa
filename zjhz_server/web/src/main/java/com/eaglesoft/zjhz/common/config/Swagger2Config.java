package com.eaglesoft.zjhz.common.config;

import com.eaglesoft.zjhz.common.constant.BaseConstant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//参考：http://blog.csdn.net/catoop/article/details/50668896
//swagger-ui.html
@Configuration
@EnableSwagger2
//@ConditionalOnProperty(prefix = "swagger",value = {"enable"},havingValue = "true")
public class Swagger2Config {
    private final static String BasePackage = "com.eaglesoft.zjhz";

    @Bean
    public Docket createRestApi() {
        List<Parameter> aParameters = new ArrayList<>();
        //可以添加多个header或参数
        ParameterBuilder aParameterBuilder = new ParameterBuilder();
        aParameterBuilder
                .parameterType("header") //参数类型支持header, cookie, body, query etc
                .name(BaseConstant.TOKEN_AUTH_HEADER) //参数名
                //.name("username")
                //.name("password")
//                .defaultValue("token") //默认值
                .description("header中token")
                .modelRef(new ModelRef("string"))//指定参数值的类型
                .required(false).build(); //非必需，这里是全局配置，然而在登陆的时候是不用验证的
        aParameters.add(aParameterBuilder.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .directModelSubstitute(LocalDateTime.class, Date.class)
                .directModelSubstitute(LocalDate.class, String.class)
                .directModelSubstitute(LocalTime.class, String.class)
                .directModelSubstitute(ZonedDateTime.class, String.class)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(BasePackage))
                .paths(PathSelectors.any())
                .build().globalOperationParameters(aParameters);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Demo")
                .description("EagleSoft官网：http://eaglesoft.com.cn")
                .contact("EagleSoft")
                .version("1.0")
                .build();
    }

}