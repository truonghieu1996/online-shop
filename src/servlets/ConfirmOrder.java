package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ImplOrder;

@WebServlet("/confirm_order")
public class ConfirmOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ConfirmOrder() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idBill = Integer.valueOf(request.getParameter("id"));
		int status = Integer.valueOf(request.getParameter("status"));
		ImplOrder implOrder = new ImplOrder();
		if(status == 0) {
			try {
				if(implOrder.confirmOrder(idBill, 1) > 0) {
					response.sendRedirect("mn_order");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			try {
				if(implOrder.confirmOrder(idBill, 0) > 0) {
					response.sendRedirect("mn_order");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
