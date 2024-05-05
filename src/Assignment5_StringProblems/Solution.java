package Assignment5_StringProblems;
import java.util.*;
public class Solution {
    // Method to find the longest substring with at most two distinct characters
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.length() < 3) return s.length();

        // HashMap to count characters in the current window
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0, maxLength = 2;

        while (right < s.length()) {
            map.put(s.charAt(right), right++);

            // When we have more than two distinct characters
            if (map.size() == 3) {
                // Delete the leftmost character
                int delIndex = Collections.min(map.values());
                map.remove(s.charAt(delIndex));
                // Move left pointer of the window
                left = delIndex + 1;
            }

            // Calculate the max length of the current window
            maxLength = Math.max(maxLength, right - left);
        }
        return maxLength;
    }

    public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }

    private List<String> helper(int n, int m) {
        if (n == 0) return new ArrayList<>(Arrays.asList(""));
        if (n == 1) return new ArrayList<>(Arrays.asList("0", "1", "8"));

        List<String> list = helper(n - 2, m);
        List<String> res = new ArrayList<>();

        for (String s : list) {
            if (n != m) res.add("0" + s + "0");
            res.add("1" + s + "1");
            res.add("6" + s + "9");
            res.add("8" + s + "8");
            res.add("9" + s + "6");
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Testing Problem 1
        String input1 = "eceba";
        System.out.println("Length of longest substring( "+ input1 +" ) with at most two distinct characters: " +
                solution.lengthOfLongestSubstringTwoDistinct(input1)); // Expected: 3

        String input2 = "ccaabbb";
        System.out.println("Length of longest substring( "+ input2 +" ) with at most two distinct characters: " +
                solution.lengthOfLongestSubstringTwoDistinct(input2)); // Expected: 3

        // Testing Problem 2
        for(int n=1;n<=4; n++){
            List<String> strobogrammaticNumbers = solution.findStrobogrammatic(n);
            System.out.println("Strobogrammatic numbers of length " + n + ": " + strobogrammaticNumbers);
        }
//        int n = 3;

    }

}
