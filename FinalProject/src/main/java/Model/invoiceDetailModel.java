package Model;

public class invoiceDetailModel {
	private int invoiceID;
	private int productID;
	private int ammount;
	
	public invoiceDetailModel() {
		
	}
	
	public invoiceDetailModel(int invoiceID, int productID, int ammount) {
		this.invoiceID = invoiceID;
		this.productID = productID;
		this.ammount = ammount;
	}
	
	public int getInvoiceID() {
		return invoiceID;
	}
	public void setInvoiceID(int invoiceID) {
		this.invoiceID = invoiceID;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getAmmount() {
		return ammount;
	}
	public void setAmmount(int ammount) {
		this.ammount = ammount;
	}
	
}
