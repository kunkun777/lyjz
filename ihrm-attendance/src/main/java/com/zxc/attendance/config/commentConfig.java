package com.zxc.attendance.config;

import com.zxc.common.utils.IdWorker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;

@Configuration
public class commentConfig {

    @Bean
    public IdWorker idWorker() {
        return new IdWorker();
    }

    /**
     * 解决jpa no session问题
     */
    @Bean
    public OpenEntityManagerInViewFilter openEntityManagerInViewFilter(){
        return new OpenEntityManagerInViewFilter();
    }

}
