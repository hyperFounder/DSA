package main;

import java.util.Arrays;

public class ScheduleOrganizer {
    public static void main(String[] args) {
        int[][] meetings = {
                {14, 16},
                {9, 10},
                {10, 12},
                {8, 9}
        };
        System.out.println("Array before sorting");
        printMeetings(meetings);

        // Sort the array using a 2d lamba expression
        Arrays.sort(meetings, (a, b) -> {
            // Compare the start times
            if (a[0] != b[0])return Integer.compare(a[0], b[0]);
            else return Integer.compare(a[1], b[1]);
        });
        System.out.println("After sorting: ");
        printMeetings(meetings);
    }

    private static void printMeetings(int[][] meetings) {
        System.out.print("[");
        for (int i = 0; i < meetings.length; i++) {
            System.out.print(Arrays.toString(meetings[i]));
            if (i < meetings.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
