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
import models.Account;

@WebServlet("/change_password")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ChangePassword() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if(!"".equals(username)) {
			request.getServletContext().getRequestDispatcher("/WEB-INF/page/admin/change_password.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		String passwordOld = request.getParameter("passwordOld");
		String passwordNew = request.getParameter("passwordNew");
		if(!"".equals(passwordOld) || !"".equals(passwordNew)) {
			ImplAccount implAccount = new ImplAccount();
			try {
				passwordOld = implAccount.getEncryption(passwordOld);
				Account account = implAccount.getAccountByPassword(passwordOld);
				if(account.getUsername() != null) {
					passwordNew = implAccount.getEncryption(passwordNew);
					if(implAccount.UpdatePasswordByUsername(username, passwordNew) > 0) {
						request.setAttribute("message", "Thành công, vui lòng đăng xuất và đăng nhập lại để áp dụng thay đổi.");
					}else {
						request.setAttribute("message", "Thay đổi mật khẩu không thành công!");
					}
				}else {
					request.setAttribute("message", "Mật khẩu củ không chính xác!");
				}
			} catch (SQLException e) {
				e.printStackTrace();
				request.setAttribute("message",e.toString());
				request.getServletContext().getRequestDispatcher("/WEB-INF/page/admin/error.jsp").forward(request, response);
			}
		}
		request.getServletContext().getRequestDispatcher("/WEB-INF/page/admin/change_password.jsp").forward(request, response);
	}

}
