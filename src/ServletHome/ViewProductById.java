package ServletHome;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ImplProduct;
import models.Product;

@WebServlet("/detail_product")
public class ViewProductById extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewProductById() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ImplProduct implProduct = new ImplProduct();
		try {
			int idProduct = Integer.valueOf(request.getParameter("id"));
			Product product = implProduct.getProductById(idProduct);
			request.setAttribute("product", product);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/page/home/detail_product.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException e ) {
			e.printStackTrace();
		}
	}

}
