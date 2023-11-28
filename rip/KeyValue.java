package rip;

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

//        - read("key1") – returns "No Key associated"
//        - create("key1", "val1") – returns "val1"
//        - read("key1") – returns "val1"
//        - update("key1", "val2") – returns "val2"
//        - read("key1") – returns "val2"
//        - delete("key1") – returns "Delete Success"
//        - read("key1") – returns "No key associated"

//        Part 2
//
//        Enable transactions for your data store. A transaction starts with begin() and operations like READ, CREATE, UPDATE, DELETE can take place during this time. After these operation, the transaction is ended by either a commit() that commits everything permanently in the data store or rollback() that reverts everything that was performed during the transaction window. Notice that I highlighted the key-word everything.

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
//        - commit() – this commits everything
//        After committing, you should still access the items in the data store with their update values.
//
//        - read("key1") – returns val8
//        - read("key2") – No Key Associated
//        - read("key3") – returns val8

//        Example 2:
//
//        - create("key1", "val1")
//        - create("key2", "val2")
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
//        commit(t) - Commits only the first t transactions.
//        rollback(t) – rolls back  only the last t transactions.
//        For this part, Please note that only those operations that change the state of our data store are counted as transactions.

//        Example 1:
//
//        - create(“key1”, “val1”)
//        - create(“key2”, “val2”)
//        - create(“key3”, “val3”)
//        - read(“key1”) – returns “val1”
//        - read(“key2”) – returns “val2”
//        - read(“key3”) – returns “val3”
//        - begin() – this begins a transaction
//        - create(“key3”, “val8”)
//        - read(“key3”) – returns val8
//        - create(“key5”, “val5”)
//        - read(“key5”) – returns val5
//        - update(“key5”, “val7”
//        - read(“key5”) – returns val7
//        - update(“key2”, “val7”
//        - read(“key2”) – returns val7
//        - update(“key2”, “val8”
//        - read(“key2”) – returns val8
//        - delete(“key1”)
//        - read(“key1”) – No Key Associated
//        - commit(2) – this commits only the first two transactions
//        - read(“key1”) – returns val1
//        - read(“key2”) – returns val2
//        - read(“key3”) – returns val8
//        - read(“key5”) - returns val5

import java.util.HashMap;
import java.util.LinkedList;

public class KeyValue {

    class TNode {
        String TType;
        String k;
        String v;

        TNode(String TType, String k, String v) {
            this.TType = TType;
            this.k = k;
            this.v = v;
        }
    }

    class Transaction {

        LinkedList<TNode> Tll;

        private HashMap<String, String> map;


        Transaction(HashMap<String, String> mainMap) {
            this.Tll = new LinkedList<TNode>();
            this.map = new HashMap<>();
            this.map.putAll(mainMap);
        }

    }

    boolean isTranscationActive = false;
    private HashMap<String, String> map;

    KeyValue() {
        map = new HashMap<>();
    }

    Transaction transact;

    public void begin() {
        if (isTranscationActive) {
            System.out.println("TRANSACTION EXISTS ALREADY ACTIVE, RESETTING DATA");
        } else {
            System.out.println("ACTIVATING TRANSACTION");
        }
        isTranscationActive = true;
        transact = new Transaction(map);
    }

    public String create(String k, String v) {
        if (isTranscationActive) {
            updateTransactions(new TNode("ADD", k, v));
            return create(transact.map, k, v);
        } else {
            return create(map, k, v);
        }
    }

    private String create(HashMap<String, String> map, String k, String v) {
        if (!map.containsKey(k)) {
            return map.put(k, v);
        } else {
            return update(map, k, v, false);
        }
    }

    public String update(String k, String v) {
        if (isTranscationActive) {
            return update(transact.map, k, v, true);
        } else {
            return update(map, k, v, false);
        }
    }

    private String update(HashMap<String, String> map, String k, String v, boolean updateLL) {
        if (map.containsKey(k)) {
            if (updateLL) {
                updateTransactions(new TNode("UPDATE", k, v));
            }
            return map.put(k, v);
        } else {
            return "UNABLE TO UPDATE";
        }
    }

    public String read(String k) {
        if (isTranscationActive) {
            return read(transact.map, k);
        } else {
            return read(map, k);
        }
    }

    private String read(HashMap<String, String> map, String k) {
        if (isTranscationActive) {
            updateTransactions(new TNode("READ", k, ""));
        }
        return map.getOrDefault(k, "NO VALUE FOR THE KEY");

    }

    public String delete(String k) {
        if (isTranscationActive) {
            return delete(transact.map, k);
        } else {
            return delete(map, k);
        }
    }

    private String delete(HashMap<String, String> map, String k) {
        if (map.containsKey(k)) {
            if (isTranscationActive) {
                updateTransactions(new TNode("DELETE", k, ""));
            }
            return map.remove(k);
        } else {
            return "KEY DOES NOT EXISTS";
        }
    }

    public void updateTransactions(TNode t) {
        updateTransactions(transact.Tll, t);
    }

    private void updateTransactions(LinkedList<TNode> ll, TNode t) {
        ll.addLast(t);
    }

    public void commit() {
        commit(map, transact);
    }

    private void commit(HashMap<String, String> globalMap, Transaction t) {
        System.out.println("COMMITTING ALL " + t.Tll.size() + " TRANSACTION & " + t.map.size() + " CHANGES");
        globalMap.putAll(t.map);
        isTranscationActive = false;
        this.transact = null;
    }

    public void commit(int c) {
        // commit(t) - Commits only the first t transactions.

    }

    private void commit(HashMap<String, String> globalMap, Transaction t, int c) {


    }

    public void rollback() {
        rollback(transact);
    }

    private void rollback(Transaction t) {
        System.out.println("ROLLING BACK ALL " + t.Tll.size() + " TRANSACTION & " + t.map.size() + " CHANGES");
        isTranscationActive = false;
        this.transact = null;
    }

    public static void main(String[] args) {

        KeyValue kv = new KeyValue();

//        System.out.println("-------------------------------------");
//        System.out.println("              PART 1");
//        System.out.println("-------------------------------------");
//
//        System.out.println(kv.read("key1"));
//        kv.create("key1", "val1"));
//        System.out.println(kv.read("key1"));
//        System.out.println(kv.update("key1", "val2"));
//        System.out.println(kv.read("key1"));
//        kv.delete("key1");
//        System.out.println(kv.read("key1"));
//
//        System.out.println("-------------------------------------");
//        System.out.println("              PART 1");
//        System.out.println("-------------------------------------");

//        System.out.println("-------------------------------------");
//        System.out.println("              PART 2");
//        System.out.println("-------------------------------------");
//
//        kv.create("key1", "val1");
//        kv.create("key2", "val2");
//        kv.create("key3", "val3");
//        System.out.println(kv.read("key1"));
//        System.out.println(kv.read("key2"));
//        System.out.println(kv.read("key3"));
//        kv.begin();
//        kv.create("key3", "val8");
//        System.out.println(kv.read("key3"));
//        kv.create("key5", "val5");
//        System.out.println(kv.read("key5"));
//        System.out.println(kv.update("key5", "val7"));
//        System.out.println(kv.read("key5"));
//        System.out.println(kv.update("key2", "val7"));
//        System.out.println(kv.read("key2"));
//        System.out.println(kv.update("key2", "val8"));
//        System.out.println(kv.read("key2"));
//        kv.delete("key1");
//        System.out.println(kv.read("key1"));
//        kv.commit();

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
//        kv.rollback();
//        System.out.println(kv.read("key1"));
//        System.out.println(kv.read("key2"));
//        System.out.println(kv.read("key3"));
//        System.out.println(kv.read("key5"));

//
//        System.out.println("-------------------------------------");
//        System.out.println("              PART 2");
//        System.out.println("-------------------------------------");


        System.out.println("-------------------------------------");
        System.out.println("              PART 3");
        System.out.println("-------------------------------------");


        System.out.println("-------------------------------------");
        System.out.println("              PART 3");
        System.out.println("-------------------------------------");


    }


}
