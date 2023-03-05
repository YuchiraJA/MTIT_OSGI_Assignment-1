package book_store_cashier_consumer;


import java.util.ArrayList;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;

import book_store_cashier_producer.BookStoreBillingService;
import book_store_cashier_producer.BookStoreBillingServiceImpl;


public class Activator implements BundleActivator {

    private static BundleContext context = null;
    ServiceReference serviceReference;
    private ServiceTracker serviceTracker = null;
    
    boolean exit = false;
    
    static BundleContext getContext() {
        return context;
    }
    
    
    public void start(BundleContext bundleContext) throws Exception {
        Activator.context = bundleContext;
        
        serviceTracker = new ServiceTracker(context, context.createFilter("(&(objectClass="+BookStoreBillingService.class.getName()+")"+"(Language=*))"),null);
        serviceTracker.open();
        

        int BookitemID;
        int BookQuantity = 0;
        float Amount = 0;
        float discountPrice = (float) 0.10;
        float TotalPrice = 0;
        int StokeHaveQuantity = 10;
        char choicedItem;
        
        ArrayList<String> Books = new ArrayList<String>();
        ArrayList<String> Author=new ArrayList<String>();
        ArrayList<Float> Bookprice = new ArrayList<Float>();
        
        
        Books.add("Moon Child \t");
        Author.add("Chathushkia Jayasinghe \t");
        Bookprice.add((float) 350.00);
        
        Books.add("Atomic Habits \t");
        Author.add("James Clear \t");
        Bookprice.add((float) 450.00);
        
        Books.add("The Savage Dance \t");
        Author.add("Nivanka Fernando \t");
        Bookprice.add((float) 350.00);
        
        Books.add("Moonstone \t");
        Author.add("Daya Dissanayake \t");
        Bookprice.add((float) 490.00);
        
        Books.add("Miracle Under the Kumbuk Tree \t");
        Author.add("Daya Dissanayake\t");
        Bookprice.add((float) 400.00);
        
        Books.add("THE RED BALCONY  \t");
        Author.add("Jonathan Wilson \t");
        Bookprice.add((float) 750.00);
        
        Books.add("The Last Tale of The Flower Bride \t");
        Author.add("Roshani Chokshi \t");
        Bookprice.add((float) 900.00);
        
        Books.add("Nightbirds \t");
        Author.add("Kate J. Armstorng\t");
        Bookprice.add((float) 1000.00);
        
        Books.add("She Is A Haunting \t");
        Author.add("Trang Thanh Tran\t");
        Bookprice.add((float) 1050.00);
        
        Books.add("Evergreen \t");
        Author.add("Matthew Cordell \t");
        Bookprice.add((float) 950.00);
        
        Books.add("Stick And Stone On The Go \t");
        Author.add("Beth Ferry \t");
        Bookprice.add((float) 800.00);
        
        Books.add("Stars Of the Night \t");
        Author.add("Caren Stelson \t");
        Bookprice.add((float) 1600.00);
        
        Books.add("The Last Mapmaker \t");
        Author.add("Christina SoonTornvat \t");
        Bookprice.add((float) 890.00);
        
        

        Scanner scanner = new Scanner(System.in);
        BookStoreBillingService BookBill = new BookStoreBillingServiceImpl();
        

        do {
            int selection = 3;
            do {
            
            	System.out.println("\n--------------Welcome to  Book Shop Cashier Interface--------------- \n");
            
            System.out.println("Please Select an option to continue.....\n");
         
            System.out.println("1.View availabe Books ");
            System.out.println("2.Generate bill");
            System.out.println("3.Exit \n");
            
            System.out.println("Enter your selection : \n ");
            selection = scanner.nextInt();
            scanner.nextLine();
            
             
             if(selection == 3) {
                 exit = true;
             }
             
             if(selection !=1 &&  selection !=2 && selection !=3 ) {
                 System.out.println("Please enter a valid selection");
             }
            }while(selection !=1  && selection !=2 && selection !=3 );
            
        
            String  backToHome = null;
            if (selection == 1) {
                do {
                    
                    for (int i = 0; i < Bookprice.size(); i++)
                    {
                      System.out.println(i+1 + "  " +Books.get(i) +"  Rs:"+Bookprice.get(i));
                    }

                System.out.println("Press 0 to navigate back to home or press any other key to continue....");
                
                backToHome=scanner.nextLine();
                
                }
                
                while(!(backToHome.equals("0")));
    
            }
            else if (selection == 2) {
                do {

                    for (int i = 0; i < Bookprice.size(); i++)
                    {
                      System.out.println(i+1 + "  " +Books.get(i) +"  Rs:"+Bookprice.get(i));
                    }
                  System.out.println();
                  do {
                      System.out.println("\n Enter the Book name or item number you need : ");
                      BookitemID = scanner.nextInt();
                      
                      System.out.println("Enter number of quentity you need : ");
                      if(BookQuantity > StokeHaveQuantity) {
                          System.out.println("*****There is No More stock Available At This Moment*****");
                      }
                      else {
                          
                      }
                      BookQuantity = (int) scanner.nextFloat();
                          
                          System.out.print("Do you want to buy Other item?  (y or n): \n ");
                          choicedItem = scanner.next().charAt(0);   
                  
                   Amount = BookBill.BillingService(Books, Bookprice,BookQuantity, BookitemID);
                  }while(choicedItem == 'y' || choicedItem == 'Y');
                  System.out.println("=============================================================");
                  
                  if(Amount >= 150000) {
                      TotalPrice = Amount - (Amount * discountPrice);
                      System.out.println("Discount :" + Amount * discountPrice);
                  }
                  else {
                      
                      TotalPrice = Amount;
                      //System.out.println("Discount  price : 0.00");
                  }
                      System.out.println("Total price  : " + Amount);
                      
                      System.out.println("Payble Price : "+ TotalPrice);
                      
                      System.out.println("=============================================================");
                   
                
                    System.out.println("Press 0 to navigate back to home or press any other key to continue...");
                
                    backToHome=scanner.nextLine();
                    backToHome=scanner.nextLine();
                    
                }
                
                while(!(backToHome.equals("0")));
    
            }
        
            else if(selection == 3) {//Exits form the Customer consumer program
                return;
            }
        }while(!exit);  
}

    
    public void stop(BundleContext bundleContext) throws Exception {
        Activator.context = null;
    }

}
