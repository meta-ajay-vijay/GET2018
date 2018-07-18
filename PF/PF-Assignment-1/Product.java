package product;
public class Product {
		
		public String productName;
		public double productCost;
		public int productQuantity;
		public int productId;

		/**
		 * Default Constructor
		 */
		public Product() {
			
		}
		
		/**
		 * Paramerterized Constructor
		 * @param name : name of product
		 * @param cost : cost of product
		 * @param quantity : quantityof product
		 * @param id : product id
		 */
		public Product(int id, String name, double cost, int quantity) {
			this.productName = name;
			this.productCost = cost;
			this.productQuantity = quantity;
			this.productId = id;
		}
		
		public void displayProduct() {
			System.out.println( this.productId + "\t" + this.productName + "\t"  + this.productCost + "\t" + this.productQuantity);
		}
		
		/**
		 * @return the productName
		 */
		public String getProductName() {
			return productName;
		}

		/**
		 * @param productName the productName to set
		 */
		public <String> void setProductName(String productName) {
			this.productName =  (java.lang.String) productName;
		}

		/**
		 * @return the productCost
		 */
		public double getProductCost() {
			return productCost;
		}

		/**
		 * @param productCost the productCost to set
		 */
		public void setProductCost(double productCost) {
			this.productCost =  productCost;
		}

		/**
		 * @return the productQuantity
		 */
		public int getProductQuantity() {
			return productQuantity;
		}

		/**
		 * @param productQuantity the productQuantity to set
		 */
		public void setProductQuantity(int productQuantity) {
			this.productQuantity = productQuantity;
		}

		/**
		 * @return the productId
		 */
		public int getProductId() {
			return productId;
		}

		/**
		 * @param productId the productId to set
		 */
		public void setProductId(int productId) {
			this.productId = productId;
		}
		
}