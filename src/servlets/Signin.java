package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ImplAccount;

@WebServlet("/signin")
public class Signin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Signin() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int role = (int) session.getAttribute("role");
		if (role == 1) {
			request.getServletContext().getRequestDispatcher("/WEB-INF/page/admin/signin.jsp").forward(request,
					response);
		} else {
			request.setAttribute("message", "Bạn không có quyền sử dụng chức năng này!");
			request.getServletContext().getRequestDispatcher("/WEB-INF/page/admin/message.jsp").forward(request,
					response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int role = (int) session.getAttribute("role");
		if (role == 1) {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			String displayName = request.getParameter("fullname");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			if (!"".equals(displayName) || !"".equals(username) || !"".equals(password)) {
				ImplAccount implaccount = new ImplAccount();
				password = implaccount.getEncryption(password);
				try {
					if (implaccount.Add(displayName, username, password) > 0) {
						request.setAttribute("message", "Đăng ký thành công.");
					} else {
						request.setAttribute("mesage", "Đăng ký không thành công!");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			request.getServletContext().getRequestDispatcher("/WEB-INF/page/admin/signin.jsp").forward(request,
					response);
		} else {
			request.setAttribute("message", "Bạn không có quyền sử dụng chức năng này!");
			request.getServletContext().getRequestDispatcher("/WEB-INF/page/admin/message.jsp").forward(request,
					response);
		}
	}

}
