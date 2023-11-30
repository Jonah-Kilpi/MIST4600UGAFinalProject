import java.util.HashSet;
import java.util.Scanner;
import java.util.HashMap;
public class Checkout {

	private static HashSet<String> Checkout = new HashSet<String>();
	private static HashMap<String,Double> TodayProducts = new HashMap<String, Double>();
	private static HashSet<Product> allProducts;

	private int i;
	private static double totalCostofCart;
	private static double Discount;
	private User user;
	
	public Checkout(User user) {
		this.user = user;
	}
	public static void setAllProducts(HashSet<Product> products) {
		allProducts = products;
	}
	public static Product getProductByName(String productName) {
		for (Product product : allProducts) {
			if (product.getName().equalsIgnoreCase(productName)) {
				return product;
			}
		}
		return null;
	}
	public static void addItemsToCart (Product product) {
		Checkout.add(product.getName().toLowerCase());
	}
	public void removeItemsFromCart (Product product) {
		Checkout.remove(product.getName().toLowerCase());
		TodayProducts.remove(product.getName());
	}

	public static void Selections(String id, Double price) {
		TodayProducts.put(id, price);
	}
	
	public static void CalculateCart() {
		for(String Products : TodayProducts.keySet()) {

			String Checker = Products.toLowerCase();

			if(Checkout.contains(Checker)) {
				System.out.println(Products + ": " + TodayProducts.get(Products));
				totalCostofCart += TodayProducts.get(Products);
			}
		}
	}
	public static void DiscountCheck(Boolean Holder) {
		
		if(Holder) {
			Discount = .9;
		}
		else {
			Discount = 1;
		}
	}
	public static void printCart() {
		if(Discount == 1) {
			System.out.println("Total Price: " + totalCostofCart);
		}
		else {
			double ReducePrice = totalCostofCart*Discount;
			double Savings = totalCostofCart * (1-Discount);
			ReducePrice = (double)Math.round(ReducePrice*100)/100;
			Savings = (double)Math.round(Savings*100)/100;
			System.out.println("Your Final Price Is " + ReducePrice);
			System.out.println("You Saved " + Savings);
		}

	}

}

