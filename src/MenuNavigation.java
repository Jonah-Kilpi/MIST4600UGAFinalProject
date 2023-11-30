
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.HashSet;
public class MenuNavigation {
    private static boolean isMember = false;
    public static boolean menuOptions(Scanner scnr, Boutique boutique) {
        boolean continueMenu = true;
        while (continueMenu) {
            int choice = scnr.nextInt();
            scnr.nextLine();
            switch (choice) {
                case 1:
                    customerView(scnr, boutique);
                    break;
                case 2:
                    managerView(scnr, boutique);
                    break;
                case 3:
                    System.out.println("Thank you for visiting the Boutique!");
                    return false;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        return true;}

    public static void customerView(Scanner scnr, Boutique boutique) {
        System.out.println("Would You Like To Become A Member? (Y/N)");
        String memberResponse = scnr.nextLine().trim().toUpperCase();
        if(memberResponse.equals("Y")) {
            isMember = true;
        }
        System.out.println("\nFeatured Product of the Day");
        for (FeaturedProduct featuredProduct : boutique.getFeaturedProducts()) {
            System.out.println("Product: " + featuredProduct.getName() +
                    ", Supplier: " + featuredProduct.getSupplier() +
                    ", Price: $" + featuredProduct.getPrice() +
                    ", Featured: " + featuredProduct.isFeatured());
        }
        System.out.println("\nProducts of the Day:");
        ArrayList<FeaturedProduct> checker = boutique.getFeaturedProducts();
        for (Product product : boutique.getProducts()) {
            if (!checker.contains(product)) {
                System.out.println("Product Name: " + product.getName() +
                        ", Supplier: " + product.getSupplier() +
                        ", Price: $" + product.getPrice());
            }
        }
        boolean shopping = true;
        while (shopping) {
            System.out.println("What would you like to add to your cart?");
            String itemToAdd = scnr.nextLine();
            if (!itemToAdd.equalsIgnoreCase("done")) {
                Product product = Checkout.getProductByName(itemToAdd);
                if (product != null) {
                    Checkout.addItemsToCart(product);
                    System.out.println("Added \"" + product.getName() + "\" to your cart.");
                } else {
                    System.out.println("Item \"" + itemToAdd + "\" is not a valid item.");
                }
                System.out.println("Would you like to add another item? (Y/N)");
                String response = scnr.nextLine();
                if (response.equalsIgnoreCase("N")) {
                    shopping = false;
                }
            } else {
                shopping = false;
            }
        }
        Checkout.CalculateCart();
        Checkout.DiscountCheck(isMember);
        Checkout.printCart();
    }
    public static void managerView(Scanner scnr, Boutique boutique) {
        final String password = "Boutique";
        System.out.println("Please enter the manager password:");
        String inputPassword = scnr.nextLine();
        if (!inputPassword.equals(password)) {
            System.out.println("Incorrect password. Returning to the main menu.");
            return;
        }
        Manager manager = new Manager(boutique);
        manager.managerMenu(scnr);
    }
}