package dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface IBillInfo {
	public int add(Connection conn, int idProduct, int idBill, int amount) throws SQLException;

	public int delete(Connection conn, int id) throws SQLException;

	public int updateAmount(Connection conn, int amount, int id) throws SQLException;
}
