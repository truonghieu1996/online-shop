package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ImplCategory;
import models.StatisticalCategory;

@WebServlet("/view_statistical")
public class ViewStatistical extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewStatistical() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int role = (int) session.getAttribute("role");
		if (role == 1) {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			ImplCategory implcategory = new ImplCategory();
			List<StatisticalCategory> list = implcategory.statisticalCategory();
			if (list != null) {
				request.setAttribute("listStatistical", list);
			}
			request.getServletContext().getRequestDispatcher("/WEB-INF/page/admin/statistical.jsp").forward(request,
					response);
		}else {
			request.setAttribute("message", "Bạn không có quyền sử dụng chức năng này!");
			request.getServletContext().getRequestDispatcher("/WEB-INF/page/admin/message.jsp").forward(request, response);
		}
	}

}
