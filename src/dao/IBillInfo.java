package dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface IBillInfo {
	public int add(Connection conn, int idProduct, int idBill, int amount) throws SQLException;

	public int delete(int id) throws SQLException;

	public int updateAmount(double amount, int id) throws SQLException;
}
