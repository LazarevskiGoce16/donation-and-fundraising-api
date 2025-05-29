package com.example.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ApiKeyFilter implements Filter {
    @Value("${security.api.key}")
    private String validApiKey;

    private static final String API_KEY_HEADER = "X-API-Key";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String path = httpRequest.getRequestURI();

        if (
                path.startsWith("/h2-console") ||
                path.startsWith("/status") ||
                "OPTIONS".equalsIgnoreCase(httpRequest.getMethod())) {
            chain.doFilter(request, response);
            return;
        }

        String apiKey = httpRequest.getHeader(API_KEY_HEADER);

        if (validApiKey != null && validApiKey.equals(apiKey)) {
            chain.doFilter(request, response);
        } else {
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            httpResponse.setContentType("text/plain");
            httpResponse.getWriter().write("Unauthorized: Invalid or missing API Key!");
            System.out.println("Unauthorized request to " + path + " with API key: " + apiKey);
        }
    }
}

