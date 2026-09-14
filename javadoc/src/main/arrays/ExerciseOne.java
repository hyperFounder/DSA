package main.arrays;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Objects;

class BrowserHistory{
    Deque<String> forwardStack = new ArrayDeque<>();
    Deque<String> backwardStack = new ArrayDeque<>();
    private String current;

    public BrowserHistory(String current) {
        this.current = current;
    }

    public String getCurrent() {
        return current;
    }

    public void visit(String url){
        backwardStack.push(current);
        current = url;
        forwardStack.clear();
    }

    public String forward(){
        if (!forwardStack.isEmpty()){
            backwardStack.push(current);
            current = forwardStack.pop();
        }
        return current;
    }

    public String back(){
        if (!backwardStack.isEmpty()){
            forwardStack.push(current);
            current = backwardStack.pop();
        }
        return current;
    }

    public String back(int steps){
        for (int i =0; i<steps && !backwardStack.isEmpty(); i++){
            back();
        }
        return current;
    }

    public String forward(int steps){
        for (int i =0; i<steps && !forwardStack.isEmpty(); i++){
            forward();
        }
        return current;
    }
}
public class ExerciseOne {

    public static void main(String[] args) {

        String s = "anagram";
        String t = "nagaram";

        char[] arrS = s.toCharArray();
        char[] arrT = t.toCharArray();

        Arrays.sort(arrS);
        Arrays.sort(arrT);

        System.out.println(Arrays.toString(arrS));
        System.out.println(Arrays.toString(arrT));
        System.out.println(Arrays.equals(arrS, arrT));


        BrowserHistory browser = new BrowserHistory("google.com");
        System.out.println("Opened browser at: " + browser.getCurrent());

        browser.visit("stackoverflow.com");
        browser.visit("github.com/torvalds");

        System.out.println("\n--- Back ---");
        System.out.println(browser.back());    // stackoverflow.com
        System.out.println(browser.back());    // google.com
        System.out.println(browser.back());    // google.com (no-op)

        System.out.println("\n--- Forward ---");
        System.out.println(browser.forward()); // stackoverflow.com

        System.out.println("\n--- Forward cleared on new visit ---");
        browser.visit("youtube.com");
        System.out.println(browser.forward()); // youtube.com (no-op)
    }
}