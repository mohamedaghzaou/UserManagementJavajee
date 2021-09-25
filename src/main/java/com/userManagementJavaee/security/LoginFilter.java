package com.userManagementJavaee.security;

import java.io.IOException;
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

import com.userManagementJavaee.Dao.UserDao;
import com.userManagementJavaee.Dao.UserDaoImp;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(value ="/User" , servletNames = {"/User"})
public class LoginFilter implements Filter {

	UserDao userDao = null;

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
		System.out.println("filtringdjdjdj");

    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {		
			
		HttpServletRequest httpResp = (HttpServletRequest) request;
		HttpServletResponse httpRe = (HttpServletResponse) response;

		
			HttpSession httpSession = httpResp.getSession();
			String username=(String) httpSession.getAttribute("username");
			String password=(String) httpSession.getAttribute("password");
			System.out.print(username +password );

			if(userDao.login(username, password)) {
			
				System.out.println("good");

				chain.doFilter(request, response);
		}else
		{
			System.out.println("not good");

			httpRe.sendRedirect("LogIn");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		userDao = new UserDaoImp();

	}

}
