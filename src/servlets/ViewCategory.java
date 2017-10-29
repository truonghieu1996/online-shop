package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		ImplCategory category = new ImplCategory();
		List<Category> listCategory = null;
		boolean check = false;
		try {
			listCategory = category.getListCategory();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(listCategory != null){
			check = true;
			request.setAttribute("noti", check);
			request.setAttribute("listCategory", listCategory);
		}else {
			request.setAttribute("noti", check);
		}
		request.getServletContext().getRequestDispatcher("/WEB-INF//page/admin/category.jsp").forward(request, response);
	}

}
