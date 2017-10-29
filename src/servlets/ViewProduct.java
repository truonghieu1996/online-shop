package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ImplProduct;
import models.ProductTeam;

@WebServlet("/mn_product")
public class ViewProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ViewProduct() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		ImplProduct implProduct = new ImplProduct();
		List<ProductTeam> list = null;
		boolean check = false;
		try {
			list = implProduct.getListProduct();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(list != null) {
			check = true;
			request.setAttribute("noti", check);
			request.setAttribute("listProduct", list);
		}else {
			request.setAttribute("noti", check);
		}
		request.getServletContext().getRequestDispatcher("/WEB-INF/page/admin/product.jsp").forward(request, response);
	}

}
