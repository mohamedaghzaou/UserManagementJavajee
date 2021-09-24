package com.userManagementJavaee.Controllers;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.userManagementJavaee.Dao.DaoFactory;
import com.userManagementJavaee.Dao.UserDao;
import com.userManagementJavaee.Dao.UserDaoImp;
import com.userManagementJavaee.beans.User;

/**
 * Servlet implementation class UserControllerServlet
 */
@WebServlet("/User")
public class UserControllerServlet extends HttpServlet {
	
	UserDao userDao = null;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		userDao = new UserDaoImp();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String op= Optional.ofNullable(request.getParameter("op")).orElse("");
		switch (op) {
		case "delete":
			int id = Integer.parseInt(request.getParameter("id"));
			userDao.deleteById(id);
			response.sendRedirect("User");
			return;
		case "update": 
			int Id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("Action","update");
			request.setAttribute("user", userDao.findById(Id));
			request.getRequestDispatcher("/WEB-INF/formUser.jsp").forward(request, response);
			return ;
		case "add":
			request.setAttribute("Action", "add");
			request.getRequestDispatcher("/WEB-INF/formUser.jsp").forward(request, response);
			return;
		}
		request.setAttribute("listuser", userDao.findAll());
		request.getRequestDispatcher("/WEB-INF/User-list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstName = request.getParameter("Firstname");
		String Lastname = request.getParameter("Lastname");
		String Address = request.getParameter("Address");
		String Email = request.getParameter("Email");
		String sex = request.getParameter("sex");
		String PhoneNumber = request.getParameter("PhoneNumber");
		
		User u = new User(firstName, Lastname, Address, Email, PhoneNumber, sex);
		
		String op= request.getParameter("op");
		switch (op)
		{
		case "add": 
			userDao.save(u);
			break;
		case "update":
			int id = Integer.parseInt(request.getParameter("id")); 
			u.setId(id);
			userDao.update(u);
			break;
		}
		response.sendRedirect("User");
	}

}
