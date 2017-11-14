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
	public int delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateAmount(double amount, int id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
