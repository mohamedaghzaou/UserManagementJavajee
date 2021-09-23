package com.userManagementJavaee.Controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.userManagementJavaee.Dao.UserDao;
import com.userManagementJavaee.Dao.UserDaoImp;
import com.userManagementJavaee.beans.User;

/**
 * Servlet implementation class UserControllerServlet
 */
@WebServlet("/User")
public class UserControllerServlet extends HttpServlet {
	
	UserDao userDao = new UserDaoImp();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User u = new User("adam", "aghzaou", "tetouan", "", "", "");
		userDao.save(u);
		
		response.getWriter().print(userDao.findAll());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
