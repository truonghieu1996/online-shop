package ServletHome;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ImplCategory;
import dao.ImplProduct;
import models.Category;
import models.Product;

@WebServlet("/view_product_idcategory")
public class ViewProductByIdCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ViewProductByIdCategory() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		ImplCategory implcategory = new ImplCategory();
		try {
			List<Category> listCategory = implcategory.getListCategory();
			request.setAttribute("listCategory", listCategory);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ImplProduct implProduct = new ImplProduct();
		try {
			int idCategory = Integer.valueOf(request.getParameter("id"));
			List<Product>  listProduct = implProduct.getListProductByIdCategory(idCategory);
			if(!listProduct.isEmpty()) {
				request.setAttribute("listProduct", listProduct);
			}else {
				message = "Hiện tại chưa có sản phẩm nào.";
				request.setAttribute("message", message);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getServletContext().getRequestDispatcher("/WEB-INF/page/home/product.jsp").forward(request, response);
	}

}
