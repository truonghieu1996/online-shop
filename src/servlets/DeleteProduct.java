package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ImplProduct;

@WebServlet("/delete_product")
public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteProduct() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int product_id = Integer.parseInt(request.getParameter("id"));
		ImplProduct implProduct = new ImplProduct();
		try {
			if (implProduct.Delete(product_id) > 0) {
				response.sendRedirect("mn_product");
			}else {
				request.setAttribute("noti", "Không thể xóa danh mục này!");
				response.sendRedirect("mn_product");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("message",e.toString());
			request.getServletContext().getRequestDispatcher("/WEB-INF/page/admin/error.jsp").forward(request, response);
		}
	}

}
