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

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		ImplAccount implAccount = new ImplAccount();
		password = implAccount.getEncryption(password);
		try {
			Account account = implAccount.getAccountByUsername(username);
			if(username.equals(account.getUsername()) && password.equals(password)) {
				if(password.equals(account.getPassword())){
					HttpSession session = request.getSession();
					session.setAttribute("username",account.getUsername());
					session.setAttribute("displayname", account.getDisplayname());
					session.setAttribute("role", account.getRole());
					request.getServletContext().getRequestDispatcher("/WEB-INF/page/admin/index.jsp").forward(request, response);
				}else {
					request.setAttribute("message", "Tài khoản hoặc mật khẩu không chính xác!");
					request.getServletContext().getRequestDispatcher("/WEB-INF/page/admin/login.jsp").forward(request, response);
				}
			}else {
				request.setAttribute("message", "Tài khoản không tồn tại!");
				request.getServletContext().getRequestDispatcher("/WEB-INF/page/admin/login.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
