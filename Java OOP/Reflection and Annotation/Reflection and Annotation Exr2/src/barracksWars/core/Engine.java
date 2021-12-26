package barracksWars.core;

import barracksWars.core.commands.Command;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.Runnable;
import barracksWars.interfaces.UnitFactory;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Engine implements Runnable {

    private static String COMMANDS_PATH_NAME = "barracksWars.core.commands.";
    private static String EXECUTE_PATH_NAME = "execute";


    private Repository repository;
    private UnitFactory unitFactory;

    public Engine(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        while (true) {
            try {
                String input = reader.readLine();
                String[] data = input.split("\\s+");
                String commandName = data[0];
                String result = interpretCommand(data, commandName);
                if (result.equals("fight")) {
                    break;
                }
                System.out.println(result);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String interpretCommand(String[] data, String commandName) {
        String result = "";
        String commandClassName = commandName.substring(0, 1).toUpperCase() + commandName.substring(1);
        try {
            Class clazz = Class.forName(COMMANDS_PATH_NAME + commandClassName);
            Constructor<Command> declaredConstructor = clazz.getDeclaredConstructor(String[].class, Repository.class, UnitFactory.class);
            Command commandInstance = declaredConstructor.newInstance(data, this.repository, this.unitFactory);
            Method executeMethod = clazz.getDeclaredMethod(EXECUTE_PATH_NAME);
            try {
                result = (String) executeMethod.invoke(commandInstance);
            }catch (InvocationTargetException e){
                System.out.println(e.getCause().getMessage());
            }
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException | IllegalArgumentException e) {
            e.printStackTrace();
        }
        return result;
    }

}
