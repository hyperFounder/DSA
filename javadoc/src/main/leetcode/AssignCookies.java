package main.leetcode;

public class AssignCookies {

    public static int findContentChildren(int[] g, int[] s) {
        int happy = 0;
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < s.length; j++) {
                if (g[i] == s[j]) {
                    happy++;
                    // Mark g[i] as seen
                    g[i] = 10000;
                    s[j] = 10000;
                }
            }
        }

        return happy;
    }

    public static void main(String[] args) {
        System.out.println(findContentChildren(new int[]{10,9,8,7}, new int[]{5,6,7,8}));
    }
}
