import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Receiver Object
 */
public class KeyValueStore {
    ConcurrentHashMap<String, String> dataStore;
    List<Transaction> transactions;

    public KeyValueStore() {
        dataStore = new ConcurrentHashMap<>();
        this.transactions = new Vector<>();
    }

    public void unset(String key) {
        dataStore.remove(key);
    }

    public void set(String key, String value) {
        dataStore.put(key, value);  
    }

    public String get(String key) {
        return dataStore.getOrDefault(key, null);
    }

    public boolean exists(String key) {
        return dataStore.containsKey(key);
    }

    public String end() {
        return "chow";
    }

    public void begin() {
        Transaction transaction= new Transaction();
        transactions.add(transaction);

        transaction.begin(() -> set("x", "1"));
        transaction.begin(() -> get("x"));
    }

    public void commit() {
        // Transaction transaction = transactions.

    }

}