import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        KeyValueStore keyValueStore = new KeyValueStore();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Hello, welcome to the super simple key-value store. \n" + 
            "Please enter one of the following commands:\n" + 
            java.util.Arrays.asList(CommandArgument.values()) +
            " Once done, enter END \n");
            String str;
            while ((str = reader.readLine()) != null) {
                executeCommand(keyValueStore,  str.split(" "));
            }
        } catch (IOException io) {
                io.printStackTrace();
        }  
    }

    public enum CommandArgument {
        SET, UNSET, GET, EXISTS, END, BEGIN, COMMIT
    }

    public static void executeCommand(KeyValueStore keyValueStore, String[] command ) {
        validateCommand(command);
        CommandArgument commandArgument = CommandArgument.valueOf(command[0]);
        switch(commandArgument) { 
            case SET -> keyValueStore.set(command[1], command[2]);
            case UNSET -> keyValueStore.unset(command[1]); 
            case GET -> {
               String value = keyValueStore.get(command[1]);
               if (value != null) {
                    System.out.println(valu54e);
               }
            } 
            case EXISTS -> {
                Boolean value = keyValueStore.exists(command[1]);
                if (value != null) {
                    System.out.println(value);
                }
            }
            case BEGIN -> keyValueStore.begin();
            case COMMIT -> keyValueStore.commit();
            case END -> System.exit(0);
        }    
    }

    public static void validateCommand(String... command) {
        CommandArgument commandArgument = CommandArgument.valueOf(command[0]);
        switch (commandArgument) {
            case UNSET, GET, EXISTS -> {
                if (command.length != 2) {
                    throw new IllegalArgumentException("Wrong number of arguments");
                }
            }
            case SET -> {
                if (command.length != 3) {
                    throw new IllegalArgumentException("Wrong number of arguments");
                }
            }
            case BEGIN, COMMIT, END -> {
                if (command.length != 1) {
                    throw new IllegalArgumentException("Wrong number of arguments");
                }
            }
        }
    }

}