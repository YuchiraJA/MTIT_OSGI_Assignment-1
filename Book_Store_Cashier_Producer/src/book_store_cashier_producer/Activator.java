package book_store_cashier_producer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;





public class Activator implements BundleActivator {

	private static BundleContext Bcontext;

	static BundleContext getContext() {
		return Bcontext;
	}

	
	public void start(BundleContext context) throws Exception {
		Activator.Bcontext = context;
		
		
		context.registerService(BookStoreBillingService.class.getName(),new BookStoreBillingServiceImpl(),null);
		System.out.println("-------------Book Store Billing System Started Successfully-------------");
		
		DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");  
		LocalDateTime now = LocalDateTime.now();  
		System.out.println(dateTime.format(now));
		
	}

	
	public void stop(BundleContext context) throws Exception {
		Activator.Bcontext = null;
		DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");  
		LocalDateTime now = LocalDateTime.now();  
		System.out.println("=============================================================");
		
		System.out.println(" Your Order Bill Closed Time :  "+ dateTime.format(now));  
		System.out.println("*****Book Store Billing System Stopped Successfully******");
		
		System.out.println("Thank you for your Buy Our Products! ****Book Store*** ");
		
	}

}