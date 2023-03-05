package book_storekeeper_producer;

public class Book {

	private int  bookId;
	private String bookName;
	private int quantity;

	
	public Book(int bookId, String bookName, int quantity) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.quantity = quantity;
	
		
	}
	

	public int getbookID() {
		return bookId;
	}

	public void setbookID(int bookId) {
		this.bookId = bookId;
	}


	public String getbookName() {
		return bookName;
	}


	public void setbookName(String bookName) {
		this.bookName = bookName;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	}
