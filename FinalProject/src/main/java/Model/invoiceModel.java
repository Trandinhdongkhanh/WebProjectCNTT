package Model;

import java.util.Date;

public class invoiceModel {
	private int invoiceID;
	private int accID;
	private double total;
	Date create_date;
	public invoiceModel(int invoiceID, int accID, double total, Date create_date) {
		
		this.invoiceID = invoiceID;
		this.accID = accID;
		this.total = total;
		this.create_date = create_date;
	}
	public invoiceModel() {
		
	}
	public int getinvoiceID() {
		return invoiceID;
	}
	public void setinvoiceID(int invoiceID) {
		this.invoiceID = invoiceID;
	}
	public int getaccID() {
		return accID;
	}
	public void setaccID(int accID) {
		this.accID = accID;
	}
	public double gettotal() {
		return total;
	}
	public void settotal(double total) {
		this.total = total;
	}
	public Date getcreate_date() {
		return create_date;
	}
	public void setcreate_date(Date create_date) {
		this.create_date = create_date;
	}
}
