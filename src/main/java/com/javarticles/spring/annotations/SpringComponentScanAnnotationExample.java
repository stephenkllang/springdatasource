package com.javarticles.spring.annotations;

import com.javarticles.spring.annotations.packageA.BeanA;
import com.javarticles.spring.annotations.packageB.BeanB;
import com.javarticles.spring.annotations.packageC.BeanC2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.javarticles.spring.annotations.packageC.BeanC1;

@Configuration
//@ComponentScan( basePackageClasses = {BeanC1.class, BeanA.class, BeanB.class})
//@ComponentScan(basePackages = {
//        "com.javarticles.spring.annotations.packageA",
//        "com.javarticles.spring.annotations.packageB",
//        "com.javarticles.spring.annotations.packageE" }, basePackageClasses = BeanC1.class)
@ComponentScan(basePackages = {
        "com.javarticles.spring.annotations" })
public class SpringComponentScanAnnotationExample {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        try {
            ctx.register(SpringComponentScanAnnotationExample.class);
            ctx.refresh();
            System.out.println("SpringComponentScanAnnotationExample: " +
            ctx.getBean("springComponentScanAnnotationExample"));
            System.out.println("BeanA: "
                    + ctx.getBean("beanA"));
            System.out.println("BeanB: "
                    + ctx.getBean("beanB"));
            System.out.println("BeanBB: "
                    + ctx.getBean("beanBB"));
            System.out.println("BeanC1: "
                    + ctx.getBean("beanC1"));
            System.out.println("BeanC2: "
                    + ctx.getBean("beanC2"));
            System.out.println("Contains BeanC3?: "
                    + ctx.containsBean("beanC3"));
            System.out.println("Contains BeanD?: "
                    + ctx.containsBean("beanD"));
            System.out.println("Contains BeanE1?: "
                    + ctx.containsBean("beanE1"));
            System.out.println("Contains BeanE2?: "
                    + ctx.containsBean("beanE2"));
        } finally {
            ctx.close();
        }
    }

}
