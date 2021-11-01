package jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimension = getCoordinates(scanner.nextLine());
        int row = dimension[0];
        int col = dimension[1];

        Filed filed = new Filed(row,col);
        Galaxy galaxy = new Galaxy(filed);

        String command = scanner.nextLine();
        long collectedStars = 0;
        while (!command.equals("Let the Force be with you")) {
            int[] jediPosition = getCoordinates(command);
            int[] evilPosition = getCoordinates(scanner.nextLine());

            int evilRow = evilPosition[0];
            int evilCol = evilPosition[1];

            galaxy.moveEvil(evilRow,evilCol);

            int jediRow = jediPosition[0];
            int jediCol = jediPosition[1];

          collectedStars = galaxy.moveJedi(jediRow,jediCol);

            command = scanner.nextLine();
        }
        System.out.println(collectedStars);
    }

    private static int[] getCoordinates(String s) {
        return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
    }


}
