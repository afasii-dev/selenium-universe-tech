package model;

import java.util.ArrayList;

public class Database {
    public static ArrayList<String> DATABASE = new ArrayList<>();

    static {
        System.out.println("Connecting to Database...");
    }

    public static void save(String string) {
        System.out.println(String.format("Saving %s ... ", string));
        DATABASE.add(string);
    }

    public static String get(int index) {
        System.out.println("Getting an element");
        return DATABASE.get(index);
    }

    public static void cleanup() {
        DATABASE.clear();
    }
}