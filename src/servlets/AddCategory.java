package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ImplCategory;

@WebServlet("/add_category")
public class AddCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddCategory() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/page/admin/insert_category.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String category_name = request.getParameter("Category_name");
		if(!"".equals(category_name)) {
			ImplCategory category = new ImplCategory();
			if(category.Add(category_name) > 0) {
				response.sendRedirect("mn_category");
			}
		}
	}

}
