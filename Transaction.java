import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Invoker Object
 */
public class Transaction {
    ConcurrentLinkedQueue<Operation> commands;
    boolean inTransaction;
    public Transaction() {
        commands = new ConcurrentLinkedQueue<>();
    }

    public void begin(Operation command) {
        this.inTransaction = true;
        commands.add(command);
    }

    public void commit() {
        commands.forEach(Operation::execute);
    }
}