package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.OrdersDAO;
import model.Cart;

/**
 * Servlet implementation class OrderedListController
 */
@WebServlet("/OrderedListController")
public class OrderedListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderedListController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
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

		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");

		// lay ra cac order_id theo email
		List<Integer> li = null;
		try {
			li = new OrdersDAO().getListOrderId(email);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// tao list chua cac gio hang
		List<Cart> list = new ArrayList<>();
		for (int x : li) {

			// lay ra list gio hang theo order_id
			Cart cart = null;
			try {
				cart = new OrdersDAO().getOrderedCart(x);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list.add(cart);

		}

		session.setAttribute("list", list);
		request.getRequestDispatcher("/ordered.jsp?target=ordered").forward(request, response);

	}

}
