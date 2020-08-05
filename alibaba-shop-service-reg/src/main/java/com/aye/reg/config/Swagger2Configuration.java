package com.aye.reg.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class Swagger2Configuration {

    /**
     *
     * @return
     *
     *  com.google.common.base.Predicate<RequestHandler> selector1 = RequestHandlerSelectors.basePackage("com.share.modules.user.controller");
     *     com.google.common.base.Predicate<RequestHandler> selector2 = RequestHandlerSelectors.basePackage("com.share.modules.resource.controller");
     *     return new Docket(DocumentationType.SWAGGER_2)
     *             .apiInfo(apiInfo())
     *             .select()
     *             .apis(Predicates.or(selector1,selector2))
     *             .paths(PathSelectors.any())
     *             .build()
     *             .globalOperationParameters(setHeaderToken());
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.aye.reg.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Shop-Aye 网关接口 API 文档")
                .description("Shop-Aye 网关接口 API")
                .termsOfServiceUrl("http://www.baidu.com")
                .version("1.0.0")
                .build();
    }
}
