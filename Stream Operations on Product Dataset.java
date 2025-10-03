import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

class Product {
    String name;
    double price;
    String category;

    Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    @Override
    public String toString() {
        return name + " (" + category + ") - " + price;
    }
}

public class ProductStreamOps {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", 75000, "Electronics"),
            new Product("Phone", 50000, "Electronics"),
            new Product("TV", 60000, "Electronics"),
            new Product("Shoes", 3000, "Fashion"),
            new Product("Jacket", 5000, "Fashion"),
            new Product("Book", 800, "Stationery"),
            new Product("Notebook", 200, "Stationery")
        );

        Map<String, List<Product>> groupedByCategory =
            products.stream().collect(groupingBy(p -> p.category));
        System.out.println("\nProducts Grouped by Category:");
        groupedByCategory.forEach((cat, list) -> {
            System.out.println(cat + " -> " + list);
        });

        Map<String, Optional<Product>> maxPriceByCategory =
            products.stream().collect(groupingBy(
                p -> p.category,
                maxBy(Comparator.comparingDouble(p -> p.price))
            ));
        System.out.println("\nMost Expensive Product in Each Category:");
        maxPriceByCategory.forEach((cat, prod) ->
            System.out.println(cat + " -> " + prod.get()));

        double avgPrice = products.stream()
            .collect(averagingDouble(p -> p.price));
        System.out.printf("\nAverage Price of All Products: %.2f\n", avgPrice);
    }
}
