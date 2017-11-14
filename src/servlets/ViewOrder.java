package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ImplOrder;
import models.Order;

@WebServlet("/mn_order")
public class ViewOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ViewOrder() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		ImplOrder implOrder = new ImplOrder();
		try {
			List<Order> list = implOrder.getListOrder();
			request.setAttribute("listOrder", list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/page/admin/order.jsp");
		dispatcher.forward(request, response);
	}
}
