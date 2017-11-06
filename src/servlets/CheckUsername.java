package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ImplAccount;
import models.Account;

@WebServlet("/check_username")
public class CheckUsername extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CheckUsername() {
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		ImplAccount implaccount = new ImplAccount();
		Account account = new Account();
		try {
			account = implaccount.getAccountByUsername(username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(username.equals(account.getUsername())) {
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("<img src=\"resource/img/not-available.png\" />");
			response.getWriter().write("<span style=\"color:red\" >  Tên đăng nhập đã tồn tại!</span>");
			response.getWriter().write("<input type=\"hidden\" class=\"sedang\" id=\"check\" name=\"check\" value=\"Yes\">");
		}else {
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("<img src=\"resource/img/available.png\" />");
			response.getWriter().write("<span style=\"color:blue\" >  Hợp lệ</span>");
			response.getWriter().write("<input type=\"hidden\" class=\"sedang\" id=\"check\" name=\"check\" value=\"No\">");
		}
	}
}
