package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import context.DBContext;
import dao.ListProductDAO;
import model.Product;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//controller cho navbar
		
		String target = request.getParameter("target");
		if (target == null || target.equals("home")) {
			request.getRequestDispatcher("/home?target=home").forward(request, response);
		} else if (target.equals("products")) {
			request.getRequestDispatcher("/products?target=products").forward(request, response);
		} else if (target.equals("aboutus")) {
			request.getRequestDispatcher("/aboutus.jsp?target=aboutus").forward(request, response);
		} else if (target.equals("dologin")) {
			response.sendRedirect(request.getContextPath() + "/login.jsp?target=dologin");
		} else if(target.equals("register")) {
			response.sendRedirect(request.getContextPath() + "/register.jsp?target=register");
		} else if(target.equals("cart")) {
			request.getRequestDispatcher("/cart.jsp?target=cart").forward(request, response);
		}else if(target.equals("logout")) {
			response.sendRedirect(request.getContextPath() + "/logout");
		} else if(target.equals("ordered")) {
			response.sendRedirect(request.getContextPath() + "/ordered?target=ordered");
			return;
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
