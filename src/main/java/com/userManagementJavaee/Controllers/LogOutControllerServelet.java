package com.userManagementJavaee.Controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.userManagementJavaee.security.EncrypteAndDecrypte;

/**
 * Servlet implementation class LogOutControllerServelet
 */
@WebServlet("/LogOut")
public class LogOutControllerServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogOutControllerServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Cookie userN = new Cookie("userID", null);
		Cookie userP = new Cookie("userP", null);
		userN.setMaxAge(0);
		userP.setMaxAge(0);
		response.addCookie(userP);
		response.addCookie(userN);
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("username", null);
		httpSession.setAttribute("password", null);
		response.sendRedirect("User");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
