package StreamRecordExample;

import java.util.*;
import java.util.stream.Collectors;

public class StreamRecordExample {

	public record Product(String name, double price, int quantity) {}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of products:");
        int numberOfProducts = Integer.parseInt(scanner.nextLine());

        List<Product> products = new ArrayList<>();
        System.out.println("Enter product details (name, price, quantity):");
        for (int i = 0; i < numberOfProducts; i++) {
            String[] input = scanner.nextLine().split(","); 
            products.add(new Product(input[0].trim(), Double.parseDouble(input[1].trim()), Integer.parseInt(input[2].trim())));
        }

        System.out.println("Enter the minimum price to filter:");
        double minPrice = Double.parseDouble(scanner.nextLine());
        List<Product> expensiveProducts = products.stream()
                .filter(product -> product.price() >= minPrice)
                .collect(Collectors.toList());
        System.out.println("\nProducts with price >= " + minPrice + ":");
        expensiveProducts.forEach(product -> System.out.println(product.name() + " (Price: " + product.price() + ")"));

        List<Product> sortedByName = products.stream()
                .sorted(Comparator.comparing(Product::name))
                .collect(Collectors.toList());
        System.out.println("\nProducts sorted by name:");
        sortedByName.forEach(product -> System.out.println(product.name() + " (Price: " + product.price() + ", Quantity: " + product.quantity() + ")"));

        double totalCost = products.stream()
                .mapToDouble(product -> product.price() * product.quantity())
                .sum();
        System.out.println("\nTotal cost of all products: " + totalCost);

        scanner.close();
    }
}

