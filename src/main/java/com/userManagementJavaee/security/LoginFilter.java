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
			if(username ==null && password==null && httpResp.getCookies()!=null) {
		
				 try {
					username= getCookieValue(httpResp, "userID");
					password=getCookieValue(httpResp, "userP");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				httpSession.setAttribute("username", username);
				httpSession.setAttribute("password", password);
				System.out.print(username);
			}

			if(userDao.login(username, password)) {
			

				chain.doFilter(request, response);
		}else
		{

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
	
	public String getCookieValue(HttpServletRequest httpResp, String name) throws Exception {
		for(int i  = 0 ; i< httpResp.getCookies().length;i++) {
			if(httpResp.getCookies()[i].getName().equals(name)) {
				
					try {
					return	EncrypteAndDecrypte.decrypt(httpResp.getCookies()[i].getValue());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						throw e;

					}
			}
				
		}
		return null;
	}

}
