package main.leetcode;

import java.util.*;

public class InvalidTransaction {

    private record Transaction(String name, int time, int amount, String city){}

    public static List<String> invalidTransactions(String[] transactions){
        Map<String, NavigableMap<Integer, List<Transaction>>> byName = new HashMap<>();
        List<Transaction> all = new ArrayList<>(transactions.length);

        for (String s : transactions){
            String[] p = s.split(",");
            Transaction t = new Transaction(p[0], Integer.parseInt(p[1]), Integer.parseInt(p[2]), p[3]);
            all.add(t);
            byName.computeIfAbsent(t.name(), k -> new TreeMap<>())
                    .computeIfAbsent(t.time(), k -> new ArrayList<Transaction>())
                    .add(t);

        }

      List<String> invalid = new ArrayList<>();
        for (int i = 0; i<all.size(); i++){
            Transaction curr = all.get(i);
            if (curr.amount > 1000 || hasCityConflict(byName, curr)){
                invalid.add(transactions[i]);
            }
        }
        return invalid;
    }

    private static boolean hasCityConflict(Map<String, NavigableMap<Integer, List<Transaction>>> byName, Transaction curr){
        NavigableMap<Integer, List<Transaction>> times = byName.get(curr.name());
        var window = times.subMap(curr.time() - 60, true, curr.time() + 60, true);
        for (List<Transaction> atSameTime  : window.values()){
            for (Transaction other : atSameTime){
                if (!other.city().equals(curr.city())) return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        invalidTransactions(new String[]{"alice,20,800,mtv","alice,50,100,beijing"});
    }
}
