package cardsWithPower_03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        RankPower rank = RankPower.valueOf(scanner.nextLine());
        SuitPower suit = SuitPower.valueOf(scanner.nextLine());

        Card card = new Card(suit,rank);

               System.out.printf("Card name: %s of %s; Card power: %d",rank.name(),suit.name(),card.getPower());
    }
}
