package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.accountDAO;
import DAO.cartDAO;
import Model.accountModel;

@WebServlet(name = "LoginServlet", value = "/loginPage")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie arr[] = req.getCookies();
		
		if (arr != null) {
			for (Cookie c : arr) {
				if (c.getName().equals("userC")) {
					req.setAttribute("username", c.getValue());
				}
				if (c.getName().equals("passC")) {
					req.setAttribute("password", c.getValue());
				}
			}
		}
		

		getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
	}

//	protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException {
//		String homeURL = "homePage";
//		String url = "/login.jsp";
//		String userName = req.getParameter("your_name");
//		String pass = req.getParameter("your_pass");
//		System.out.println(userName);
//		System.out.println(pass);
//		accountModel acc = new accountDAO().login(userName, pass);
//		System.out.println(req.getAttribute("error"));
//		if (acc != null) {
//			resp.sendRedirect(homeURL);
//		} else {
//			req.setAttribute("error", "Wrong user name of password !");
//			getServletContext().getRequestDispatcher(url).forward(req, resp);
//		}
//	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("your_name");
		String pass = req.getParameter("your_pass");
		String remember = req.getParameter("remember-me");
		accountModel acc = new accountDAO().login(userName, pass);
		if (acc != null) {
			int nbItemsCart = new cartDAO().number_of_items_inCart(acc.getAccID());
			HttpSession session = req.getSession();
			session.setAttribute("acc", acc);
			session.setAttribute("nbItemsCart", nbItemsCart);

			Cookie u = new Cookie("userC", userName); // Cookie
			Cookie p = new Cookie("passC", pass);

			if (remember != null) {
				u.setMaxAge(60 * 60);
				p.setMaxAge(60 * 60);
			} else {
				u.setMaxAge(0);
				p.setMaxAge(0);
			}
			if(acc.getIsAdmin() == 1 || acc.getIsSell() ==1)
			{
				resp.sendRedirect("adminDashboard");
				return;
			}
			
			else {
				resp.addCookie(u);
				resp.addCookie(p);
	
				resp.sendRedirect("homePage");
				return;
			}
		}
		req.setAttribute("error", "Wrong user name of password !");
		getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
	}
}
