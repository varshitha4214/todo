/*package com.todoapp.todo.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import java.io.IOException;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    public JWTAuthorizationFilter(AuthenticationManager authManager) {
        super(authManager);
    }

    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        Cookie cookie = getAccessTokenCookie(req);
        String header = req.getHeader(HEADER_STRING);

        if (cookie == null && null == header) {
            chain.doFilter(req, res);
            return;
        }

        Authentication authentication = getAuthentication(req);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(req, res);
    }


    private Authentication getAuthentication(HttpServletRequest request) {

        //Check for header token
        String token = request.getHeader(HEADER_STRING);
        if (null == token) {

            //Check for Cookie token
            Cookie cookie = getAccessTokenCookie(request);
            if (null == cookie) {
                throw new JSONWebTokenException("Unable to authenticate without header or cookie");
            }

            token = cookie.getValue();
        }

        return authenticate(token);
    }
}*/