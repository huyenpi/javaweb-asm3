package controller;

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
 * Servlet implementation class SearchController2
 */
@WebServlet("/SearchController2")
public class SearchController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchController2() {
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
		request.setCharacterEncoding("utf-8");

		try {
			String text = request.getParameter("search");
			String i = request.getParameter("index");

			int index = 1;
			if (i != null) {
				index = Integer.parseInt(i);
			}
			// lay ve tong so product ung voi text
			List<Product> list = new ListProductDAO().search(text);

			// lay ra cac thong so de cai dat phan trang trong
			Pagination pag = new Pagination();
			int endPage = pag.endPage(list);
			int pageSize = pag.getPageSize();

			// lay ve list product ma moi trang cho phep hien thi
			List<Product> listOfPage = new ListProductDAO().searchListOfPage(text, index, pageSize);

			
				request.setAttribute("products", listOfPage);
				request.setAttribute("endPage", endPage);
				request.setAttribute("text", text);

				request.getRequestDispatcher("/search.jsp?index=" + index).forward(request, response);
			

		} catch (Exception ex) {
			response.getWriter().println(ex);
		}
	}

}
