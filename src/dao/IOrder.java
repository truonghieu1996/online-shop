package dao;

import java.sql.SQLException;
import java.util.List;

import models.Order;
import models.OrderDetail;

public interface IOrder {

	public boolean order(String fullName, String address, String phonenumber, int method, int idProduct,
			int amountOrder);

	public List<Order> getListOrder() throws SQLException;

	public int confirmOrder(int idBill, int status) throws SQLException;
	
	public List<OrderDetail> getListOrderDetailByIdBillInf(int id) throws SQLException;
}
