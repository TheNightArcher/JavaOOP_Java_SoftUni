package shopingSpree_03;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Person> customers = new LinkedHashMap<>();
        Map<String, Product> productsInCart = new HashMap<>();

        String[] peoples = scanner.nextLine().split(";");
        for (String customer : peoples) {
            String[] customerData = customer.split("=");

            String name = customerData[0];
            double money = Double.parseDouble(customerData[1]);

            try {
                Person person = new Person(name, money);
                customers.put(name, person);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        String[] products = scanner.nextLine().split(";");
        for (String productInShop : products) {
            String[] currentProducts = productInShop.split("=");

            String name = currentProducts[0];
            double cost = Double.parseDouble(currentProducts[1]);

            try {
                Product product = new Product(name, cost);
                productsInCart.put(name, product);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        String input = scanner.nextLine();

        while (!input.equals("END")){
            String[] inputData = input.split("\\s+");

            String personName = inputData[0];
            String productName = inputData[1];

            Person person = customers.get(personName);
            Product product = productsInCart.get(productName);
            try{
                person.buyProduct(product);
                System.out.printf("%s bought %s%n",person.getName(),product.getName());
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }

            input = scanner.nextLine();
        }
        for (Person client : customers.values()) {
            System.out.printf("%s - ",client.getName());
            if (client.getProducts().isEmpty()){
                System.out.println("Nothing bought");
            }else {
                System.out.println(client.getProducts().stream().map(Product::getName).collect(Collectors.joining(", ")));
            }
        }
    }
}
