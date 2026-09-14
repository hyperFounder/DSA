package main.leetcode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

// Solution to https://www.youtube.com/watch?v=46dZH7LDbf8

public class Neetcode {

    Set<Integer> hashset;

    public Neetcode(Set<Integer> hashset) {
        this.hashset = hashset;
    }

    public void insert(int val){
        hashset.add(val);
    }

    public void delete(int val){
        Iterator<Integer> iterator = hashset.iterator();
        while (iterator.hasNext()){
            int element = iterator.next();
            if (element == val){
                iterator.remove();
            }
        }
    }

    public int getRandom(){
        Random rand = new Random();
        return hashset.stream().toList().get(rand.nextInt(hashset.size()));
    }

    public Set<Integer> getHashset() {
        return hashset;
    }

    public static void main(String[] args) {
        Neetcode n = new Neetcode(new HashSet<>());
        n.insert(1);
        n.insert(2);
        n.insert(3);
        n.insert(4);
        System.out.println("Before deletion: " + n.getHashset());
        n.delete(4);
        System.out.println("After deletion: " + n.getHashset());
        System.out.println(n.getRandom());
    }
}
