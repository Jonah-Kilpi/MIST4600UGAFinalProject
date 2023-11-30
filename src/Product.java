import java.util.HashSet;
import java.util.Objects;
public class Product {
    private String name;
    private String supplier;
    private double price;

    public Product(String name, String supplier, double price) {
        this.name = name;
        this.supplier = supplier;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getSupplier() {
        return supplier;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
    	this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        boolean isEqual = false;
        if (this == o) {
            isEqual = true;
        }
        else if (o != null && getClass() == o.getClass()) {
            Product product = (Product) o;
            isEqual = Double.compare(product.price, price) == 0 && name.equals(product.name) && supplier.equals(product.supplier);
        }
        return isEqual;
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, supplier, price);
    }
}
