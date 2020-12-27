package com.zxc.attendance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.zxc.attendance")
@SpringBootApplication(scanBasePackages = {"com.zxc","com.zxc.attendance"})
@EntityScan(value="com.zxc.model")
public class AttendanceApplication {
    public static void main(String[] args) {
        SpringApplication.run(AttendanceApplication.class,args);
    }
}
