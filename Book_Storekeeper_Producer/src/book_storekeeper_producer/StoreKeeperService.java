package book_storekeeper_producer;

import java.util.List;

public interface StoreKeeperService {

	List<Book> listItems();

	public  int  addItems(String bookName,int quantity);   //Add the new items to the item store
	public   int removeItems1(String itemName);             //Removes the items from the store
	public   int searchitems(String itemName);             //Searches and item by name
	public   List<Book> listItems1();                   //Returns the item store


}
