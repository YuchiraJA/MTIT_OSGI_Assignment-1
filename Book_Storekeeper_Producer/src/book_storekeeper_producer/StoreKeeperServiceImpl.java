package book_storekeeper_producer;

import java.util.List;



public class StoreKeeperServiceImpl implements StoreKeeperService {


	@Override
	public synchronized int  addItems(String bookName,int quantity) {

		
		Book newItem = new Book(BookDataStore.itemsList.size() + 1, bookName, quantity);
		BookDataStore.itemsList.add(newItem);

	return 1;		
	}


	@Override
	public  synchronized int removeItems1(String bookName) {

		boolean invalid = true;
		int count = -1;
		for (Book tempItem :BookDataStore.itemsList) {
			count++;
			if (tempItem.getbookName().equalsIgnoreCase(bookName)) {
			
				invalid = false;
				break;
			}
		}
		if (!invalid) {

			BookDataStore.itemsList.remove(count);
			return 1;

		} else {
			return -1;
		}
	}

	@Override
	public int searchitems(String bookName) {
		boolean valid = false;
	
		for (Book tempItem : BookDataStore.itemsList) {
		
			if (tempItem.getbookName().equalsIgnoreCase(bookName)) {

				valid = true;
				break;

			}			

		}
		if(valid) {
			return 1;
			
		}
		else {
			return -1;
		}
		
	}

	@Override
	public List<Book> listItems() {

		return BookDataStore.itemsList;
	}

	@Override
	public List<Book> listItems1() {
		// TODO Auto-generated method stub
		return null;
	
	}


}