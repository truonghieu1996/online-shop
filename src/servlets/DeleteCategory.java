package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ImplCategory;

@WebServlet("/delete_category")
public class DeleteCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteCategory() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int category_id = Integer.parseInt(request.getParameter("id"));
		ImplCategory category = new ImplCategory();
		if (category.Delete(category_id) > 0) {
			response.sendRedirect("mn_category");
		}else {
			request.setAttribute("noti", "Không thể xóa danh mục này!");
			response.sendRedirect("mn_category");
		}
	}

}
