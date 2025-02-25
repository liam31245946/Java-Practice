public class Generics<V> {
    private static final int SIZE = 10;
    private String[] keys;  // Array for keys (String)
    private V[] values;     // Array for values (Generic type V)

    // Constructor to initialize arrays
    @SuppressWarnings("unchecked")
    public Generics() {
        keys = new String[SIZE];
        values = (V[]) new Object[SIZE];
    }

    // Private method to compute index using hashing
    private int getIndex(String key) {
        int hashCode = Math.abs(key.hashCode());
        return hashCode % SIZE;  // Keep the index within bounds
    }

    // Method to add a key-value pair
    public void add(String key, V value) {
        int index = getIndex(key);
        keys[index] = key;
        values[index] = value;
    }

    // Method to retrieve a value by its key
    public V get(String key) {
        int index = getIndex(key);
        if (key.equals(keys[index])) {
            return values[index];
        } else {
            return null;
        }
    }

    // Method to print all existing key-value pairs
    public void describe() {
        for (int i = 0; i < SIZE; i++) {
            if (keys[i] != null) {
                System.out.format("%s\t%s%n", keys[i], values[i]);
            }
        }
    }

    // Main method for testing the Generics class
    public static void main(String[] args) {
        // Test with Integer values
        System.out.println("Integers:");
        Generics<Integer> intDict = new Generics<>();
        intDict.add("age", 3);
        intDict.add("height", 40);
        intDict.describe();

        // Test with String values
        System.out.println("\nStrings:");
        Generics<String> strDict = new Generics<>();
        strDict.add("bff", "Debbie");
        strDict.add("foe", "Foo");
        strDict.describe();

        // Retrieve specific values
        System.out.println("\nRetrieving specific values:");
        System.out.println("Age: " + intDict.get("age"));  // Should return 3
        System.out.println("BFF: " + strDict.get("bff"));  // Should return Debbie
    }
}
