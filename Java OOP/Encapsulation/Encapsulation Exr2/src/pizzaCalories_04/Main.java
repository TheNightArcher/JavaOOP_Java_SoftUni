package pizzaCalories_04;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] pizzaParts = scanner.nextLine().split("\\s+");

        Map<String,Pizza> pizzaMap = new HashMap<>();

        String pizzaName = pizzaParts[1];
        int numberOfTopping = Integer.parseInt(pizzaParts[2]);

        try {
            Pizza pizza = new Pizza(pizzaName,numberOfTopping);
            pizzaMap.put(pizzaName,pizza);

        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return;
        }

        String[] doughParts = scanner.nextLine().split("\\s+");

        String doughType = doughParts[1];
        String baking = doughParts[2];
        double weigh = Double.parseDouble(doughParts[3]);

        try{
            Dough dough = new Dough(doughType,baking,weigh);
            pizzaMap.get(pizzaName).setDough(dough);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return;
        }

        String input = scanner.nextLine();

        while (!input.equals("END")){
            String[] inputParts = input.split("\\s+");

            String toppingType = inputParts[1];
            double toppingWeigh = Double.parseDouble(inputParts[2]);

            try {
                Topping topping = new Topping(toppingType,toppingWeigh);
                pizzaMap.get(pizzaName).addTopping(topping);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                return;
            }
            input = scanner.nextLine();
        }

        for (Pizza pizza : pizzaMap.values()) {
            System.out.printf("%s - %.2f",pizza.getName(),pizza.getOverallCalories());
        }
    }
}
