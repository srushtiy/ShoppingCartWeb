package com.niit.shoppingcart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet"); //displays on console not browser -print writer out prints on browser
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		
		String name = request.getParameter("userID");
		String password = request.getParameter("password");
		
		LoginDAO login1 = new LoginDAO();
		RequestDispatcher dispatcher;//dispatches r and r to other resources (jsp or html)
		
		if (login1.isValidUser(name, password) == true)
		{
			dispatcher = request.getRequestDispatcher("Home.html");
			dispatcher.forward(request, response);
			//goto home page
		}
		else
		{
			dispatcher = request.getRequestDispatcher("login.html");
			PrintWriter writer = response.getWriter();
			writer.append("Invalid credentials. Please try again.");
			dispatcher.include(request, response);
			//go back to login page with error message
		}
	}

}
