package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.accountDAO;
import Model.accountModel;

@WebServlet(name = "SignUpServlet", value = "/sign_up_Page")
public class SignUpServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = "/sign_up.jsp";
		getServletContext().getRequestDispatcher(url).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String userName = req.getParameter("name");
			String pass = req.getParameter("pass");
			String email = req.getParameter("email");
			String re_pass = req.getParameter("re_pass");
			if (pass.equals(re_pass)) {
				accountDAO dao = new accountDAO();
				accountModel acc = dao.checkAccountExist(userName);
				if (acc == null) {
					dao.sign_up(userName, pass, email);
					resp.sendRedirect("loginPage");
				} else {
					req.setAttribute("error", "User name or email has exist !");
					getServletContext().getRequestDispatcher("/sign_up.jsp").forward(req, resp);
				}
			} else {
				req.setAttribute("error", "Please retype your password !");
				getServletContext().getRequestDispatcher("/sign_up.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
