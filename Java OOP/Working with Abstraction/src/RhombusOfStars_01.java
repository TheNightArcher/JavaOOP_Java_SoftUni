import java.util.Scanner;

public class RhombusOfStars_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.nextLine());

        printTop(input);

        printMiddle(input);

        printBottom(input);

    }

    public static void printToString(int count, String output) {
        for (int i = 0; i < count; i++) {
            System.out.print(output);
        }
    }

    public static void printTop(int input) {
        for (int row = 1; row < input; row++) {

            printToString(input - row, " ");
            printToString(row, "* ");

            System.out.println();
        }
    }

    public static void printMiddle(int input) {
        printToString(input, "* ");

        System.out.println();
    }

    public static void printBottom(int input) {
        for (int i = 1; i < input; i++) {

            printToString(i, " ");
            printToString(input - i, "* ");

            System.out.println();
        }
    }
}
