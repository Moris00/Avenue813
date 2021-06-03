package it.avenue813.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.avenue813.utils.Utility;

public class RegisterFilter implements Filter {

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		
		String uri = request.getRequestURI();
		
		if(uri.contains("/PaginaAutenticazione/register.jsp")) {
			String name = request.getParameter("name");
			
			if(name.equals(name)) {
				Utility.print("E' Uguale");
			}else {
				response.sendRedirect(request.getContextPath()+"/PaginaAutenticazione/register.jsp");

				}
			
		}else {response.sendRedirect(request.getContextPath()+"/PaginaAutenticazione/register.jsp");}
		
		
		arg2.doFilter(arg0, arg1);

	}

}
