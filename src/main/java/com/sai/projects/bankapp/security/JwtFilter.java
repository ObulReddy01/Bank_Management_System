package com.sai.projects.bankapp.security;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.sai.projects.bankapp.service.CustomUserDetailsService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain)
            throws ServletException, IOException {

        String header = request.getHeader("Authorization");

        System.out.println("HEADER: " + header);

        if (header != null && header.startsWith("Bearer ")) {
            try {
                String token = header.substring(7);
                System.out.println("TOKEN: " + token);

                String username = jwtUtil.extractUsername(token);
                System.out.println("USERNAME FROM TOKEN: " + username);

                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                System.out.println("DB USER: " + userDetails.getUsername());

                if (jwtUtil.validateToken(token, userDetails.getUsername())) {
                    System.out.println("TOKEN VALID ✅");

                    UsernamePasswordAuthenticationToken auth =
                            new UsernamePasswordAuthenticationToken(
                                    userDetails, null, userDetails.getAuthorities());

                    SecurityContextHolder.getContext().setAuthentication(auth);
                } else {
                    System.out.println("TOKEN INVALID ❌");
                }

            } catch (Exception e) {
                System.out.println("JWT ERROR: " + e.getMessage());
            }
        }

        chain.doFilter(request, response);
    }
}