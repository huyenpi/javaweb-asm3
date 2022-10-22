package bean;

import java.util.List;

import dao.ListProductDAO;
import model.Product;

public class Pagination {
	private int pageSize = 6;
	

	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public int endPage(List<Product> lp) {
		int products = lp.size();
		int endPage = 1;
		if (products > pageSize) {
			endPage = products / pageSize;
			if (products % pageSize != 0) {
				endPage++;
			}
		}

		return endPage;
	}
}
