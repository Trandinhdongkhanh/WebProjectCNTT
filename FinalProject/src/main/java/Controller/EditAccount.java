/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.accountModel;
import DAO.accountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "EditAccount", urlPatterns = {"/editAccount"})
public class EditAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	doPost(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	 String accid1 = request.getParameter("accID");
    	 int accID = Integer.parseInt(accid1);
         String username = request.getParameter("userName");
         String password = request.getParameter("pass");
         String isAdmin1 = request.getParameter("isAdmin");
         int isAdmin = Integer.parseInt(isAdmin1);
         String email = request.getParameter("email");
         
         
         accountDAO dao = new accountDAO();

         dao.editAccount(accID,username, password, isAdmin, email);  
         request.setAttribute("mess", "Cap nhat tai khoan thanh cong!");

         request.getRequestDispatcher("managerAccount").forward(request, response);
    }
}
