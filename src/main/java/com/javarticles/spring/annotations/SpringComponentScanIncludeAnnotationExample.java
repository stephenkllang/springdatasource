package com.javarticles.spring.annotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import com.javarticles.spring.annotations.packageE.Custom;

@Configuration
@ComponentScan(basePackages = { "com.javarticles.spring.annotations.packageB",
        "com.javarticles.spring.annotations.packageE" }, 
        includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Custom.class), 
        useDefaultFilters = false)
public class SpringComponentScanIncludeAnnotationExample {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        try {
            ctx.register(SpringComponentScanIncludeAnnotationExample.class);
            ctx.refresh();            
            System.out.println("Contains BeanB?: "
                    + ctx.containsBean("beanB"));
            System.out.println("Contains BeanE1?: "
                    + ctx.containsBean("beanE1"));
            System.out.println("Contains BeanE2?: "
                    + ctx.containsBean("beanE2"));
        } finally {
            ctx.close();
        }
    }
}
