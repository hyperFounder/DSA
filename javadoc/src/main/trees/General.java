package main.trees;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class General {
    public static void main(String[] args) {
        NavigableMap<Integer, String> map = new TreeMap<>();
        map.put(1, "01-01-2026");
        map.put(2, "01-01-2026");
        map.put(3, "01-01-2026");

        for (Map.Entry<Integer, String> entry : map.entrySet()){
            System.out.println(entry.getKey());
        }
    }
}
