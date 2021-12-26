package cardRank_02;

public class Main {
    public static void main(String[] args) {

        System.out.println("Card Ranks: ");

        for (RankCard card : RankCard.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s%n",card.ordinal(),card.name());
        }
    }
}
