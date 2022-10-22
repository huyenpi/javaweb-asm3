package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import model.Cart;
import model.Orders;
import model.Product;

/* cac phuong thuc lam viec voi bang order */

public class OrdersDAO {

	// insert information of Order to data source, that including list of
	// products in cart (c) and information of buyer in Orders o
	public void insertOrder(Orders o, Cart c) throws Exception {

		Connection conn = null;
		DBContext db = new DBContext();
		conn = db.getConnection();

		String sql1 = "insert into Orders(user_mail,order_status,order_date,order_discount_code,order_address) values(?,?,?,?,?)";
		String sql2 = "insert into Orders_detail values(?,?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(sql1);
		stmt.setString(1, o.getUserMail());

		stmt.setInt(2, o.getStatus());

		long millis = System.currentTimeMillis();
		Date date = new Date(millis);

		stmt.setDate(3, date);
		stmt.setString(4, o.getDiscount());
		stmt.setString(5, o.getAddress());

		stmt.executeUpdate();

		String sql3 = "select top(1) order_id from Orders Order by order_id desc";
		stmt = conn.prepareStatement(sql3);
		ResultSet rs = stmt.executeQuery();
		int orderId = 0;
		while (rs.next()) {
			orderId = rs.getInt(1);
		}

		stmt = conn.prepareStatement(sql2);

		for (Product p : c.getItems()) {

			stmt.setInt(1, orderId);
			stmt.setInt(2, p.getId());
			stmt.setInt(3, p.getNumber());
			stmt.setFloat(4, p.getPrice());

			stmt.executeUpdate();
		}

		conn.close();

	}

	// lay ra order_id cua cac don hang da dat cua 1 email
	public List<Integer> getListOrderId(String email) throws Exception {
		List<Integer> list = new ArrayList<>();

		DBContext db = new DBContext();

		Connection conn = db.getConnection();

		String query = "select order_id from orders where user_mail = ? order by order_id desc";

		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setString(1, email);

		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {

			int order_id = rs.getInt(1);
			list.add(order_id);
		}

		conn.close();

		return list;
	}

	public Cart getOrderedCart(int order_id) throws Exception {

		Cart c = new Cart();

		DBContext db = new DBContext();

		Connection conn = db.getConnection();

		String query = "select orders_detail.product_id, products.product_name,orders_detail.price_product,orders_detail.amount_product  from\r\n"
				+ "orders_detail join products \r\n" + "on orders_detail.product_id = products.product_id\r\n"
				+ "where orders_detail.order_id = ?";

		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setInt(1, order_id);

		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			int id = rs.getInt(1);
			String name = rs.getString(2);
			Float price = rs.getFloat(3);
			int amount = rs.getInt(4);

			c.add(new Product(id, name, "", price, "", "", "", amount));
		}

		conn.close();

		return c;

	}
}
