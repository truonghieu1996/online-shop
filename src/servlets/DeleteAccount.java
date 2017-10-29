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

@WebServlet("/delete_account")
public class DeleteAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteAccount() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int role = (int) session.getAttribute("role");
		if(role == 1) {
			String username = request.getParameter("username");
			ImplAccount implAccount = new ImplAccount();
			try {
				if(implAccount.Delete(username) > 0) {
					response.sendRedirect("mn_account");
				}
			} catch (SQLException e) {
				e.printStackTrace();
				request.setAttribute("message",e.toString());
				request.getServletContext().getRequestDispatcher("/WEB-INF/page/admin/error.jsp").forward(request, response);
			}
		}else {
			request.setAttribute("message", "Bạn không có quyền sử dụng chức năng này!");
			request.getServletContext().getRequestDispatcher("/WEB-INF/page/admin/message.jsp").forward(request, response);
		}
	}

}
