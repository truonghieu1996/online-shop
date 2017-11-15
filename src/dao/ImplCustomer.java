package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import models.Connector;

public class ImplCustomer implements ICustomer {

	@Override
	public int Add(Connection conn, String fullname, String address, String phonenumber) throws SQLException {
		int idCustomer = 0;
		String sql = "INSERT INTO `customer`(`customer_name`, `customer_address`, `customer_phonenumber`) VALUES (?, ?,?)";
		PreparedStatement ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, fullname);
		ps.setString(2, address);
		ps.setString(3, phonenumber);
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		if (rs != null && rs.next()) {
	         idCustomer = rs.getInt(1);
	    }
		return idCustomer;
	}

	@Override
	public int delete(Connection conn, int id) throws SQLException {
		String sql ="DELETE FROM customer WHERE customer_id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		return ps.executeUpdate();
	}

	@Override
	public int update(int id, String fullname, String address, String phonenumber) throws SQLException {
		Connection conn = Connector.getConnection();
		String sql = "UPDATE `customer` SET `customer_name`=?,`customer_address`=?,`customer_phonenumber`=? WHERE `customer_id`=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, fullname);
		ps.setString(2, address);
		ps.setString(3,phonenumber);
		ps.setInt(4, id);
		return ps.executeUpdate();
	}

}
