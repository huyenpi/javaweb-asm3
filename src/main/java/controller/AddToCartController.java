package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ListProductDAO;
import model.Cart;
import model.Product;

/* controller cua chuc nang them mot san pham vao gio hang */
/**
 * Servlet implementation class AddToCartController
 */
@WebServlet("/AddToCartController")
public class AddToCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddToCartController() {
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
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		String check = (String) session.getAttribute("check");

		//neu check=1 tai khoan da dang nhap thi cho dat hang
		if (check != null && check.equals("1")) {
			try {

				String idd = request.getParameter("id");
				String action = request.getParameter("action");
				
				if (action != null && action.equalsIgnoreCase("add")) {
					if (session.getAttribute("cart") == null) {
						session.setAttribute("cart", new Cart());
					}

					int id = Integer.parseInt(idd);
					Product p = new ListProductDAO().getProduct("" + id);
					Cart c = (Cart) session.getAttribute("cart");
					c.add(new Product(p.getId(), p.getName(), p.getDescription(), p.getPrice(), p.getSrc(), p.getType(),
							p.getBrand(), 1));

				} else if (action != null && action.equalsIgnoreCase("remove")) {
					int id = Integer.parseInt(idd);
					Cart c = (Cart) session.getAttribute("cart");
					c.remove(id);
				}
				response.sendRedirect(request.getContextPath() + "/cart.jsp?target=cart");
			} catch (Exception ex) {
				response.getWriter().println(ex);
				response.getWriter().println("error");
			}
		} else {
			response.sendRedirect(request.getContextPath() + "/login.jsp?target=dologin");
		}
	}

}
