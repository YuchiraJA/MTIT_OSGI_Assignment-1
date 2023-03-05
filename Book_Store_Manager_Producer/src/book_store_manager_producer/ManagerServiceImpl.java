package book_store_manager_producer;

import java.util.List;



public class ManagerServiceImpl implements ManagerActivaterService {


	@Override
	public synchronized int  addItems(int qty,int price,String bookType) {

		Manager newItem = new Manager( qty, price, bookType);
		ManagerDataStore.itemsList.add(newItem);

	return 1;		
	}


	@Override
	public  synchronized int removeItems1(String bookType) {

		boolean invalid = true;
		int count = -1;
		for (Manager tempItem :ManagerDataStore.itemsList) {
			count++;
			if (tempItem.getbookType().equalsIgnoreCase(bookType)) {
			
				invalid = false;
				break;
			}
		}
		if (!invalid) {

			ManagerDataStore.itemsList.remove(count);
			return 1;

		} else {
			return -1;
		}
	}

	@Override
	public int searchitems(String bookType) {
		boolean valid = false;
	
		for (Manager tempItem : ManagerDataStore.itemsList) {
		
			if (tempItem.getbookType().equalsIgnoreCase(bookType)) {

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
	public List<Manager> listItems() {

		return ManagerDataStore.itemsList;
	}

	@Override
	public List<Manager> listItems1() {
		// TODO Auto-generated method stub
		return null;
	}
}