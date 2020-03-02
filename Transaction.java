import java.util.LinkedList;
/**
 * Invoker Object
 */
public class Transaction {
    private LinkedList<Operation> commands;

    public Transaction() {
        commands = new LinkedList<>();
    }

    public void add(Operation command) {
        commands.add(command);
    }

    public void commit() {
        commands.forEach(Operation::execute);
        commands.clear();
    }
} 