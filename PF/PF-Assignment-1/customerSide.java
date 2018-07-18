/**
 * @author ajay
 * @version 1.8.0_73
 */
package custormer;

import Cart.Cart;

import java.util.*;

import myUtility.inputValidation;
import product.Product;

/**
 * Cart class implements Shopping Cart
 */
public class customerSide extends Exception {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		Cart cartObject = new Cart();
		ArrayList<Product> productList = new ArrayList<Product>();

		Product product1 = new Product(1, "Samsung", 10000, 100);
		Product product2 = new Product(2, "Xiaomi", 8000, 500);
		Product product3 = new Product(3, "Oppo", 3000, 50);
		Product product4 = new Product(4, "Vivo", 5000, 60);
		Product product5 = new Product(5, "Nokia", 11000, 90);
		productList.add(product1);
		productList.add(product2);
		productList.add(product3);
		productList.add(product4);
		productList.add(product5);

		int choice = 0;

		do {
			System.out
					.println("****************SHOPPING MALL*****************");
			System.out.println("ID\tName\tPrice\tQuantity");
			for (int i = 0; i < productList.size(); i++) {
				productList.get(i).displayProduct();
			}

			System.out.println("1. Add item in cart");
			System.out.println("2. Remove item from cart");
			System.out.println("3. Update item in cart");
			System.out.println("4. Show the content of cart");
			System.out.println("5. Checkout");
			System.out.println("6. Exit");

			choice = inputValidation.isInt();
			int prodId, prodQuantity;

			switch (choice) {

			case 1:
				Product newProductAdd = new Product();

				System.out.println("Enter Product details");

				System.out.println("Enter product id: ");

				int idFlag = 0;
				do {
					prodId = inputValidation.isInt();

					int i = inputValidation.productAvailability(prodId,
							productList);
					if (i > -1) { // check product availability

						int flagForQuantity = 0;
						do {
							System.out.println("Enter product quantity: ");
							prodQuantity = inputValidation.isInt();
							if (productList.get(i).productQuantity >= prodQuantity) {// check
																						// product
																						// quantity
								newProductAdd.productId = productList.get(i).productId;
								newProductAdd.productName = productList.get(i).productName;
								newProductAdd.productCost = productList.get(i).productCost;
								newProductAdd.productQuantity = prodQuantity;
								productList.get(i).productQuantity -= prodQuantity;
							} else if (productList.get(i).productQuantity < prodQuantity) {
								System.out
										.println("We don't have this much quantity\nPlease enter again");
								flagForQuantity = 1;
							}
						} while (flagForQuantity == 1);
						idFlag = 1;
					} else {
						System.out
								.println("We don't have this item. Please select another item.");

					}
				} while (idFlag != 1);

				cartObject.addProduct(newProductAdd);
				break;

			case 2:
				if (!cartObject.isCartEmpty()) {
					System.out
							.print("Enter the product id of product you want to delete: ");
					int pidToRemove = inputValidation.isInt();
					cartObject.removeProduct(pidToRemove);

				} else {
					System.out.println("Sorry! Your cart is empty.");
				}

				break;

			case 3:
				if (!cartObject.isCartEmpty()) {
					Product updatedProduct = new Product();
					System.out
							.print("Enter the product id of product you want to update: ");
					int pidToUpdate = inputValidation.isInt(); // check if id is
																// integer or
																// string

					if (cartObject.findProduct(pidToUpdate) > -1) { // check if
																	// product
																	// is
						updatedProduct.productId = pidToUpdate; // in cart

						System.out.println("What do you want to update?");
						System.out.println("1. Name\t2. Cost\t3. Quantity");
						int choiceOfUpdate = scan.nextInt();
						switch (choiceOfUpdate) {

						case 1:
							System.out.print("Enter new name: ");
							updatedProduct.productName = scan.next();
							break;

						case 2:
							System.out.print("Enter new cost: ");
							updatedProduct.productCost = scan.nextInt();
							break;

						case 3:
							System.out.print("Enter new Quantity: ");
							updatedProduct.productQuantity = scan.nextInt();
							break;
						}

						cartObject.updateProduct(updatedProduct);
					} else {
						System.out
								.println("Sorry! You don't have this item in your cart");
					}

				} else {
					System.out.println("Sorry! Your cart is empty");
				}
				break;

			case 4:
				if (!cartObject.isCartEmpty()) {
					cartObject.displayCart();
				} else {
					System.out.println("Sorry! Your cart is empty");
				}

				break;

			case 5:
				if (!cartObject.isCartEmpty()) {
					cartObject.generateBill();
				}else{
					System.out.println("Empty cart");
				}

			case 6:
				System.exit(0);
				break;

			default:
				System.out.println("Please enter valid input");
				break;
			}

		} while (choice != 6);

	}
}
