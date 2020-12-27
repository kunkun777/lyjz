package com.zxc.employee.config;

import com.zxc.common.utils.IdWorker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommentConfig {
    @Bean
    public IdWorker idWorkker() {
        return new IdWorker(1, 1);
    }
}
