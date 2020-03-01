import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Receiver Object
 */
public class KeyValueStore {
    ConcurrentHashMap<String, String> dataStore;
    Stack<Transaction> transactions;
    boolean inCommit;
    

    public KeyValueStore() {
        dataStore = new ConcurrentHashMap<>();
        this.transactions = new Stack<>();
        this.inCommit = false;
    }

    public void unset(String key) {
        if (!inCommit && transactions.size() > 0) {
            transactions.peek().add(new Unset(this, key));
            return;
        }
        dataStore.remove(key);
    }

    public void set(String key, String value) {
        if (!inCommit && transactions.size() > 0) {
            transactions.peek().add(new Set(this, key, value));
            return;
        }

        dataStore.put(key, value);
    }

    public String get(String key) {
        if (!inCommit && transactions.size() > 0) {
            transactions.peek().add(new Get(this, key));
            return null;
        }

        return dataStore.getOrDefault(key, "NULL");
    }

    public Boolean exists(String key) {
        if (!inCommit && transactions.size() > 0) {
            transactions.peek().add(new Exists(this, key)); 
            return null;
        }
    
        return dataStore.containsKey(key);
    }

    public void begin() {
        transactions.add(new Transaction());
    }

    public void commit() {
        if (!transactions.isEmpty()) {
            this.inCommit = true;
            transactions.pop().commit();
            this.inCommit = false;

        }   
    }

}