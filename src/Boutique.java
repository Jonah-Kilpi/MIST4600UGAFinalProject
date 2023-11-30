import java.util.HashSet;
import java.util.ArrayList;

public class Boutique {
    private HashSet<Product> products;
    private ArrayList<FeaturedProduct> featuredProducts;
    private Supplier[] suppliers;
    private ArrayList<User> users = new ArrayList<User>();


    public Boutique() {
        products = new HashSet<>();
        featuredProducts = new ArrayList<>();
        users = new ArrayList<>();
        initializeSuppliers();
        initializeProducts();
        initializeUsers();
        addProductsToCheckout();
    }

    private void initializeSuppliers() {
        suppliers = new Supplier[] {
                new Supplier("Flirt", "Georgia", "404-982-7654"),
                new Supplier("Beauty Babes", "Florida", "901-879-0342"),
                new Supplier("Party Girl Prom", "Alabama", "860-123-6754")
        };
    }

    private void initializeProducts() {
        products.add(new Product("Don't Tell Mom", "Flirt", 799.99));
        products.add(new Product("Walk It Like You Talk It", "Beauty Babes", 550.99));
        products.add(new Product("Spicy and Sexy", "Party Girl Prom", 699.99));
        Checkout.setAllProducts(products);
    }

    public void initializeUsers() {
        users.add(new User("Alice", "password123", "alice@example.com", true));
        users.add(new User("Bob", "password456", "bob@example.com", false));
        users.add(new User("Charlie", "password789", "charlie@example.com", true));
        users.add(new User("Diana", "password321", "diana@example.com", false));
        users.add(new User("Ethan", "password654", "ethan@example.com", true));
    }

    public void addFeaturedProduct(String productName) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(productName)) {
                featuredProducts.add(new FeaturedProduct(product.getName(), product.getSupplier(), product.getPrice()));
                
                break;
            }
        }
    }

    public HashSet<Product> getProducts() {
        return products;
    }

    public ArrayList<FeaturedProduct> getFeaturedProducts() {
        return featuredProducts;
    }

    public Supplier[] getSuppliers() {
        return suppliers;
    }

    public ArrayList<User> getUsers() {
        return users;
    }
    private void addProductsToCheckout() {
        for (Product product : products) {
            Checkout.Selections(product.getName(), product.getPrice());
        }
    }

        }
	
    
    
    
