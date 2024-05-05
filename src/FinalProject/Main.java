package FinalProject;

public class Main {
    public static void main(String[] args) {
        // Problem 1: Celebrity Problem
        int[][] graph1 = new int[][]{{1,1,0}, {0,1,0}, {1,1,1}};
        CelebrityProblem celebrityProblem1 = new CelebrityProblem(graph1);
        System.out.println("Celebrity Index: " + celebrityProblem1.findCelebrity(3)); // Output: 2

        int[][] graph2 = new int[][]{{1,1,0}, {0,1,1}, {0,0,1}};
        CelebrityProblem celebrityProblem2 = new CelebrityProblem(graph2);
        System.out.println("Celebrity Index: " + celebrityProblem2.findCelebrity(3)); // Output: 2

        // Problem 2: Remove Nth Node From End of List
        LinkedListOperations listOperations = new LinkedListOperations();
        LinkedListOperations.ListNode head1 = listOperations.new ListNode(1);
        head1.next = listOperations.new ListNode(2);
        head1.next.next = listOperations.new ListNode(3);
        head1.next.next.next = listOperations.new ListNode(4);
        head1.next.next.next.next = listOperations.new ListNode(5);
        // head = [1,2,3,4,5], n = 2
        LinkedListOperations.ListNode result = listOperations.removeNthFromEnd(head1, 2);
        System.out.print("Modified List after Removal: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        System.out.println(); // Output: 1 2 3 5

        // Problem 3: Reverse Words in a String Array
        char[] chars1 = "the sky is blue".toCharArray();
        StringReversal stringReversal = new StringReversal();
        stringReversal.reverseWords(chars1);
        System.out.println("Reversed String1: " + new String(chars1)); // Output: "blue is sky the"

        char[] chars2 = "a".toCharArray();
        stringReversal.reverseWords(chars2);
        System.out.println("Reversed String2: " + new String(chars2)); // Output: "a"

        // Problem 4: Word Distance
        String[] wordsDict = new String[]{"practice", "makes", "perfect", "coding", "makes"};
        WordDistance wordDistance = new WordDistance(wordsDict);
        System.out.println("Distance between 'coding' and 'practice': " + wordDistance.shortest("coding", "practice")); // Output: 3
        System.out.println("Distance between 'makes' and 'coding': " + wordDistance.shortest("makes", "coding")); // Output: 1
    }
}

