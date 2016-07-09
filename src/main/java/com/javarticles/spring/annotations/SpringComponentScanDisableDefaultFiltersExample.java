package com.javarticles.spring.annotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value="com.javarticles.spring.annotations.packageA", useDefaultFilters=false)
public class SpringComponentScanDisableDefaultFiltersExample {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        try {
            ctx.register(SpringComponentScanDisableDefaultFiltersExample.class);
            ctx.refresh();
            System.out.println("Contains BeanA?: "
                    + ctx.containsBean("beanA"));
        } finally {
            ctx.close();
        }
    }

}
