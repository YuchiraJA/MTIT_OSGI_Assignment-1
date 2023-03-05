package book_store_supplier_producer;

import java.util.List;



public class BookSuppierServiceImpl implements BookSuppierService {


	@Override
	public synchronized int  addItems(String bookName,double itemPrice,double discount) {

		Supplier newItem = new Supplier(BookDataStore.itemsList.size() + 1, bookName, itemPrice, discount);
		BookDataStore.itemsList.add(newItem);

	return 1;		
	}

	@Override
	public  synchronized int updateItems(String updatedItemName,double updatedItemPrice,double updatedItemDiscount) {
		Supplier itemToBeUpdated = null;
		boolean invalid = true;
		int count = -1;
		for (Supplier tempItem : BookDataStore.itemsList) {
			count++;
			if (tempItem.getbookName().equalsIgnoreCase(updatedItemName)) {

				itemToBeUpdated = tempItem;
				invalid = false;
				break;
			}
		
		}
		if (!invalid) {

			itemToBeUpdated.setbookName(updatedItemName);
			itemToBeUpdated.setItemPrice(updatedItemPrice);
			itemToBeUpdated.setDiscount(updatedItemDiscount);
			itemToBeUpdated.calculatefinalPriceInbook();

			BookDataStore.itemsList.set(count, itemToBeUpdated);
			return 1;

		} else {
			return -1;
		}
				
	}

	@Override
	public  synchronized int removeItems1(String bookName) {

		boolean invalid = true;
		int count = -1;
		for (Supplier tempItem :BookDataStore.itemsList) {
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
	
		for (Supplier tempItem : BookDataStore.itemsList) {
		
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
	public List<Supplier> listItems() {

		return BookDataStore.itemsList;
	}

	@Override
	public List<Supplier> listItems1() {
		// TODO Auto-generated method stub
		return null;
	}
}