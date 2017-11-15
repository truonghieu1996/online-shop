package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class ImplBill implements IBill {

	@Override
	public int add(Connection conn, int idCustomer, int method, double totalPrice) throws SQLException {
		int idBill = 0;
		String sql = "INSERT INTO bill(id_customer, method, total_price) VALUES (?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		ps.setInt(1, idCustomer);
		ps.setInt(2, method);
		ps.setDouble(3, totalPrice);
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		if (rs != null && rs.next()) {
	         idBill = rs.getInt(1);
	    }
		return idBill;
	}

	@Override
	public int delete(Connection conn, int id) throws SQLException {
		String sql = "DELETE FROM bill WHERE bill_id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		return ps.executeUpdate();
	}
	
	@Override
	public int updateMethod(int method, int id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateStatus(int status, int id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
}
