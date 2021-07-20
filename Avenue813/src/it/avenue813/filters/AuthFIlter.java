package it.avenue813.filters;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import it.avenue813.model.UserBean;
import it.avenue813.model.UserModelDS;
import it.avenue813.utils.Utility;

/**
 * Servlet Filter implementation class AuthFIlter
 */
@WebFilter("/AuthFIlter")
public class AuthFIlter implements Filter {

    public AuthFIlter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hrequest = (HttpServletRequest) request;
		HttpServletResponse hresponse = (HttpServletResponse) response;
		UserModelDS userModel = new UserModelDS((DataSource) hrequest.getServletContext().getAttribute("DataSource"));
		Utility.print("ciaciacia");
		
		String uri = hrequest.getRequestURI();
		
		if(uri.contains("/user/")) {
			HttpSession session = hrequest.getSession(false);
			
			if(session != null) {
				UserBean user = new UserBean();
				try {
					user = userModel.canLogin((String) session.getAttribute("username"), (String) session.getAttribute("passw"));
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				if(user != null && (user.getRole().equals("Admin") || user.getRole().equals("User"))) {
					chain.doFilter(request, response);
				}else{hresponse.sendRedirect(hrequest.getContextPath()+"/PaginaUtili/errorpage.jsp");}
			}else {hresponse.sendRedirect("/Avenue813/PaginaUtili/errorpage.jsp");}
		}else if(uri.contains("/admin/")) {
			HttpSession session = hrequest.getSession(false);
			
			if(session != null) {
				UserBean user = new UserBean();
				try {
					user = userModel.canLogin((String) session.getAttribute("username"), (String) session.getAttribute("passw"));
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				if(user != null && user.getRole().equals("Admin")) {
					chain.doFilter(request, response);
				}else {hresponse.sendRedirect(hrequest.getContextPath()+"/PaginaUtili/errorpage.jsp");}
			}else {hresponse.sendRedirect(hrequest.getContextPath()+"/PaginaUtili/errorpage.jsp");}
		}else chain.doFilter(request, response);

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
