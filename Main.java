import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        KeyValueStore keyValueStore = new KeyValueStore();
        KeyValueStoreTest keyValueStoreTest = new KeyValueStoreTest();
        keyValueStoreTest.test();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Hello, welcome to the super simple key-value store. \n" + 
            "Please enter one of the following commands:\n" + 
            CommandArgument.values().toString() +
            "Once done, enter END \n");
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
        // switch(command) { 
        //     case SET -> keyValueStore.setKey(command[1], command[2]);
        //     case UNSET -> keyValueStore.unsetKey(command[1]); 
        //     case GET -> keyValueStore.getValue(command[1]); 
        //     case EXISTS -> keyValueStore.exists(command[1]);
        //     case END -> System.exit(0);
        // }    
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
            case END -> {
                if (command.length != 1) {
                    throw new IllegalArgumentException("Wrong number of arguments");
                }
            }
        }
    }

}