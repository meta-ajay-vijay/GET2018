package myUtility;
import product.Product;
import java.util.*;
import Cart.Cart;

public class inputValidation {
	
	static Scanner scan = new Scanner(System.in);
	public static int isInt() {
		int flag,choice=0;
		do {
			
			try {
				choice = scan.nextInt();
				
				flag= 0;
			}
			catch( InputMismatchException e ) {
				flag= 1;
				System.out.println("Please enter a valid input");
				scan.next();
			}
		}while(flag != 0);
		
		return choice;
	}
	
	public static int productAvailability(int pid, ArrayList<Product> plist){
		int reply=-1;
		for(int i=0; i<plist.size(); i++)
		{
			if(pid == plist.get(i).productId){
				reply= i;
				break;
			}
		}
		
		return reply;
	}
	
	public static int productAvailabilityInCart(int pid, ArrayList<Product> plist){
		int reply=-1;
		for(int i=0; i<plist.size(); i++)
		{
			if(pid == plist.get(i).productId){
				reply= i;
				break;
			}
		}
		
		return reply;
	}
	
}