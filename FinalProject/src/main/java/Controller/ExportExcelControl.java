package Controller;

import DAO.accountDAO;
import DAO.invoiceDAO;
import Model.accountModel;
import Model.invoiceModel;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@WebServlet(name = "ExportExcelControl", urlPatterns = {"/exportExcelControl"})
public class ExportExcelControl extends HttpServlet {
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
        String createdate = request.getParameter("createdate");  
        invoiceDAO dao = new invoiceDAO();
        accountDAO dao1 = new accountDAO();
        List<invoiceModel> list = dao.searchByCreateDate(createdate);
        List<accountModel> listAllAccount = dao1.getAllAccount();
        List<invoiceModel> listAllInvoice = dao.getAllinvoiceModel();
        
        if(createdate==null || createdate=="")
        {
        	ExportExcel(listAllInvoice, listAllAccount, createdate);
        	request.setAttribute("mess", "Export All Invoice Successful");
        	request.getRequestDispatcher("invoice").forward(request, response);
        }
        
        else {
	        ExportExcel(list, listAllAccount,createdate);
	        request.setAttribute("mess", "Export Excel successful!");
	        request.getRequestDispatcher("invoice").forward(request, response);
        }
    }
    public void ExportExcel(List<invoiceModel> list, List<accountModel> listAllAccount, String createdate) throws IOException 
	{
		FileOutputStream file=new FileOutputStream("D:\\"+createdate+"invoice.xlsx");
	    XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet workSheet=workbook.createSheet("1");
        XSSFRow row;
        XSSFCell cell0;
        XSSFCell cell1;
        XSSFCell cell2;
        XSSFCell cell3;
        XSSFCell cell4;
     
        row=workSheet.createRow(0);
        cell0=row.createCell(0);
        cell0.setCellValue("invoiceID");
        cell1=row.createCell(1);
        cell1.setCellValue("accID");
        cell2=row.createCell(2);
        cell2.setCellValue("userName");
        cell3=row.createCell(3);
        cell3.setCellValue("total($)");
        cell4=row.createCell(4);
        cell4.setCellValue("create_date");
        int i=0;
        for(invoiceModel invoi: list) {
        	i=i+1;
        	for(accountModel acc: listAllAccount) {
        		if (invoi.getaccID() == acc.getAccID()) {
        			row=workSheet.createRow(i);
		   			cell0=row.createCell(0);
		   		    cell0.setCellValue(invoi.getinvoiceID());
		   		    cell1=row.createCell(1);
		   		    cell1.setCellValue(invoi.getaccID());
		   		    cell2=row.createCell(2);
		   		    cell2.setCellValue(acc.getUserName());
		   		    cell3=row.createCell(3);
		   		    cell3.setCellValue(invoi.gettotal());
		   		    cell4=row.createCell(4);
		   		    cell4.setCellValue(invoi.getcreate_date());
        		}
        	}
        }
	    workbook.write(file);
	    workbook.close();
	    file.close();
	}
}


