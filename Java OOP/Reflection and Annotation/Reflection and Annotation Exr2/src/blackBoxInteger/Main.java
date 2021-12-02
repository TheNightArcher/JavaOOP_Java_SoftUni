package blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {

        Class<BlackBoxInt> clazz = BlackBoxInt.class;
        Constructor<BlackBoxInt> declaredConstructors = clazz.getDeclaredConstructor();

        declaredConstructors.setAccessible(true);

        BlackBoxInt blackBoxInt = declaredConstructors.newInstance();

        Field innerValue = clazz.getDeclaredField("innerValue");
        innerValue.setAccessible(true);


        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (!input.equals("END")){
            String[] inputDate = input.split("_");
            String methodType = inputDate[0];
            int value = Integer.parseInt(inputDate[1]);

            Method declaredMethod = clazz.getDeclaredMethod(methodType, int.class);

            declaredMethod.setAccessible(true);
            declaredMethod.invoke(blackBoxInt,value);

            System.out.println(innerValue.get(blackBoxInt));

            input = scanner.nextLine();
        }
    }
}
