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

@WebServlet("/resest_password")
public class ResestPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ResestPassword() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int role = (int) session.getAttribute("role");
		if(role == 1) {
			ImplAccount implaccount = new ImplAccount();
			String username = request.getParameter("username");
			String password = implaccount.getEncryption("123456789");
			if(!"".equals(username)) {
				try {
					if(implaccount.UpdatePasswordByUsername(username, password) > 0) {
						request.setAttribute("message","Resest mật khẩu thành công, mật khẩu là 123456789");
					}else {
						request.setAttribute("message","Resest mật khẩu không thành công!");
					}
				} catch (SQLException e) {
					e.printStackTrace();
					request.setAttribute("message",e.toString());
					request.getServletContext().getRequestDispatcher("/WEB-INF/page/admin/error.jsp").forward(request, response);
				}
				request.getServletContext().getRequestDispatcher("/WEB-INF/page/admin/message.jsp").forward(request, response);
			}
		}else {
			request.setAttribute("message", "Bạn không có quyền sử dụng chức năng này!");
			request.getServletContext().getRequestDispatcher("/WEB-INF/page/admin/message.jsp").forward(request, response);
		}
	}

}
