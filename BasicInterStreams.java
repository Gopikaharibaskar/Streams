package Example;

import java.util.List;
import java.util.stream.Collectors;

public class BasicInterStreams {
    public static void main(String[] args) {
        List<String> cities = List.of("Chennai", "Mumbai", "Delhi", "Bangalore", "Kolkata");

        System.out.println("Cities Starting with 'C':");
        cities.stream()
              .filter(city -> city.startsWith("C")) 
              .forEach(System.out::println); 

        System.out.println("\nCities in Alphabetical Order:");
        cities.stream()
              .sorted() 
              .forEach(System.out::println);

        List<String> uppercaseCities = cities.stream()
                                             .map(String::toUpperCase) 
                                             .collect(Collectors.toList());
        System.out.println("\nCities in Uppercase:");
        System.out.println(uppercaseCities);
    }
}
