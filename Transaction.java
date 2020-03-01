import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Invoker Object
 */
public class Transaction {
    private ConcurrentLinkedQueue<Operation> commands;
    boolean inTransaction;

    public Transaction() {
        commands = new ConcurrentLinkedQueue<>();
    }

    // TO DO: Change method signature
    public void begin(Operation command) {
        this.inTransaction = true;
        commands.add(command);
    }

    public void commit() {
        commands.forEach(Operation::execute);
    }
} 