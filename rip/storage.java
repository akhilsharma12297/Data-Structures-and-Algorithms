package rip;

import java.util.HashMap;
import java.util.Map;

public class storage {
    class Transaction {
        Map<String, String> store = new HashMap<>();
        Transaction next;
    }

    class TransactionStack {
        Transaction top;
        int size;
    }

    private TransactionStack tStack = new TransactionStack();
    private Map<String, String> globalStore = new HashMap<>();

    public void begin() {
        Transaction temp = new Transaction();
        temp.next = tStack.top;
        tStack.top = temp;
        tStack.size++;
    }

    public void end() {
        if (tStack.top != null) {
            Transaction current = tStack.top;
            tStack.top = current.next;
            tStack.size--;
            current.next = null;
            current.store.clear();
        }
    }

    public void commit() {
        Transaction current = tStack.top;
        while (current != null) {
            globalStore.putAll(current.store);
            current = current.next;
        }
    }

    public void rollback() {
        if (tStack.top != null) {
            tStack.top.store.clear();
        }
    }

    public String get(String key) {
        Transaction current = tStack.top;
        if (current != null) {
            return current.store.get(key);
        }
        return globalStore.get(key);
    }

    public void set(String key, String value) {
        Transaction current = tStack.top;
        if (current != null) {
            current.store.put(key, value);
        } else {
            globalStore.put(key, value);
        }
    }

    public void unset(String key) {
        Transaction current = tStack.top;
        if (current != null) {
            current.store.remove(key);
        } else {
            globalStore.remove(key);
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        storage store = new storage();

        store.begin();
        store.set("v1", "a");
        store.set("v2", "b");
        store.set("v3", "c");

        store.begin();
        store.set("v1", "A");
        store.set("v2", "B");
        store.set("v3", "C");
        System.out.println("v1->" + store.get("v1"));
        System.out.println("v2->" + store.get("v2"));
        System.out.println("v3->" + store.get("v3"));
        store.commit();
        store.end();

        store.set("v1", "x");
        store.set("v2", "y");
        store.set("v3", "z");

        store.set("v4", "d");
        store.set("v5", "e");
        store.set("v6", "f");
        System.out.println("v1->" + store.get("v1"));
        System.out.println("v2->" + store.get("v2"));
        System.out.println("v3->" + store.get("v3"));
        store.commit();
        store.end();
        System.out.println("v1->" + store.get("v1"));
        System.out.println("v2->" + store.get("v2"));
        System.out.println("v3->" + store.get("v3"));
    }
}