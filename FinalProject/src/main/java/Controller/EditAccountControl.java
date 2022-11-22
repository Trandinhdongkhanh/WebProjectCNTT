/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.accountDAO;
import Model.accountModel;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "EditAccountControl", urlPatterns = {"/editAccountControl"})
public class EditAccountControl extends HttpServlet {
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
        String id1 = request.getParameter("accid");
        int accID = Integer.parseInt(id1);
        accountDAO dao = new accountDAO();
        accountModel account = dao.getAccountByID(accID);
        request.setAttribute("acc", account);
        request.getRequestDispatcher("editAccount.jsp").forward(request, response);
    }

}
