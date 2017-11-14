package dao;

import java.sql.Connection;
import java.sql.SQLException;

import models.Connector;
import models.Product;

public class Order {
	public boolean order(String fullName, String address, String phonenumber, int method, int idProduct, int amountOrder) {
		boolean checker = false;
		Connection conn = Connector.getConnection();
		double totalPrice = 0;
		try {
			conn.setAutoCommit(false);
			// insert table customer
			ImplCustomer implCustomer = new ImplCustomer();
			int idCustomer = implCustomer.Add(conn, fullName, address, phonenumber);
			//insert into table bill
			ImplBill implBill = new ImplBill();ImplProduct implproduct = new ImplProduct();
			Product product = implproduct.getProductById(idProduct);
			totalPrice = amountOrder * product.getPrice();
			int idBill = implBill.add(conn, idCustomer, method, totalPrice);
			//insert into table bill info
			ImplBillInfo implBillInfo = new ImplBillInfo();
			implBillInfo.add(conn, idProduct, idBill, amountOrder);
			//Get amount product current.
			int amount = product.getAmount() - amountOrder;
			//Update amount for this product.
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
}
