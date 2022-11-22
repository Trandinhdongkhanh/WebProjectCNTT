/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.categoryDAO;
import DAO.productDAO;
import Model.productModel;
import Model.categoryModel;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "EditProductControl", urlPatterns = {"/editProductControl"})
public class EditProductControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	response.setContentType("text/html;charset=UTF-8");
        String id1 = request.getParameter("productid");
        int product_id = Integer.parseInt(id1);
        productDAO dao = new productDAO();
        categoryDAO dao1 = new categoryDAO();
        productModel p = dao.getProductByID(product_id);
        List<categoryModel> listC = dao1.getAllCategory();

        request.setAttribute("detail", p);
        request.setAttribute("listC", listC);
        
        request.getRequestDispatcher("editProduct.jsp").forward(request, response);
    }

}
