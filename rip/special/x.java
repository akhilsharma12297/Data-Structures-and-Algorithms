package rip.special;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class LimitedTransactionDataStore {
    private Map<String, String> dataStore;
    private Stack<Map<String, String>> transactionStack;

    public LimitedTransactionDataStore() {
        this.dataStore = new HashMap<>();
        this.transactionStack = new Stack<>();
    }

    // Part 1
    public String create(String key, String value) {
        if (dataStore.containsKey(key)) {
            update(key, value);
        } else {
            dataStore.put(key, value);
        }
        return value;
    }

    public String read(String key) {
        return dataStore.getOrDefault(key, "No Key Associated");
    }

    public String update(String key, String value) {
        if (dataStore.containsKey(key)) {
            dataStore.put(key, value);
            return value;
        } else {
            return "No Key Associated";
        }
    }

    public String delete(String key) {
        if (dataStore.containsKey(key)) {
            dataStore.remove(key);
            return "Delete Success";
        } else {
            return "No Key Associated";
        }
    }

    // Part 2
    public void begin() {
        transactionStack.push(new HashMap<>(dataStore));
    }

    public void commit() {
        if (!transactionStack.isEmpty()) {
            transactionStack.clear();
        }
    }

    public void rollback() {
        if (!transactionStack.isEmpty()) {
            dataStore = transactionStack.pop();
        }
    }

    // Part 3
    public void commit(int t) {
        while (t > 0 && !transactionStack.isEmpty()) {
            t--;
            transactionStack.pop();
        }
    }

    public void rollback(int t) {
        while (t > 0 && !transactionStack.isEmpty()) {
            transactionStack.pop();
            t--;
        }
        if (!transactionStack.isEmpty()) {
            dataStore = new HashMap<>(transactionStack.peek());
        }
    }

    public static void main(String[] args) {
        LimitedTransactionDataStore dataStore = new LimitedTransactionDataStore();

        /*
        // Example 1
        dataStore.create("key1", "val1");
        dataStore.create("key2", "val2");
        dataStore.create("key3", "val3");
        System.out.println(dataStore.read("key1"));  // val1
        System.out.println(dataStore.read("key2"));  // val2
        System.out.println(dataStore.read("key3"));  // val3

        dataStore.begin();
        dataStore.create("key3", "val8");
        System.out.println(dataStore.read("key3"));  // val8
        dataStore.create("key5", "val5");
        System.out.println(dataStore.read("key5"));  // val5
        dataStore.update("key5", "val7");
        System.out.println(dataStore.read("key5"));  // val7
        dataStore.update("key2", "val7");
        System.out.println(dataStore.read("key2"));  // val7
        dataStore.update("key2", "val8");
        System.out.println(dataStore.read("key2"));  // val8
        dataStore.delete("key1");
        System.out.println(dataStore.read("key1"));  // No Key Associated
        dataStore.commit();
        System.out.println(dataStore.read("key1"));  // val8
        System.out.println(dataStore.read("key2"));  // No Key Associated
        System.out.println(dataStore.read("key3"));  // val8
        System.out.println(dataStore.read("key5"));  // val7

        // Example 2
        dataStore.create("key1", "val1");
        dataStore.create("key2", "val2");
        dataStore.create("key3", "val3");
        System.out.println(dataStore.read("key1"));  // val1
        System.out.println(dataStore.read("key2"));  // val2
        System.out.println(dataStore.read("key3"));  // val3

        dataStore.begin();
        dataStore.create("key3", "val8");
        System.out.println(dataStore.read("key3"));  // val8
        dataStore.create("key5", "val5");
        System.out.println(dataStore.read("key5"));  // val5
        dataStore.update("key5", "val7");
        System.out.println(dataStore.read("key5"));  // val7
        dataStore.update("key2", "val7");
        System.out.println(dataStore.read("key2"));  // val7
        dataStore.update("key2", "val8");
        System.out.println(dataStore.read("key2"));  // val8
        dataStore.delete("key1");
        System.out.println(dataStore.read("key1"));  // No Key Associated
        dataStore.rollback(2);
        System.out.println(dataStore.read("key1"));  // val1
        System.out.println(dataStore.read("key2"));  // val2
        System.out.println(dataStore.read("key3"));  // val3
        System.out.println(dataStore.read("key5"));  // val7
         */

        dataStore.create("key1", "OGval1");
        dataStore.create("key2", "OGval2");
        dataStore.create("key3", "OGval3");

        System.out.println(dataStore.read("key1"));  // val1
        System.out.println(dataStore.read("key2"));  // val2
        System.out.println(dataStore.read("key3"));  // val3

        dataStore.begin();

        dataStore.create("key1", "TEMPval1");
        dataStore.create("key2", "TEMPval2");
        dataStore.create("key3", "TEMPval3");

        System.out.println(dataStore.read("key1"));  // TEMPval1
        System.out.println(dataStore.read("key2"));  // TEMPval2
        System.out.println(dataStore.read("key3"));  // TEMPval3

        dataStore.rollback(1);

        System.out.println(dataStore.read("key1"));  // TEMPval1
        System.out.println(dataStore.read("key2"));  // TEMPval2
        System.out.println(dataStore.read("key3"));  // OGval3

        dataStore.commit();

        System.out.println(dataStore.read("key1"));  // TEMPval1
        System.out.println(dataStore.read("key2"));  // TEMPval2
        System.out.println(dataStore.read("key3"));  // OGval3


    }
}
