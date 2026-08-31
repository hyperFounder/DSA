package main;

import java.util.HashSet;
import java.util.concurrent.TimeUnit;

public class Main{

    private static void simulateDelay(int seconds){
        try{
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }


    private static void exerciseOne(){

        HashSet<Character> hs = new HashSet<>();
        String s = "cbacdcbc";
        String result = "";

        for (Character a : s.toCharArray()){
            hs.add(a);
        }

        for (Character a : hs){
            result = result + a;
        }

        System.out.println(result);



    }
    public static void main(String[] args) {

        exerciseOne();

//        CompletableFuture<String> toastTask = CompletableFuture.supplyAsync(
//                () -> {
//                    System.out.println(" -> [Background] Putting bread in the toaser...");
//                    simulateDelay(3);
//                    return "Crispy Toast";
//                });
//
//        simulateDelay(1);
//        String toastResult = toastTask.join();
//        System.out.println("Enjoying my " + toastResult + " with coffee");

//        CompletableFuture<String> future = CompletableFuture.supplyAsync(
//                () -> "report"
//        ).thenApply(name -> name.toUpperCase())
//                .thenApply(name -> "FINAL_" + name)
//                        .exceptionally(ex -> {
//                            System.out.println("Error: " + ex.getMessage());
//                            return "DEFAULT VALUE";
//                        });

//        CompletableFuture<String> future =
//                CompletableFuture.<String>supplyAsync(() -> {
//                            throw new RuntimeException("Failed");
//                        })
//                        .exceptionally(ex -> {
//                            return "Fallback value";
//                        });
//
//        System.out.println(future.join());


    }


}

