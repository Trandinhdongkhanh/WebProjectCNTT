package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.accountDAO;
import Model.Email;
import Model.MailConfig;
import Model.accountModel;
import Model.EmailUtils;

@WebServlet(name = "ResetPasswordServlet", value = "/resetPassword")
public class ResetPasswordServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/forgot.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String input_email = req.getParameter("email");
		accountModel acc = new accountDAO().checkEmailExist(input_email);
		if (acc == null) {
			req.setAttribute("error", "Please provide a registerd email !");
			getServletContext().getRequestDispatcher("/forgot.jsp").forward(req, resp);
			return;
		}
		try {
			accountDAO dao = new accountDAO();
			dao.resetPassword(acc.getUserName());
			
			Email email = new Email();
			
			email.setSubject("Reset Password !");
			email.setTo(input_email);
			
			StringBuilder sb = new StringBuilder();
			sb.append("Dear ").append(acc.getUserName()).append("<br>");
			sb.append("Your new password is <b>").append(acc.getPass()).append(" </b> <br>");
			sb.append("Regards<br>");
			sb.append("Administrator");

			email.setContent(sb.toString());
			EmailUtils.send(email);

			req.setAttribute("mess", "New password has been sent to your email !");
		} catch (Exception e) {
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher("/forgot.jsp").forward(req, resp);
	}
}
