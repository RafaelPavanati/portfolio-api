package com.pavanati.portfolio.domain.specification;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.validation.beanvalidation.CustomValidatorBean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import jakarta.validation.Validator;

@Configuration
public class ValidationAutoConfiguration {


    @Bean
    public PavanatiValidator validator(Validator beanValidator,
                                       ApplicationContext applicationContext) {
        return new PavanatiValidator(beanValidator, applicationContext);
    }
}
