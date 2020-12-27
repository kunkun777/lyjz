package com.zxc.socialSecurity;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EnableDubbo
@SpringBootApplication(scanBasePackages = {"com.zxc","com.zxc.socialSecurity"})
@EntityScan(value="com.zxc.model.social_security")
public class SocialSecurityApplication {
    public static void main(String[] args) {
        SpringApplication.run(SocialSecurityApplication.class);
    }
}
