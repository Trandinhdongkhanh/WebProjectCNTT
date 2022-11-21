package Model;

public class SoLuongDaBanModel {
	private int productID;
	private int sold;
	
	public SoLuongDaBanModel() {
		
	}
	
	public SoLuongDaBanModel(int productID, int sold) {
		this.productID = productID;
		this.sold = sold;
	}
	
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getSold() {
		return sold;
	}
	public void setSold(int sold) {
		this.sold = sold;
	}
	
}
