package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrdersDAO;
import model.Cart;
import model.Product;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Test() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		// lay ra cac order_id theo email
		List<Integer> li = null;
		try {
			li = new OrdersDAO().getListOrderId("llinh");
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
		
		for(Cart c : list) {
			for(Product p : c.getItems()) {
				out.println(p.getName());
			}
			out.println("");
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
