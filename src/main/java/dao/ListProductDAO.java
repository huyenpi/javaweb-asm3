package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import model.Product;

/* cac phuong thuc lam viec voi bang Product
 * 
 */
public class ListProductDAO {

//return the list of products by product name
	public List<Product> search(String characters) throws Exception {

		List<Product> list = new ArrayList<>();

		Connection conn = null;

		DBContext ds = new DBContext();
		conn = ds.getConnection();

		String query = "select * from Products where product_name like ?";

		// select products have name include charaters parameter
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setString(1, '%' + characters + '%');
		ResultSet rs = stmt.executeQuery();

		// show data
		while (rs.next()) {
			int p_id = rs.getInt(1);
			String p_name = rs.getString(2);
			String p_des = rs.getString(3);
			float p_price = rs.getFloat(4);
			String p_src = rs.getString(5);
			String p_type = rs.getString(6);
			String p_brand = rs.getString(7);
			Product p = new Product(p_id, p_name, p_des, p_price, p_src, p_type, p_brand);
			list.add(p);
		}

		conn.close();
		return list;

	}

	public List<Product> searchListOfPage(String characters, int index, int pageSize) throws Exception {

		List<Product> list = new ArrayList<>();

		Connection conn = null;

		DBContext ds = new DBContext();
		conn = ds.getConnection();
		
		String query = "select * from (select row_number() over (order by product_price desc) as r,* from Products \r\n"
				+ "where product_name like ?) as t \r\n" + "where r between ? and ?";

		// select products have name include charaters parameter
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setString(1, '%' + characters + '%');
		int begin = (index - 1) * pageSize + 1;
		int end = index * pageSize;
		stmt.setInt(2, begin);
		stmt.setInt(3, end);
		ResultSet rs = stmt.executeQuery();

		// show data
		while (rs.next()) {
			int p_id = rs.getInt(2);
			String p_name = rs.getString(3);
			String p_des = rs.getString(4);
			float p_price = rs.getFloat(5);
			String p_src = rs.getString(6);
			String p_type = rs.getString(7);
			String p_brand = rs.getString(8);
			Product p = new Product(p_id, p_name, p_des, p_price, p_src, p_type, p_brand);
			list.add(p);
		}

		conn.close();
		return list;

	}

	// get the product by id
	public Product getProduct(String characters) throws Exception {
		Connection conn = null;

		DBContext ds = new DBContext();
		conn = ds.getConnection();

		String query = "select * from Products where product_id = ?";

		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setString(1, characters);
		ResultSet rs = stmt.executeQuery();

		// show data
		Product p = null;
		while (rs.next()) {
			int p_id = rs.getInt(1);
			String p_name = rs.getString(2);
			String p_des = rs.getString(3);
			float p_price = rs.getFloat(4);
			String p_src = rs.getString(5);
			String p_type = rs.getString(6);
			String p_brand = rs.getString(7);
			p = new Product(p_id, p_name, p_des, p_price, p_src, p_type, p_brand);

		}
		conn.close();
		return p;
	}

}
