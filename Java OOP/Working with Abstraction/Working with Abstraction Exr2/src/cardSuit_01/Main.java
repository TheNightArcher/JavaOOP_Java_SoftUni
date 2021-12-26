package cardSuit_01;

public class Main {
    public static void main(String[] args) {


        System.out.println("Card Suits:");
        for (var cards : CardSuit_01.values()) {

            System.out.printf("Ordinal value: %d; Name value: %s%n",cards.ordinal(),cards.name());
        }
    }
}
