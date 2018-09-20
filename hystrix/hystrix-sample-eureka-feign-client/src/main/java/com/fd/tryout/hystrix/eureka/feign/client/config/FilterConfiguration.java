package com.fd.tryout.hystrix.eureka.feign.client.config;

import com.fd.tryout.hystrix.eureka.feign.client.filter.HystrixRequestContextServletFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author fdanismaz
 * date: 9/20/18 11:46 AM
 */
@Configuration
public class FilterConfiguration {

    @Bean
    public FilterRegistrationBean<HystrixRequestContextServletFilter> hystrixRequestContextServletFilter() {
        FilterRegistrationBean<HystrixRequestContextServletFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new HystrixRequestContextServletFilter());
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }
}
