package animals;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String animalsType = scanner.nextLine();

        while (!animalsType.equals("Beast!")) {
            String[] inputData = scanner.nextLine().split("\\s+");

            try {
                String name = inputData[0];
                int age = Integer.parseInt(inputData[1]);
                String gender = inputData[2];

                switch (animalsType) {
                    case "Cat":
                        Cat cat = new Cat(name, age, gender);
                        System.out.println(cat);
                        break;
                    case "TomCat":
                        Tomcat tomCat = new Tomcat(name, age);
                        System.out.println(tomCat);
                        break;
                    case "Kittens":
                        Kitten kitten = new Kitten(name, age);
                        System.out.println(kitten);
                        break;
                    case "Dog":
                        Dog dog = new Dog(name, age, gender);
                        System.out.println(dog);
                        break;
                    case "Frog":
                        Frog frog = new Frog(name, age, gender);
                        System.out.println(frog);
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            animalsType = scanner.nextLine();
        }
    }
}
