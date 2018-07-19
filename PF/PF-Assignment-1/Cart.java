package Assignment1.ShoppingCart;
import Assignment1.ShoppingCart.Product;
import java.util.ArrayList;
import java.util.Iterator;
import myUtility.inputValidation;

/**
 * @author ajayr
 *
 */
public class Cart extends Product {

	public ArrayList<Product> cart;

	public Cart() {
		cart = new ArrayList<Product>();
	}

	/**
	 * @param newProduct
	 *            : product we want to add in cart
	 */
	public void addProduct(Product newProduct) {
		cart.add(newProduct);
	}

	/**
	 * removes the product from cart
	 * 
	 * @param prodId
	 * @return reply boolean value based on the success or failure of operation
	 */
	public boolean removeProduct(int prodId) {
		int indexOfItem = inputValidation.productAvailabilityInCart(prodId, cart);
		boolean reply = false;
		if (indexOfItem > -1) {
			System.out.println("Item with " + cart.remove(indexOfItem).productId + " is removed.");
			reply = true;
		} else {
			System.out.println("You don't have this item in your cart.");
			reply = false;
		}
		return reply;
	}

	/**
	 * update a given item in cart if it is available in cart
	 * 
	 * @param productToUpdate
	 * @return reply boolean value based on the success or failure of operation
	 */
	public int updateProduct(Product productToUpdate, ArrayList<Product> toChangeAfterUpdate) {

		int idOfUpdate = productToUpdate.productId;
		int indexOfItemToUpdate = inputValidation.productAvailabilityInCart(idOfUpdate, cart);
		int remainingQuantity=0;
		if (indexOfItemToUpdate == -1) {
			System.out.println("Sorry! Item you want to update is not in your cart");
			remainingQuantity = toChangeAfterUpdate.get(inputValidation.productAvailability(idOfUpdate, toChangeAfterUpdate)).productQuantity;
		} else if (productToUpdate.productQuantity != 0) {
			remainingQuantity = cart.get(indexOfItemToUpdate).productQuantity + 
					toChangeAfterUpdate.get(inputValidation.productAvailability(idOfUpdate, toChangeAfterUpdate)).productQuantity - productToUpdate.productQuantity;
			cart.get(indexOfItemToUpdate).productQuantity = productToUpdate.productQuantity;

		}
		return remainingQuantity;

	}

	public void displayCart() {

		Iterator<Product> cartIterator = cart.iterator();

		while (cartIterator.hasNext()) {

			(cartIterator.next()).displayProduct();
			System.out.println();

		}
	}

	public boolean isCartEmpty() {
		boolean reply = false;
		if (cart.size() == 0) {
			reply = true;
		}
		return reply;
	}

	public int findProduct(int pId) {

		int reply = -1;
		for (int i = 0; i < cart.size(); i++) {
			if (pId == cart.get(i).productId) {
				reply = i;
				break;
			}
		}

		return reply;

	}

	public void generateBill() {
		boolean reply = false;
		System.out.println("Product\tPrice");
		double totalBill = 0;
		for (int i = 0; i < cart.size(); i++) {
			System.out.println(
					cart.get(i).productName + "\t" + cart.get(i).productCost + "*" + cart.get(i).productQuantity);
			totalBill += cart.get(i).productCost * cart.get(i).productQuantity;
		}
		System.out.println("Total:\t" + totalBill);
	}

	/**
	 * @override
	 * @return ListIterator for products in cart
	 */
	public Iterator<Product> iterator() {
		return cart.iterator();
	}

}
