package FinalProject;

public class StringReversal {
    public void reverseWords(char[] s) {
        // Reverse the entire array
        reverse(s, 0, s.length - 1);

        int start = 0;
        // Reverse each word
        for (int i = 0; i <= s.length; i++) {
            if (i == s.length || s[i] == ' ') {
                reverse(s, start, i - 1);
                start = i + 1;
            }
        }
    }

    // Helper method to reverse a substring within the array
    private void reverse(char[] s, int start, int end) {
        while (start < end) {
            char temp = s[start];
            s[start++] = s[end];
            s[end--] = temp;
        }
    }
}

