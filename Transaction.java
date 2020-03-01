import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Invoker Object
 */
public class Transaction {
    private ConcurrentLinkedQueue<Operation> commands;

    public Transaction() {
        commands = new ConcurrentLinkedQueue<>();
    }

    public void add(Operation command) {
        commands.add(command);
    }

    public void commit() {
        commands.forEach(Operation::execute);
    }
} 