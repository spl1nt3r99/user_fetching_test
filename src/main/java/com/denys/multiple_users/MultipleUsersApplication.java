package com.denys.multiple_users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class MultipleUsersApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultipleUsersApplication.class, args);
    }

}
