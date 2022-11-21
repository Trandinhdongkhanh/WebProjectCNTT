package Model;

public class Product_Cart_Model {
	private int productID;
	private String productName;
	private int price;
	private int ammount;
	
	public Product_Cart_Model() {
		
	}
	
	public Product_Cart_Model(int productID ,String productName, int price, int ammount) {
		this.productID = productID;
		this.productName = productName;
		this.price = price;
		this.ammount = ammount;
	}
	
	
	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAmmount() {
		return ammount;
	}
	public void setAmmount(int ammount) {
		this.ammount = ammount;
	}
	
	
}
