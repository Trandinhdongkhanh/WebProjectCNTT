package Model;

public class cartModel {
	private int cartID;
	private int accID;
	private int productID;
	private int ammount;
	private String size;
	
	public cartModel() {
		
	}
	
	public cartModel(int cartID, int accID, int productID, int ammount, String size) {
		this.cartID = cartID;
		this.accID = accID;
		this.productID = productID;
		this.ammount = ammount;
		this.size = size;
	}
	
	public int getCartID() {
		return cartID;
	}
	public void setCartID(int cartID) {
		this.cartID = cartID;
	}
	public int getAccID() {
		return accID;
	}
	public void setAccID(int accID) {
		this.accID = accID;
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
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	
	
}
