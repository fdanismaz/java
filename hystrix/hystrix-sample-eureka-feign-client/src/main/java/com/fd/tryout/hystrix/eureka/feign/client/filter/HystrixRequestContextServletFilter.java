package com.fd.tryout.hystrix.eureka.feign.client.filter;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author fdanismaz
 * date: 9/20/18 11:43 AM
 */
@Slf4j
public class HystrixRequestContextServletFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.debug("Inside HystrixRequestContextServletFilter");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        log.debug("Initializing HystrixRequestContext");
        HystrixRequestContext hystrixRequestContext = HystrixRequestContext.initializeContext();
        try {
            filterChain.doFilter(request, response);
        }
        finally {
            log.debug("Shutting down HystrixRequestContext");
            hystrixRequestContext.shutdown();
        }
    }

    @Override
    public void destroy() {
        log.debug("HystrixRequestContextServletFilter is destroyed");
    }
}
