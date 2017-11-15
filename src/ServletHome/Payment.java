package ServletHome;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ImplProduct;
import dao.ImplOrder;
import models.Product;

@WebServlet("/payment")
public class Payment extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Payment() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ImplProduct implProduct = new ImplProduct();
		try {
			int id = Integer.valueOf(request.getParameter("id"));
			Product product = implProduct.getProductById(id);
			request.setAttribute("product", product);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getServletContext().getRequestDispatcher("/WEB-INF/page/home/payment.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		boolean checker = false;
		String fullName = request.getParameter("txtname");
		String address = request.getParameter("txtaddress");
		String phonenumber = request.getParameter("txtphone");
		int pamentMethod = Integer.valueOf(request.getParameter("method"));
		int amountOrder = Integer.valueOf(request.getParameter("txtamount"));
		int idProduct = Integer.valueOf(request.getParameter("idProduct"));
		if(!"".equals(fullName) && !"".equals(address) && !"".equals(phonenumber) && pamentMethod != 0 && amountOrder != 0) {
			ImplOrder order = new ImplOrder();
			try {
				checker = order.order(fullName, address, phonenumber, pamentMethod, idProduct, amountOrder);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("checker", checker);
			if(checker) {
				request.setAttribute("message", "Đặt hàng thành công.");
			}else {
				request.setAttribute("message", "Đặt hàng không thành công!");
			}
		}
		request.getServletContext().getRequestDispatcher("/WEB-INF/page/home/message.jsp").forward(request, response);
	}

}
