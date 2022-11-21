package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.categoryDAO;
import DAO.productDAO;
import Model.categoryModel;
import Model.productModel;

@WebServlet(name = "CategoryServlet", value = "/category")
public class CategoryServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = "/shop.jsp";

		List<productModel> products = new ArrayList<>();
		List<categoryModel> categories = new ArrayList<>();

		int cateID = Integer.parseInt(req.getParameter("cateID"));
		String name = new categoryDAO().getCategoryNamebyID(cateID);
		categories = new categoryDAO().getAllCategory();
		int count = new productDAO().getNumberofProductByCateID(cateID);
		int endPage = count / 6;
		int curPage = 1;
		
		if (count % 6 != 0 || count / 6 <= 0) {
			endPage++;
		}

		if (req.getParameter("p") != null) {
			req.setAttribute("tag", req.getParameter("p"));
			curPage = Integer.parseInt(req.getParameter("p"));

		} else {
			req.setAttribute("tag", 1);
		}
		
		products = new productDAO().pagingProductByCateID(cateID, curPage);

		req.setAttribute("endP", endPage);
		req.setAttribute("productList", products);
		req.setAttribute("categoryList", categories);
		req.setAttribute("cateName", name);
		req.setAttribute("cateID", cateID);

		getServletContext().getRequestDispatcher(url).forward(req, resp);
	}
}
