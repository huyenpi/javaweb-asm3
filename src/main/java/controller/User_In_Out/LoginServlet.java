package controller.User_In_Out;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccountDAO;
import model.Account;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
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

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");// vietnamese

		request.getSession(true).invalidate();

		HttpSession session = request.getSession();
		// make sure that email is valid
		String regexMail = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

		// collect data from a login form
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		String action = request.getParameter("action");
		request.setAttribute("action", action);

		// make sure email and password are valid
		
		if ((password != null && password.length() < 3) || ( email != null && !email.matches(regexMail))) {
			request.setAttribute("error", "invalid syntax");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			// find account match

			Account account = null;
			try {
				account = new AccountDAO().getAccount(email);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (account == null) {
				request.setAttribute("error", "account not exist");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} else if (!account.getPwd().matches(password)) {
				request.setAttribute("error", "wrong username or password");

				request.getRequestDispatcher("login.jsp").forward(request, response);
			}

			else {

				// set cookie- nho ten dang nhap
				String check = request.getParameter("checkbox");
				if (check != null && check.equals("on")) {
					Cookie cEmail = new Cookie("cEmail", email);
					cEmail.setMaxAge(60 * 60 * 24);
					response.addCookie(cEmail);
				}
				// login is valid,

				int role = account.getRole();
				if (role == 1) {
					session.setAttribute("email", email);
					session.setAttribute("username", account.getUsr());
					session.setAttribute("check", "1");
					response.sendRedirect(request.getContextPath() + "/admin/admin.jsp");
				} else {
					session.setAttribute("email", email);
					session.setAttribute("username", account.getUsr());
					session.setAttribute("check", "1");
					request.getRequestDispatcher("/home").forward(request, response);
				}

			}
		}

	}

}
