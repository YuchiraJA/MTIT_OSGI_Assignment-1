package book_store_manager_producer;

public class Manager {

	private int  qty;
	private int price;
	private String bookType;
	private int totalvalue;
	
	
	public Manager(int qty, int price, String bookType) {
		super();
		this.qty=qty;
		this.price = price;
		this.bookType = bookType;
		caltotalValue();	
	}
	

	public int getqty() {
		return qty;
	}

	public void setqty(int qty) {
		this.qty = qty;
	}


	public int getprice() {
		return price;
	}


	public void setprice(int price) {
		this.price = price;
	}


	public String getbookType() {
		return bookType;
	}

	public void setbookType(String bookType) {
		this.bookType = bookType;
	}

	public int gettotal() {
		return totalvalue;
	}

	public void settotal(int totalvalue) {
		this.totalvalue = totalvalue;
	}


	void caltotalValue() {
		this.totalvalue=this.qty*this.price;
		
	}
	

}













