package ServletHome;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ImplCategory;
import dao.ImplProduct;
import models.Category;
import models.ProductTeam;

@WebServlet("/home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Home() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ImplCategory implcategory = new ImplCategory();
		try {
			List<Category> listCategory = implcategory.getListCategory();
			request.setAttribute("listCategory", listCategory);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ImplProduct implProduct = new ImplProduct();
		try {
			List<ProductTeam> listProduct = implProduct.getListProduct();
			if(!listProduct.isEmpty()) {
				request.setAttribute("listProduct", listProduct);
			}else {
				request.setAttribute("message", "Danh sách rổng");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/page/home/index.jsp");
		dispatcher.forward(request, response);
	}

}
