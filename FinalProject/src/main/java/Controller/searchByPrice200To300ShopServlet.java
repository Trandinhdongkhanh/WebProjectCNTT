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

@WebServlet(name = "searchByPrice200To300ShopServlet", value = "/searchByPrice200To300Shop")
public class searchByPrice200To300ShopServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<productModel> products = new productDAO().getProduct200to300();
		
		PrintWriter out = resp.getWriter();
		
		for (productModel p : products) {
			out.println("<div class=\"col-sm-6 col-lg-4 mb-4\" data-aos=\"fade-up\">\r\n"
					+ "									<div class=\"block-4 text-center border\">\r\n"
					+ "										<figure class=\"block-4-image\">\r\n"
					+ "											<a href=\"detailPage?productID=" + p.getProductID()
					+ "\"><img\r\n" + "												src=\"" + p.getImage()
					+ "\" alt=\"Image placeholder\" class=\"img-fluid\"></a>\r\n"
					+ "										</figure>\r\n"
					+ "										<div class=\"block-4-text p-4\">\r\n"
					+ "											<h3>\r\n"
					+ "												<a href=\"detailPage?productID=" + p.getProductID()
					+ "\">" + p.getProductName() + "</a>\r\n" + "											</h3>\r\n"
					+ "											<p class=\"mb-0\">Finding perfect shoes</p>\r\n"
					+ "											<p class=\"text-primary font-weight-bold\">"
					+ p.getPrice() + "</p>\r\n" + "										</div>\r\n"
					+ "									</div>\r\n" + "								</div>");
		}
	}
}
