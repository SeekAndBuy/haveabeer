package com.seekandbuy.haveabeer.security.config;

//import org.springframework.security.web.RedirectStrategy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.RedirectStrategy;

import java.io.IOException;

class NoRedirectStrategy implements RedirectStrategy {

	public void sendRedirect(final HttpServletRequest request, final HttpServletResponse response, final String url) throws IOException 
	{
      // No redirect is required with pure REST
	}
}