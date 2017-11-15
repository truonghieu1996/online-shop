package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ImplOrder;
import models.OrderDetail;

@WebServlet("/order_detail")
public class ViewOrderDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewOrderDetail() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ImplOrder implOrder = new ImplOrder();
		double finalPrice = 0;
		try {
			int id = Integer.valueOf(request.getParameter("id"));
			List<OrderDetail> list = implOrder.getListOrderDetailByIdBillInf(id);
			for (OrderDetail orderDetail : list) {
				finalPrice += orderDetail.getTotalPrice();
			}
			request.setAttribute("listOrderDetail", list);
			request.setAttribute("finalPrice", finalPrice);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getServletContext().getRequestDispatcher("/WEB-INF/page/admin/detail_order.jsp").forward(request,
				response);
	}

}
