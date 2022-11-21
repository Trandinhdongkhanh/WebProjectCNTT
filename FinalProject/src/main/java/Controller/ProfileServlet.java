package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.accountDAO;
import Model.accountModel;

@WebServlet(name = "ProfileServlet", value = "/profile")
public class ProfileServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		accountModel acc = (accountModel) session.getAttribute("acc");

		if (acc == null) {
			resp.sendRedirect("loginPage");
			return;
		}
		
		req.setAttribute("username", acc.getUserName());
		req.setAttribute("email", acc.getEmail());
		req.setAttribute("pass", acc.getPass());

		getServletContext().getRequestDispatcher("/profile.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		accountModel acc = (accountModel) session.getAttribute("acc");

		if (acc == null) {
			resp.sendRedirect("loginPage");
			return;
		}
		
		accountDAO dao = new accountDAO();
		
		String userName = req.getParameter("name");
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		
		if(userName.isEmpty() || userName == null) {
			req.setAttribute("error", "Please enter username !");
			getServletContext().getRequestDispatcher("/profile.jsp").forward(req, resp);
			return;
		}
		
		if(email.isEmpty() || email == null) {
			req.setAttribute("error", "Please enter email !");
			getServletContext().getRequestDispatcher("/profile.jsp").forward(req, resp);
			return;
		}
		
		if(pass.isEmpty() || pass == null) {
			req.setAttribute("error", "Please enter password !");
			getServletContext().getRequestDispatcher("/profile.jsp").forward(req, resp);
			return;
		}
		
		if(dao.checkAccountExist(userName) != null && !userName.equals(acc.getUserName())) {
			System.out.println(dao.checkAccountExist(userName).getUserName());
			System.out.println(userName + " // " + acc.getUserName());
			req.setAttribute("error", "Username has exist !");
			getServletContext().getRequestDispatcher("/profile.jsp").forward(req, resp);
			return;
		}
		if(dao.checkEmailExist(email) != null && !email.equals(acc.getEmail())) {
			req.setAttribute("error", "Email has exist !");
			getServletContext().getRequestDispatcher("/profile.jsp").forward(req, resp);
			return;
		}
		
		try {
			dao.updateProfile(userName, pass, email, acc.getAccID());
			req.setAttribute("mess", "Update profile successfully !");
			req.setAttribute("username", acc.getUserName());
			req.setAttribute("pass", acc.getEmail());
			req.setAttribute("email", acc.getPass());
		} catch (Exception e) {
			e.printStackTrace();
		}

		getServletContext().getRequestDispatcher("/profile.jsp").forward(req, resp);
	}
}
