package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ImplCategory;
import models.Category;

@WebServlet("/update_category")
public class UpdateCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateCategory() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {

	}

	public void destroy() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int id = Integer.valueOf(request.getParameter("id"));
		ImplCategory implcategory = new ImplCategory();
		Category category = null;
		try {
			category = (Category) implcategory.getCategoryById(id);
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("message",e.toString());
			request.getServletContext().getRequestDispatcher("/WEB-INF/page/admin/error.jsp").forward(request, response);
		}
		if (category != null) {
			request.setAttribute("category", category);
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/page/admin/update_category.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String category_name = request.getParameter("Category_name");
		int category_id = Integer.parseInt(request.getParameter("Category_id"));
		ImplCategory category = new ImplCategory();
		if (category_name != "") {
			if (category.Update(category_id, category_name) > 0) {
				response.sendRedirect("mn_category");
			}
		}
	}
}
