package dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface ICustomer {
	public int Add(Connection conn, String fullname, String address, String phonenumber) throws SQLException;

	public int delete(Connection conn, int id) throws SQLException;
	
	public int update(int id, String fullname, String address, String phonenumber) throws SQLException;
}
