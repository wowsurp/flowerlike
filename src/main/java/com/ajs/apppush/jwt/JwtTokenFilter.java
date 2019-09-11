package com.ajs.apppush.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;

@Configuration
public class JwtTokenFilter extends OncePerRequestFilter{

	private static final Logger logger = LoggerFactory.getLogger(JwtTokenFilter.class);
	
	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain)
			throws ServletException, IOException {
		
		logger.info("doFilterInternal : ");
		
		ContentCachingRequestWrapper reqWrapper = new ContentCachingRequestWrapper(req);
		
		String requestBody = new String(reqWrapper.getContentAsByteArray());
		
		logger.info("body : " + requestBody);
		
		filterChain.doFilter(reqWrapper, res);
		
//		String body = reqWrapper.getReader().lines()
//				.reduce("", String::concat);
		
		
		
		
		
	}

}
