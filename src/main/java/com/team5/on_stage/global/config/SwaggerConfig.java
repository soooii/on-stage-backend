package com.team5.on_stage.global.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(apiInfo());
    }

    private Info apiInfo() {
        return new Info()
                .title("On-stage : 링크 관리 서비스 API 명세서")
                .description("On-stage는 링크를 생성, 관리, 공유할 수 있는 플랫폼입니다. 이 API는 On-stage의 모든 주요 기능을 제공합니다.")
                .version("1.0.0");
    }
}