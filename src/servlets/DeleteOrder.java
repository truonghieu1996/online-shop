package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ImplOrder;

@WebServlet("/delete_order")
public class DeleteOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteOrder() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ImplOrder implOrder = new ImplOrder();
		try {
			int idBillInf = Integer.valueOf(request.getParameter("idBillInf"));
			int idBill = Integer.valueOf(request.getParameter("idBill"));
			int idCustomer = Integer.valueOf(request.getParameter("idCustomer"));
			int idProduct = Integer.valueOf(request.getParameter("idProduct"));
			int amountOrder = Integer.valueOf(request.getParameter("amountOrder"));
			boolean checker = implOrder.deleteOrder(idBillInf, idBill, idCustomer, idProduct, amountOrder);
			if(checker)
				response.sendRedirect("mn_order");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
