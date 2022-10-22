package controller.User_In_Out;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AccountDAO;
import model.Account;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user_name = request.getParameter("name");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		String mappass = request.getParameter("mappass");
		
		String action = request.getParameter("action");
		request.setAttribute("action", action);
		

		String regexMail = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

		if (password.length() < 3 || !email.matches(regexMail)) {
			request.setAttribute("error", "invalid syntax");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		} else if (!password.matches(mappass)) {
			request.setAttribute("error", "password not match");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		} else {

			Account acc = null;
			try {
				acc = new AccountDAO().getAccount(email);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			if (acc != null) {
				request.setAttribute("error", "email existed");
				request.getRequestDispatcher("register.jsp").forward(request, response);
			} else {
				Account account = new Account(user_name, password, 0, email, address, phone, 1);
				AccountDAO aD = new AccountDAO();
				try {
					aD.insertAccount(account);
				} catch (Exception e) {
					response.getWriter().println("error");
					e.printStackTrace();
				}
			}

			request.getRequestDispatcher("/login").forward(request, response);
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
