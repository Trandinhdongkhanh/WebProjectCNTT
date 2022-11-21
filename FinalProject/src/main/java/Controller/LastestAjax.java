package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.productDAO;
import Model.productModel;

@WebServlet(name = "LastestAjax", value = "/load_lastest_ajax")
public class LastestAjax extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		int curPage;
		if(req.getParameter("p") != null) {
			curPage = Integer.parseInt(req.getParameter("p"));
		}
		else {
			curPage = 1;
		}
		
		List<productModel> products = new productDAO().pagingProductByID_desc(curPage);
	}
}
