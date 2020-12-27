package com.zxc.audit;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(scanBasePackages = {"com.zxc","com.zxc.audit"},exclude ={ SecurityAutoConfiguration.class} )
@EntityScan(value="com.zxc.entity")
public class AuditApplication {
    public static void main(String[] args) {

    }
}
