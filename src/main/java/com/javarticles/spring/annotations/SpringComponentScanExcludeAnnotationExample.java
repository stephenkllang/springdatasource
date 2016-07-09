package com.javarticles.spring.annotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import com.javarticles.spring.annotations.packageC.BeanC1;
import com.javarticles.spring.annotations.packageC.BeanC3;

@Configuration
@ComponentScan(basePackageClasses = BeanC1.class, 
              excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = BeanC3.class))
public class SpringComponentScanExcludeAnnotationExample {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        try {
            ctx.register(SpringComponentScanExcludeAnnotationExample.class);
            ctx.refresh();            
            System.out.println("Contains BeanC1?: "
                    + ctx.containsBean("beanC1"));
            System.out.println("Contains BeanC2?: "
                    + ctx.containsBean("beanC2"));
            System.out.println("Contains BeanC3?: "
                    + ctx.containsBean("beanC3"));
        } finally {
            ctx.close();
        }
    }
}
