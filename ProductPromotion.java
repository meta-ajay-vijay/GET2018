package Assignment1.ShoppingCart.Promotion;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import Assignment1.ShoppingCart.*;

import Assignment1.ShoppingCart.Product;

public class ProductPromotion implements Promotion {

	public enum PromotionEnum {

		PRODUCTPROMOCODE1("flat10", "2018-08-01", "2018-08-20"),
		PRODUCTPROMOCODE2("flat20", "2018-08-05", "2018-08-15");
		
		
		public String promotionName;
		private Date startDate;
		private Date endDate;
		
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
		
	}

	ProductPromotion.PromotionEnum pEnum;
	public float minimumPrice;
	public float fixedDiscount;

	public ProductPromotion() {
	}

	public ProductPromotion(ProductPromotion.PromotionEnum pEnum, double minPrice, float fixDiscount) {

	}

	public ProductPromotion.PromotionEnum getpEnum() {
		return pEnum;
	}

	public void setpEnum(ProductPromotion.PromotionEnum pEnum) {
		this.pEnum = pEnum;
	}

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
		boolean flag= false;
		
		return flag;
	}

}