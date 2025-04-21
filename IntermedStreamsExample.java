package Example;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class IntermedStreamsExample {
    public static class Product {
        private String name;
        private double price;
        private int quantity;

        public Product(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public int getQuantity() {
            return quantity;
        }

        @Override
        public String toString() {
            return "Product{name='" + name + "', price=" + price + ", quantity=" + quantity + "}";
        }
    }

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", 75000, 5));
        products.add(new Product("Smartphone", 25000, 10));
        products.add(new Product("Tablet", 35000, 8));
        products.add(new Product("Monitor", 15000, 12));

        System.out.println("Products with Price Above ₹30,000:");
        products.stream()
                .filter(product -> product.getPrice() > 30000)
                .forEach(System.out::println);

        System.out.println("\nProducts Sorted by Price:");
        products.stream()
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .forEach(System.out::println);

        double totalCost = products.stream()
                                   .mapToDouble(product -> product.getPrice() * product.getQuantity())
                                   .sum();
        System.out.printf("\nTotal Cost of All Products: ₹%.2f%n", totalCost);
    }
}
