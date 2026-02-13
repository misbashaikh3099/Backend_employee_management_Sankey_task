package com.example.employee_management.filter;
import java.io.IOException;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

/*
 Global Logging Filter Middleware
 *
 * This filter logs every incoming HTTP request and outgoing response.
 * It captures:
 * - HTTP Method
 * - Request URL
 * - Response Status Code
 * - Response Time
 *
 * This satisfies the middleware logging requirement of the task.
 */

@Component
public class LoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        long startTime = System.currentTimeMillis();

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        chain.doFilter(request, response);

        long timeTaken = System.currentTimeMillis() - startTime;

        System.out.println(
                "METHOD: " + req.getMethod() +
                        " | URL: " + req.getRequestURI() +
                        " | STATUS: " + res.getStatus() +
                        " | TIME: " + timeTaken + " ms"
        );
    }
}
