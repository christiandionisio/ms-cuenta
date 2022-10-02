package com.example.mscuenta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MsCuentaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsCuentaApplication.class, args);
    }

}
