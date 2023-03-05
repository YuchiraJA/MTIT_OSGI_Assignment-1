package book_store_cashier_producer;

import java.util.ArrayList;

public class BookStoreBillingServiceImpl implements BookStoreBillingService {

	
	float TotalAmount = 0;
	int StokeHaveQuantity = 10;
	
	@Override
	public float BillingService(ArrayList<String> Books, ArrayList<Float> Bookprice, int BookQuantity,int BookitemID) {
		// TODO Auto-generated method stub
		
		float Book_Or_PartPrice = (float)Bookprice.get(BookitemID-1);
		
		System.out.println(Books.get(BookitemID-1) + "  X  "+ BookQuantity+" = "+(Book_Or_PartPrice * BookQuantity));
		
		TotalAmount = TotalAmount + (Book_Or_PartPrice * BookQuantity);
		
		return TotalAmount;
		
	}

	@Override
	public int getBookStock() {
		// TODO Auto-generated method stub
		return StokeHaveQuantity;
	}
	

}
