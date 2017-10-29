package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ImplAccount;
import models.Account;

@WebServlet("/mn_account")
public class ViewAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewAccount() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int role = (int) session.getAttribute("role");
		if (role == 1) {
			ImplAccount implAccount = new ImplAccount();
			List<Account> list = null;
			boolean check = false;
			try {
				list = implAccount.getListAccount();
			} catch (SQLException e) {
				e.printStackTrace();
				request.setAttribute("message",e.toString());
				request.getServletContext().getRequestDispatcher("/WEB-INF/page/admin/error.jsp").forward(request, response);
			}
			if (list != null) {
				check = true;
				request.setAttribute("noti", check);
				request.setAttribute("listaccount", list);
			} else {
				request.setAttribute("noti", check);
			}
			request.getServletContext().getRequestDispatcher("/WEB-INF/page/admin/account.jsp").forward(request,
					response);
		}else {
			request.setAttribute("message", "Bạn không có quyền sử dụng chức năng này!");
			request.getServletContext().getRequestDispatcher("/WEB-INF/page/admin/message.jsp").forward(request, response);
		}
	}

}
