package rip.ultimate;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class DataStore {

    class Transaction {

        String key;
        String value;

        Transaction(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    HashMap<String, String> store;

    Stack<LinkedList<Transaction>> transactionLogs;

    boolean transactionActive;

    DataStore() {
        this.store = new HashMap<>();
        this.transactionLogs = new Stack<>();
        this.transactionActive = false;
    }

    public String read(String k) {
        if (store.containsKey(k)) {
            return store.get(k);
        }
        return "NO VALUE ASSOCIATED WITH THE KEY.";
    }

    public String create(String k, String v) {
        if (store.containsKey(k)) {
            return update(k, v);
        } else {
            storeTransactions(k, null);
            store.put(k, v);
            return v;
        }
    }

    public String update(String k, String v) {
        storeTransactions(k, store.get(k));
        store.put(k, v);
        return v;
    }

    public String delete(String k) {
        if (store.containsKey(k)) {
            storeTransactions(k, store.get(k));
            store.remove(k);
            return "DELETE SUCCESSFUL.";
        }
        return "KEY DOESN'T EXIST.";
    }

    public void storeTransactions(String key, String value) {
        if (transactionActive) {
            transactionLogs.peek().addFirst(new Transaction(key, value));
        }
    }

    public void begin() {
        this.transactionActive = true;
        this.transactionLogs.push(new LinkedList<>());
        System.out.println("TRANSACTION MODE STARTED.");
    }

    public void commit() {

        if (!transactionActive) {
            return;
        }

        transactionActive = false;

        transactionLogs.pop();

        System.out.println("TRANSACTION MODE COMMITTED.");
    }

    public void rollback() {

        commit(0);

        System.out.println("TRANSACTION MODE ROLLBACK.");
    }

    public void commit(int t) {

        if (!transactionActive) {
            return;
        }

        transactionActive = false;

        while (t-- > 0) {
            transactionLogs.peek().removeLast();
        }

        while (!transactionLogs.peek().isEmpty()) {
            Transaction tHistory = transactionLogs.peek().removeFirst();

            if (tHistory.value == null) {
                store.remove(tHistory.key);
            } else {
                store.put(tHistory.key, tHistory.value);
            }
        }

        transactionLogs.pop();
    }

    public void rollback(int t) {

        if (!transactionActive) {
            return;
        }

        transactionActive = false;

        while (t-- > 0) {
            transactionLogs.peek().removeFirst();
        }

        while (!transactionLogs.peek().isEmpty()) {
            Transaction tHistory = transactionLogs.peek().removeLast();

            if (tHistory.value == null) {
                store.remove(tHistory.key);
            } else {
                store.put(tHistory.key, tHistory.value);
            }
        }

        transactionLogs.pop();


    }

    public static void main(String[] args) {
        DataStore ds = new DataStore();

//        System.out.println("------------------------------------------------");
//        System.out.println("-------------------- PART 1 --------------------");
//        System.out.println(ds.read("key1"));
//
//        System.out.println(ds.create("key1", "value1"));
//
//        System.out.println(ds.update("key1", "value2"));
//
//        System.out.println(ds.read("key1"));
//
//        System.out.println(ds.delete("key1"));
//
//        System.out.println(ds.read("key1"));

        System.out.println("------------------------------------------------");
        System.out.println("-------------------- PART 2 --------------------");

        System.out.println(ds.create("key1", "value1"));
        System.out.println(ds.create("key2", "value2"));
        System.out.println(ds.create("key3", "value3"));

        System.out.println(ds.read("key1"));
        System.out.println(ds.read("key2"));
        System.out.println(ds.read("key3"));

        ds.begin();

        ds.create("key3", "value8");
        System.out.println(ds.read("key3"));
        ds.create("key5", "value5");
        System.out.println(ds.read("key5"));
        System.out.println(ds.update("key5", "value7"));
        System.out.println(ds.read("key5"));
        System.out.println(ds.update("key2", "value7"));
        System.out.println(ds.read("key2"));
        System.out.println(ds.update("key2", "value8"));
        System.out.println(ds.read("key2"));
        System.out.println(ds.delete("key1"));
        System.out.println(ds.read("key1"));

        ds.rollback(1);

        System.out.println("------------------------------------------------");

        System.out.println(ds.read("key1"));
        System.out.println(ds.read("key2"));
        System.out.println(ds.read("key3"));
        System.out.println(ds.read("key5"));


        System.out.println("------------------------------------------------");


    }


}
