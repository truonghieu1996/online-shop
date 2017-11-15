package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ImplBillInfo implements IBillInfo {

	@Override
	public int add(Connection conn, int idProduct, int idBill, int amount) throws SQLException {
		String sql = "INSERT INTO bill_info(id_product, id_bill, amount) VALUES (?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, idProduct);
		ps.setInt(2, idBill);
		ps.setInt(3, amount);
		return ps.executeUpdate();
	}

	@Override
	public int delete(Connection conn, int id) throws SQLException {
		String sql = "DELETE FROM `bill_info` WHERE bill_info_id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		return ps.executeUpdate();
	}

	@Override
	public int updateAmount(Connection conn, int amount, int id) throws SQLException {
		String sql = "UPDATE bill_info SET amount= ? WHERE bill_info_id= ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ps.setInt(2, amount);
		return ps.executeUpdate();
	}

}
