package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Connector;
import models.Order;
import models.Product;

public class ImplOrder implements IOrder {
	@Override
	public boolean order(String fullName, String address, String phonenumber, int method, int idProduct,
			int amountOrder) {
		boolean checker = false;
		Connection conn = Connector.getConnection();
		double totalPrice = 0;
		try {
			conn.setAutoCommit(false);
			// insert table customer
			ImplCustomer implCustomer = new ImplCustomer();
			int idCustomer = implCustomer.Add(conn, fullName, address, phonenumber);
			// insert into table bill
			ImplBill implBill = new ImplBill();
			ImplProduct implproduct = new ImplProduct();
			Product product = implproduct.getProductById(idProduct);
			totalPrice = amountOrder * product.getPrice();
			int idBill = implBill.add(conn, idCustomer, method, totalPrice);
			// insert into table bill info
			ImplBillInfo implBillInfo = new ImplBillInfo();
			implBillInfo.add(conn, idProduct, idBill, amountOrder);
			// Get amount product current.
			int amount = product.getAmount() - amountOrder;
			// Update amount for this product.
			implproduct.updateAmount(conn, amount, idProduct);
			conn.commit();
			checker = true;
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return checker;
	}

	@Override
	public List<Order> getListOrder() throws SQLException{
		Connection cons = Connector.getConnection();
		String sql = "select * from customer INNER JOIN bill ON customer.customer_id = bill.id_customer";
		List<Order> list = new ArrayList<>();
		try {
			PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Order order = new Order();
				order.setIdCustomer(rs.getInt("customer_id"));
				order.setIdBill(rs.getInt("bill_id"));
				order.setFullName(rs.getString("customer_name"));
				order.setAddress(rs.getString("customer_address"));
				order.setPhonenumber(rs.getString("customer_phonenumber"));
				order.setCheckIn(rs.getDate("checkin"));
				order.setCheckOut(rs.getDate("checkout"));
				order.setPamentMethod(rs.getInt("method"));
				order.setStatus(rs.getInt("status"));
				list.add(order);
			}
			cons.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int confirmOrder(int idBill, int status) throws SQLException { 
		Connection cons = Connector.getConnection();
		String sql = "";
		if(status == 1) {
			sql = "UPDATE bill "
					+ "SET checkout=NOW(),status=? WHERE bill_id=?";
		}else {
			sql = "UPDATE bill "
					+ "SET checkout=null,status=? WHERE bill_id=?";
		}
		int rs = -1;
		try {
			PreparedStatement ps = cons.prepareStatement(sql);
			ps.setInt(1, status);
			ps.setInt(2, idBill);
			rs = ps.executeUpdate();
			cons.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}
