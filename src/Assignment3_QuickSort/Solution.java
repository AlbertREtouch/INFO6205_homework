package Assignment3_QuickSort;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Solution {

    public static List<Integer> quicksort(List<Integer> arr) {
        if (arr.size() <= 1) {
            return arr;
        }
        int pivot = arr.get(arr.size() / 2);
        List<Integer> left = new ArrayList<>();
        List<Integer> middle = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int num : arr) {
            if (num < pivot) {
                left.add(num);
            } else if (num > pivot) {
                right.add(num);
            } else {
                middle.add(num);
            }
        }

        List<Integer> result = new ArrayList<>();
        result.addAll(quicksort(left));
        result.addAll(middle);
        result.addAll(quicksort(right));
        return result;
    }

    public static boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                return false;
            }
        }
        return true;
    }

    public static int countSubarrays(int[] nums) {
        int count = 0;
        int ones = 0, zeros = 0;
        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            while (j < nums.length && ones <= zeros) {
                if (nums[j] == 1) {
                    ones++;
                } else {
                    zeros++;
                }
                if (ones > zeros) {
                    count += nums.length - j;
                }
                j++;
            }
            if (nums[i] == 1) {
                ones--;
            } else {
                zeros--;
            }
            if (i >= j) {
                j = i + 1;
                ones = 0;
                zeros = 0;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        // Test problem 1
        int[][] intervals1 = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println("Test case 1: " + (canAttendMeetings(intervals1) ? "Can attend all meetings" : "Cannot attend all meetings"));

        int[][] intervals2 = {{7, 10}, {2, 4}};
        System.out.println("Test case 2: " + (canAttendMeetings(intervals2) ? "Can attend all meetings" : "Cannot attend all meetings"));

        // Test problem 2
        int[] nums1 = {0, 1, 1, 0, 1};
        System.out.println("Test case 1: " + countSubarrays(nums1));

        int[] nums2 = {0};
        System.out.println("Test case 2: " + countSubarrays(nums2));

        int[] nums3 = {1};
        System.out.println("Test case 3: " + countSubarrays(nums3));
    }
}
