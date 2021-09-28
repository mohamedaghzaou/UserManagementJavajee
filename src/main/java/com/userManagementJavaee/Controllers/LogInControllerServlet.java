package com.userManagementJavaee.Controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.userManagementJavaee.Dao.UserDao;
import com.userManagementJavaee.Dao.UserDaoImp;
import com.userManagementJavaee.security.EncrypteAndDecrypte;

/**
 * Servlet implementation class LogInControllerServlet
 */
@WebServlet("/LogIn" )
public class LogInControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDao userDao = null;

	
  
    @Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		userDao = new UserDaoImp();

	}


	public LogInControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String rememberme = request.getParameter("rememberme");

		
		if(userDao.login(username, password)) {
			
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("username", username);
			httpSession.setAttribute("password", password);
			if(rememberme!= null) {
			try {
			//	EncrypteAndDecrypte.encrypt("mohamed");
				Cookie userN = new Cookie("userID", EncrypteAndDecrypte.encrypt(username));
				Cookie userP = new Cookie("userP", EncrypteAndDecrypte.encrypt(password));
				userN.setMaxAge(1000*24*3600);
				userP.setMaxAge(1000*24*3600);
				response.addCookie(userP);
				response.addCookie(userN);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			}
			
			response.sendRedirect("User");
		}else
		{
			request.setAttribute("login", false);
			request.getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);
		}

	}

}
