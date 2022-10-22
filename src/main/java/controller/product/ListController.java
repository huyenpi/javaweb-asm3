package controller.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Pagination;
import dao.ListProductDAO;
import model.Product;

/**
 * Servlet implementation class ListController
 */
@WebServlet("/ListController")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String Null = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListController() {
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

		String i = request.getParameter("index");

		int index = 1;

		if (i != null) {
			index = Integer.parseInt(i);
		}

		List<Product> ls = null;
		try {

			ls = new ListProductDAO().search("");
		} catch (Exception e) {
			response.getWriter().println("error");
		}

		Pagination pag = new Pagination();
		int endPage = pag.endPage(ls);
		int pageSize = pag.getPageSize();

		List<Product> listOfPage = null;
		try {
			listOfPage = new ListProductDAO().searchListOfPage("", index, pageSize);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("products", listOfPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageSize", pageSize);

		RequestDispatcher rd = request.getRequestDispatcher("/home.jsp?index=" + index);
		rd.forward(request, response);

	}

}
