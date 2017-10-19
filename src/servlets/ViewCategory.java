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
import dao.ImplCategory;
import models.Category;

@WebServlet("/mn_category")
public class ViewCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ViewCategory() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ImplCategory category = new ImplCategory();
		List<Category> listCategory = null;
		try {
			listCategory = category.getListCategory();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(listCategory != null){
			request.setAttribute("listCategory", listCategory);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF//page/admin/category.jsp");
			dispatcher.forward(request, response);
		}else {
			System.out.println("Error");
		}
	}

}
