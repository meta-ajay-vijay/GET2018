package Cart;

import product.Product;
import java.util.ArrayList;
import java.util.Iterator;
import myUtility.inputValidation;

;

public class Cart extends Product {

	ArrayList<Product> cart;

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

	public boolean removeProduct(int prodId) {
		int indexOfItem = inputValidation.productAvailabilityInCart(prodId,
				cart);
		boolean reply = false;
		if (indexOfItem > -1) {
			System.out.println("Item with "
					+ cart.remove(indexOfItem).productId + " is removed.");
			reply = true;
		} else {
			System.out.println("You don't have this item in your cart.");
			reply = false;
		}
		return reply;
	}

	public boolean updateProduct(Product productToUpdate) {

		int idOfUpdate = productToUpdate.productId;
		int indexOfItemToUpdate = inputValidation.productAvailabilityInCart(
				idOfUpdate, cart);
		boolean reply = true;
		if (indexOfItemToUpdate == -1) {
			System.out
					.println("Sorry! Item you want to update is not in your cart");
			reply = false;
		} else {
			if (productToUpdate.productName != null) {
				cart.get(indexOfItemToUpdate).productName = productToUpdate.productName;
			}

			if (productToUpdate.productCost != 0.0) {
				cart.get(indexOfItemToUpdate).productCost = productToUpdate.productCost;
			}

			if (productToUpdate.productQuantity != 0) {
				cart.get(indexOfItemToUpdate).productQuantity = productToUpdate.productQuantity;
			}
		}
		return reply;

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
			System.out.println(cart.get(i).productName + "\t"
					+ cart.get(i).productCost + "*"
					+ cart.get(i).productQuantity);
			totalBill += cart.get(i).productCost*cart.get(i).productQuantity;
		}
		System.out.println("Total:\t"+totalBill);
	}

	/**
	 * @override
	 * @return ListIterator for products in cart
	 */
	public Iterator<Product> iterator() {
		return cart.iterator();
	}

}
