package com.javarticles.spring.annotations;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@Configuration
@ComponentScan(basePackages = {
        "com.javarticles.spring.annotations.packageA",
        "com.javarticles.spring.annotations.packageB" })
public class SpringComponentScanAnnotationViaXMLExample {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        try {
            System.out.println("BeanA: "
                    + ctx.getBean("beanA"));
            System.out.println("BeanB: "
                    + ctx.getBean("beanB"));
            System.out.println("Contains BeanC1?: "
                    + ctx.containsBean("beanC31"));
            System.out.println("Contains BeanD?: "
                    + ctx.containsBean("beanD"));
            System.out.println("Contains BeanE1?: "
                    + ctx.containsBean("beanE1"));
        } finally {
            ctx.close();
        }
    }

}
