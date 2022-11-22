/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.accountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "DeleteAccountControl", urlPatterns = {"/deleteAccount"})
public class DeleteAccountControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	response.setContentType("text/html;charset=UTF-8");
        String id1 = request.getParameter("accid");
        System.out.println("id: "+id1);
        accountDAO dao = new accountDAO();
        int id = Integer.parseInt(id1);
        dao.deleteCartByAccountID(id);
        dao.deleteReviewByAccountID(id);
        dao.deleteInvoiceByAccountId(id);
        dao.deleteTotalSpendingByAccID(id);
        dao.deleteAccount(id);
        
        request.setAttribute("mess", "Account Deleted!");
        request.getRequestDispatcher("managerAccount").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
