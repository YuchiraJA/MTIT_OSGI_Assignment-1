package book_store_supplier_producer;

public class Supplier {

	private int  bookId;
	private String bookName;
	private double itemPrice;
	private double discount;
	private double finalPriceinbook;
	
	public Supplier(int bookId, String bookName, double itemPrice, double discount) {
		super();
		bookId = bookId;
		this.bookName = bookName;
		this.itemPrice = itemPrice;
		this.discount = discount;
		calculatefinalPriceInbook();
		
	}
	

	public int getbookID() {
		return bookId;
	}

	public void setbookID(int bookId) {
		bookId = bookId;
	}


	public String getbookName() {
		return bookName;
	}


	public void setbookName(String bookName) {
		this.bookName = bookName;
	}


	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getFinalPriceinbook() {
		return finalPriceinbook;
	}

	public void setFinalPriceinbook(double finalPriceinbook) {
		this.finalPriceinbook = finalPriceinbook;
	}


	void calculatefinalPriceInbook() {
		this.finalPriceinbook = itemPrice * ((100.00- discount)/100.00) ;
		// TODO Auto-generated method stub
		
	}
	
	

}