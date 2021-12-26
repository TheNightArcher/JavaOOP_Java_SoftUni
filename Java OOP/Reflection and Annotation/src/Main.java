import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class<Reflection> reflection = Reflection.class;

        System.out.println(reflection.getSimpleName());
        System.out.println(reflection.getSuperclass().getSimpleName());



        Arrays.stream(reflection.getInterfaces())
                .map(Class::getSimpleName)
                .forEach(System.out::println);


        Reflection reflection1 = reflection.getDeclaredConstructor().newInstance();
        System.out.println(reflection1);



        //Second Task I just put them all in once!
        Method[] declaredMethods = Arrays.stream(reflection.getDeclaredMethods())
                .filter(m -> !m.getName().equals("toString"))
                .toArray(Method[]::new);

        Arrays.stream(declaredMethods)
                .filter(m -> m.getReturnType() != void.class)
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m -> System.out.printf("%s will return class %s%n",m.getName(),m.getReturnType().getSimpleName()));


        Arrays.stream(declaredMethods)
                .filter(m -> m.getReturnType() == void.class)
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m -> System.out.printf("%s and will set field of class %s%n",m.getName(),m.getParameterTypes()[0].getSimpleName()));


        System.out.println();

        


        // Third Task!
        Arrays.stream(reflection.getDeclaredFields())
                .filter(f -> !Modifier.isPrivate(f.getModifiers()))
                .sorted(Comparator.comparing(Field::getName))
                .forEach(f -> System.out.printf("%s must be private!%n",f.getName()));


        Arrays.stream(declaredMethods)
                .filter(m -> !Modifier.isPublic(m.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m -> System.out.printf("%s have to be public!%n",m.getName()));

        Arrays.stream(declaredMethods)
                .filter(m -> !Modifier.isPrivate(m.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m -> System.out.printf("%s have to be private!%n",m.getName()));
    }
}
