package com.contactFilter;

import com.contactFilter.config.PersistenceConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@SpringBootApplication(exclude = {PersistenceConfiguration.class})
public class HomeWorkApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomeWorkApplication.class, args);
    }

}
