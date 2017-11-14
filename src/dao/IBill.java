package dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface IBill {
	public int add(Connection conn, int idCustomer, int method, double totalPrice) throws SQLException;

	public int delete(int id) throws SQLException;

	public int updateMethod(int method, int id) throws SQLException;

	public int updateStatus(int status, int id) throws SQLException;
}
