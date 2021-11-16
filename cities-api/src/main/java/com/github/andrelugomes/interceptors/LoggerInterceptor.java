package com.github.andrelugomes.interceptors;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoggerInterceptor implements HandlerInterceptor {

    Logger log = LoggerFactory.getLogger("Interceptor");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("O método preHandle está sendo chamado no Interceptor !!!");
        System.out.println("Podemos pré-processar o request aqui no Interceptor !!!");
        System.out.printf("IP de origem do request: %s", request.getRemoteAddr());
        System.out.println(request.getRequestURI());
        System.out.println(request.getAuthType());
        System.out.println(request.getRemoteUser());
        System.out.println(request.getRemoteHost());
        System.out.println(request.getAuthType());
        log.info(request.getRemoteAddr());
        log.info(request.getRequestURI());
        log.info(request.getAuthType());
        log.info(request.getRemoteUser());
        log.info(request.getRemoteHost());
        log.info(request.getAuthType());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("O método postHandle está sendo chamado !!!");
        System.out.println("Podemos pré-processar o POST request aqui no Interceptor !!!");
        log.info(request.toString());
        log.info(response.toString());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        System.out.println("O método afterCompletion está sendo chamado no Interceptor !!!");
        log.info(request.toString());
        log.info(response.toString());

    }

}
