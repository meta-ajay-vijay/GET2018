package Assignment1.ShoppingCart.Promotion;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Assignment1.ShoppingCart.Product;

class OrderPromotion implements Promotion {

	public enum PromotionEnum {
		
		firstorder50("FIRSTORDER50", "2018-07-15", "2018-07-31"),
		jaipur33("JAIPUR33", "2018-07-21", "2018-08-20");
		
		
		private String nameOfPromocode;
		private Date Start_Date;
		private Date End_Date;
		
		PromotionEnum(String name, String startDate, String endDate){
			DateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
			this.nameOfPromocode= name;
			try{
				this.Start_Date = myFormat.parse(startDate);
				this.End_Date = myFormat.parse(endDate);
			    }catch (ParseException e)
				{
					e.printStackTrace();
				}
		}
		
	}
	
	public float minimumPrice;
	public float fixedDiscount;
	
	 public float getMinimumPrice() {
		 return this.minimumPrice;
	 }
	 
	 public void setMinimumPrice(float priceToSet) {
		 this.minimumPrice = priceToSet;
	 }
	 
	 public float getFixedDiscount() {
		 return this.fixedDiscount;
	 }
	 
	 public void setFixedDiscount(float discountToSet) {
		 this.fixedDiscount = discountToSet;
	 }
	 public boolean isPromotionApplicable(Product product) {
		 boolean reply = false;
		 
		 
		 return reply;
	 }

}