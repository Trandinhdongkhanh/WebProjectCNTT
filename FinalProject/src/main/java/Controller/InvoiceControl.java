/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.invoiceDAO;
import DAO.accountDAO;
import Model.invoiceModel;
import Model.accountModel;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "InvoiceControl", urlPatterns = {"/invoice"})
public class InvoiceControl extends HttpServlet {
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
      
        invoiceDAO dao = new invoiceDAO();
        accountDAO dao1 = new accountDAO();
        
        List<invoiceModel> listAllInvoice = dao.getAllinvoiceModel();
        List<accountModel> listAllAccount = dao1.getAllAccount();
        
        request.setAttribute("listAllInvoice", listAllInvoice);
        request.setAttribute("listAllAccount", listAllAccount);
          
        request.getRequestDispatcher("invoice.jsp").forward(request, response);
    }
}
