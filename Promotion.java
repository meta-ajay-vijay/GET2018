package Assignment1.ShoppingCart.Promotion;

import Assignment1.ShoppingCart.Product;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public interface Promotion {
	public enum PromotionEnum {
		ORDERPROMOCODE1("diwali20", "2018-08-01", "2018-08-25", 20000),
		ORDERPROMOCODE2("first40", "2018-08-05", "2018-09-05", 18000),
		ORDERPROMOCODE3("independence50", "2018-08-10", "2018-08-15", 10000),
		PRODUCTPROMOCODE1("flat10", "2018-08-01", "2018-08-20"),
		PRODUCTPROMOCODE2("flat20", "2018-08-05", "2018-08-15");
		
		
		public String promotionName;
		private Date startDate;
		private Date endDate;
		float minimumPrice;
		
		PromotionEnum(String promotionName, String startDate, String endDate){
			this.promotionName = promotionName;
			DateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
			try {
				this.startDate = myFormat.parse(startDate);
				this.endDate = myFormat.parse(endDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		PromotionEnum(String promotionName, String startDate, String endDate, float minimumPrice){
			this.promotionName = promotionName;
			DateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
			try {
				this.startDate = myFormat.parse(startDate);
				this.endDate = myFormat.parse(endDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}
	 public float getMinimumPrice();
	 public void setMinimumPrice(float priceToSet);
	 public float getFixedDiscount(); 
	 public void setFixedDiscount(float discountToSet);
	 public boolean isPromotionApplicable(Product product);

}
