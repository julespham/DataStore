public class KeyValueStoreTest {
    public static void test() {
        KeyValueStore store = new KeyValueStore();
        store.set("x", "1");
        String x = store.get("x");
        assert(x == "1");
    }

    public static void transactionTest() {
        KeyValueStore store = new KeyValueStore();
        store.set("x", "1");

        store.begin();
        store.set("x", "2");
        store.begin();
        store.set("x", "3");
        store.commit();
        assert(store.get("x") == "3");
        store.commit();

        assert(store.get("x") == "2");
    }

    public static void main(String[] args) {
        test();
        transactionTest();
    }
}
