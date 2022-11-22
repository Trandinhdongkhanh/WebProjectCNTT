/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.productDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(name = "EditProduct", urlPatterns = {"/editProduct"})
public class EditProduct extends HttpServlet {
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
        request.setCharacterEncoding("UTF-8");
        String pid = request.getParameter("productID");
        int productid = Integer.parseInt(pid);
        String productname = request.getParameter("productName");
        String pprice = request.getParameter("price");
        int price = Integer.parseInt(pprice);
        String pcategory = request.getParameter("category");
        int cateid = Integer.parseInt(pcategory);
        String description = request.getParameter("description");
        String image = request.getParameter("image");                

        productDAO dao = new productDAO();
        dao.editProduct(productid, productname, price, cateid, description, image);
        request.setAttribute("mess", "Edited!");
        request.getRequestDispatcher("managerProduct").forward(request, response);
    }

}
