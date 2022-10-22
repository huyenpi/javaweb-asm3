package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import context.DBContext;
import model.Account;

public class AccountDAO {

	public Account getAccount(String email) throws Exception {

		Account account = null;

		DBContext db = new DBContext();

		Connection conn = db.getConnection();

		String query = "Select * from Account where user_mail = ?";

		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setString(1, email);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			String user_email = rs.getString(1);
			String password = rs.getString(2);
			int role = rs.getInt(3);
			String name = rs.getString(4);
			String address = rs.getString(5);
			String phone = rs.getString(6);

			account = new Account(name, password, role, user_email, address, phone, 1);

		}

		return account;

	}

	public void insertAccount(Account account) throws Exception {
		DBContext db = new DBContext();

		Connection conn = db.getConnection();

		String sql = "insert into Account values(?,?,?,?,?,?)";

		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, account.getEmail());
		stmt.setString(2, account.getPwd());
		stmt.setInt(3, account.getRole());
		stmt.setString(4, account.getUsr());
		stmt.setString(5, account.getAddress());
		stmt.setString(6, account.getPhone());
		stmt.executeUpdate();
		
		conn.close();

	}
}
