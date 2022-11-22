/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * author: H.M.Duc
 */
package Controller;

import DAO.accountDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "AddAccountControl", urlPatterns = {"/addAccount"})
public class AddAccountControl extends HttpServlet {

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
        String userName = request.getParameter("userName");
        String pass = request.getParameter("pass");
        String isAdmin1 = request.getParameter("isAdmin");
        String email = request.getParameter("email");
        if(isAdmin1 == null)
        	isAdmin1 = "0";
        int isAdmin = Integer.parseInt(isAdmin1);
        accountDAO dao = new accountDAO();
        dao.insertAccount(userName, pass, 0, isAdmin, email);
       
        request.setAttribute("mess", "Account Added!");

        request.getRequestDispatcher("managerAccount").forward(request, response);
    }

}
