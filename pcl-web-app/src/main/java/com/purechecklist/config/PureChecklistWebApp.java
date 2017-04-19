package com.purechecklist.config;

import com.purechecklist.web.app.PureChecklistWebAppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Import;

@Import(PureChecklistWebAppConfig.class)
public class PureChecklistWebApp {
    public static void main(String[] args) {
        SpringApplication.run(PureChecklistWebApp.class, args);
    }
}
