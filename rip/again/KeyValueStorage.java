package rip.again;


//https://leetcode.com/discuss/interview-question/3928848/Rippling-Phone-Screen-or-Sr-Software-Engineer-US-or-Rejected

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

//Design a Data Store to execute the following.
//
//        Part 1
//
//        Perform a READ, CREATE, UPDATE, DELETE functions
//
//        Create takes a String key and a String value - create("key", "val") - return the stored value. If it exists, call update the function. (Hi Reader, if this feels like an normal over-write, wait until Part 3)
//
//        Read takes a String key - read("key") – Returns the stored value, else error, or friendly message.
//
//        Update takes a String key and String value – update("key", "val") – returns the updated value, if it doesn’t exist, return and error or friendly message.
//
//        Delete takes a String key – delete("key") and deletes it from the store, else error, or friendly message
//
//        Example 1:
//
//        - k.read("key1") – returns "No Key associated"
//        - k.create("key1", "val1") – returns "val1"
//        - k.read("key1") – returns "val1"
//        - k.update("key1", "val2") – returns "val2"
//        - k.read("key1") – returns "val2"
//        - k.delete("key1") – returns "Delete Success"
//        - k.read("key1") – returns "No key associated"
//        Part 2
//
//        Enable transactions for your data store. A transaction starts with begin() and operations like READ, CREATE, UPDATE, DELETE can take place during this time. After these operation, the transaction is ended by either a commit() that commits everything permanently in the data store or rollback() that reverts everything that was performed during the transaction window. Notice that I highlighted the key-word everything.
//
//        Example 1:
//
//        - k.create("key1", "val1")
//        - k.create("key2", "val2")
//        - k.create("key3", "val3")
//        - k.read("key1") – returns "val1"
//        - k.read("key2") – returns "val2"
//        - k.read("key3") – returns "val3"
//        - k.begin() – this begins a transaction
//        - k.create("key3", "val8")
//        - k.read("key3") – returns val8
//        - k.create("key5", "val5")
//        - k.read("key5") – returns val5
//        - k.update("key5", "val7"
//        - k.read("key5") – returns val7
//        - k.update("key2", "val7"
//        - k.read("key2") – returns val7
//        - k.update("key2", "val8"
//        - k.read("key2") – returns val8
//        - k.delete("key1")
//        - k.read("key1") – No Key Associated
//        - k.commit() – this commits everything
//        After committing, you should still access the items in the data store with their update values.
//
//        - k.read("key1") – returns val8
//        - k.read("key2") – No Key Associated
//        - k.read("key3") – returns val8
//        Example 2: Disregard previous state of the Data Store
//
//        - k.create("key1", "val1")
//        - k.create("key2", "val2")
//        - create("key3", "val3")
//        - read("key1") – returns "val1"
//        - read("key2") – returns "val2"
//        - read("key3") – returns "val3"
//
//        - begin() – this begins a transaction
//        - create("key3", "val8")
//        - read("key3") – returns val8
//        - create("key5", "val5")
//        - read("key5") – returns val5
//        - update("key5", "val7"
//        - read("key5") – returns val7
//        - update("key2", "val7"
//        - read("key2") – returns val7
//        - update("key2", "val8"
//        - read("key2") – returns val8
//        - delete("key1")
//        - read("key1") – No Key Associated
//        - rollback() – this rolls back everything
//        - read("key1") – returns val1
//        - read("key2") – returns val2
//        - read("key3") – returns val3
//        - read("key5") – No Key Associated
//        Part 3
//
//        Make the transactions limited. In Part 2, commit() commits everything while rollback() rolls back everything. This part will ensure that you can only –
//
//        commit(t) - Commits only the first t transactions after begin.
//        rollback(t) – rolls back  only the last t transactions after begin.
//        For this part, Please note that only those operations that change the state of our data store are counted as transactions.
//
//        Example 1:
//
//        - create("key1", "val1")
//        - create("key2", "val2")
//        - create("key3", "val3")
//        - read("key1") – returns "val1"
//        - read("key2") – returns "val2"
//        - read("key3") – returns "val3"
//        - begin() – this begins a transaction
//        - create("key3", "val8")
//        - read("key3") – returns val8
//        - create("key5", "val5")
//        - read("key5") – returns val5
//        - update("key5", "val7"
//        - read("key5") – returns val7
//        - update("key2", "val7"
//        - read("key2") – returns val7
//        - update("key2", "val8"
//        - read("key2") – returns val8
//        - delete("key1")
//        - read("key1") – No Key Associated
//        - commit(2) – this commits only the first two transactions
//        - read("key1") – returns val1
//        - read("key2") – returns val2
//        - read("key3") – returns val8
//        - read("key5") - returns val5
//        Example 2:
//
//        - create("key1", "val1")
//        - create("key2", "val2")
//        - create("key3", "val3")
//        - read("key1") – returns "val1"
//        - read("key2") – returns "val2"
//        - read("key3") – returns "val3"
//        - begin() – this begins a transaction
//        - create("key3", "val8")
//        - read("key3") – returns val8
//        - create("key5", "val5")
//        - read("key5") – returns val5
//        - update("key5", "val7"
//        - read("key5") – returns val7
//        - update("key2", "val7"
//        - read("key2") – returns val7
//        - update("key2", "val8"
//        - read("key2") – returns val8
//        - delete("key1")
//        - read("key1") – No Key Associated
//        - rollback(2) – this rolls back only the last two transactions
//        - read("key1") – returns val1
//        - read("key2") – returns val7
//        - read("key3") – returns val8
//        - read("key5") - returns val7


public class KeyValueStorage {

    class Transaction {
        String key;
        String oldValue;

        Transaction(String key, String oldValue) {
            this.key = key;
            this.oldValue = oldValue;
        }
    }

    HashMap<String, String> storage;

    Stack<LinkedList<Transaction>> transactionLog;
    boolean transactionsActive;

    KeyValueStorage() {
        storage = new HashMap<>();
        transactionLog = new Stack<>();
        transactionsActive = false;
    }

    public String read(String k) {
        if (storage.containsKey(k)) {
            return storage.get(k);
        }
        return "KEY NOT PRESENT";
    }

    public String create(String k, String v) {

        if (storage.containsKey(k)) {
            return update(k, v);
        }

        storeOperation(k, null);
        storage.put(k, v);

        return v;
    }

    public String delete(String k) {
        if (storage.containsKey(k)) {
            storeOperation(k, storage.get(k));
            storage.remove(k);
            return "DELETE SUCCESS";
        }
        return "KEY NOT PRESENT";
    }

    public String update(String k, String v) {
        storeOperation(k, storage.get(k));
        return storage.put(k, v);
    }

    private void storeOperation(String key, String oldValue) {
        if (transactionsActive) {
            transactionLog.peek().addFirst(new Transaction(key, oldValue));
        }
    }

    public void begin() {
        transactionsActive = true;
        transactionLog.push(new LinkedList<>());
    }

    public void commit() {

        if (!transactionsActive) {
            return;
        }
        transactionsActive = false;
        transactionLog.pop();
    }

    public void commit(int t) {
        if (!transactionsActive) {
            return;
        }

        transactionsActive = false;

        LinkedList<Transaction> currTransact = transactionLog.pop();

        if (t > currTransact.size()) {
            System.out.println(t + " is more than the total number of transactions");
            t = currTransact.size();  // Set t to the size of the current transaction to avoid errors
        }

        // Apply the first 't' transactions
        while (t-- > 0) {
            currTransact.removeLast();
        }

        while (!currTransact.isEmpty()) {
            Transaction history = currTransact.removeFirst();

            if (history.oldValue == null) {
                storage.remove(history.key);
            } else {
                storage.put(history.key, history.oldValue);
            }
        }
    }

    public void rollback() {
        commit(0);
    }

    public void rollback(int t) {
        if (!transactionsActive) {
            return;
        }

        transactionsActive = false;

        LinkedList<Transaction> currTransact = transactionLog.pop();

        if (t > currTransact.size()) {
            System.out.println(t + " is more than the total number of transactions");
            t = currTransact.size();  // Set t to the size of the current transaction to avoid errors
        }

        // Apply the first 't' transactions
        while (t-- > 0) {
            currTransact.removeFirst();
        }

        while (!currTransact.isEmpty()) {
            Transaction history = currTransact.removeLast();

            if (history.oldValue == null) {
                storage.remove(history.key);
            } else {
                storage.put(history.key, history.oldValue);
            }
        }


    }

    public static void main(String[] args) {

        KeyValueStorage kv = new KeyValueStorage();

//        System.out.println("-------------------------------------");
//        System.out.println("              PART 1");
//        System.out.println("-------------------------------------");
//
//        System.out.println(kv.read("key1"));
//        kv.create("key1", "val1");
//        System.out.println(kv.read("key1"));
//        System.out.println(kv.update("key1", "val2"));
//        System.out.println(kv.read("key1"));
//        kv.delete("key1");
//        System.out.println(kv.read("key1"));
//
//        System.out.println("-------------------------------------");
//        System.out.println("              PART 1");
//        System.out.println("-------------------------------------");

        System.out.println("-------------------------------------");
        System.out.println("              PART 2");
        System.out.println("-------------------------------------");

        kv.create("key1", "val1");
        kv.create("key2", "val2");
        kv.create("key3", "val3");
        System.out.println(kv.read("key1"));
        System.out.println(kv.read("key2"));
        System.out.println(kv.read("key3"));

        kv.begin();

        kv.create("key3", "val8");
        kv.create("key5", "val5");
        System.out.println(kv.update("key5", "val7"));
        System.out.println(kv.update("key2", "val7"));
        System.out.println(kv.update("key2", "val8"));
        kv.delete("key1");

        kv.rollback(1);
        System.out.println();

        System.out.println(kv.read("key1"));
        System.out.println(kv.read("key2"));
        System.out.println(kv.read("key3"));

//        EXAMPLE 2

//        kv.create("key1", "val1");
//        kv.create("key2", "val2");
//        kv.create("key3", "val3");
//        System.out.println(kv.read("key1"));
//        System.out.println(kv.read("key2"));
//        System.out.println(kv.read("key3"));
//
//        kv.begin();
//        kv.create("key3", "val8");
//        System.out.println(kv.read("key3"));
//        kv.create("key5", "val5");
//        System.out.println(kv.read("key5"));
//        kv.update("key5", "val7");
//        System.out.println(kv.read("key5"));
//        kv.update("key2", "val7");
//        System.out.println(kv.read("key2"));
//        kv.update("key2", "val8");
//        System.out.println(kv.read("key2"));
//        kv.delete("key1");
//        System.out.println(kv.read("key1"));
////        kv.rollback();
//        System.out.println(kv.read("key1"));
//        System.out.println(kv.read("key2"));
//        System.out.println(kv.read("key3"));
//        System.out.println(kv.read("key5"));
//
//
//        System.out.println("-------------------------------------");
//        System.out.println("              PART 2");
//        System.out.println("-------------------------------------");


    }

}
