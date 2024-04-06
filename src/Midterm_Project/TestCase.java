package Midterm_Project;

import java.util.ArrayList;

// Test cases:
public class TestCase {

    public static ArrayList printTree(TreeNode root, ArrayList result) {
        if (root != null) {
//            System.out.print(root.val + " ");
            result.add(root.val);
//            result.add(" ");
            printTree(root.left,result);
            printTree(root.right,result);
        } else {
//            System.out.print("null ");
            result.add("null");
//            result.add(" ");
        }
        return result;
    }

    public static void main(String[] args) {



        Midterm midterm = new Midterm();
        // Problem 1
        // Test Case 1: The given example in the problem
        TreeNode root1_1 = new TreeNode(1);
        root1_1.left = new TreeNode(2);
        root1_1.right = new TreeNode(3);
        root1_1.left.left = new TreeNode(4);
        root1_1.left.right = new TreeNode(5);
        System.out.println("Problem 1 tst case 1 previous structure(preorder):"+printTree(root1_1,new ArrayList<>()).toString());
        System.out.println("Problem 1 test case 1 result structure(preorder): "+ printTree(midterm.upsideDownBinaryTree(root1_1),new ArrayList<>()).toString());
        System.out.println("Problem 1 test case 1 result:" + root1_1.val);
        // Test Case 2: An empty tree
        TreeNode root1_2 = null;
        System.out.println("Problem 1 test case 3 result: "+ midterm.upsideDownBinaryTree(root1_2));// Expected Output: ""

        // Problem 2
        // Test Case 1: 
        TreeNode root2_1 = new TreeNode(5);
        root2_1.left = new TreeNode(1);
        root2_1.left.left = new TreeNode(5);
        root2_1.left.right = new TreeNode(5);
        root2_1.right = new TreeNode(5);
        root2_1.right.right = new TreeNode(5);

        int result1 = midterm.countUnivalSubtrees(root2_1);
        System.out.println("Problem 2 test case 1 result: "+result1); // Expected: 4

        // Test Case 2:
        TreeNode root2_2 =new TreeNode(1);
        int result2 = midterm.countUnivalSubtrees(root2_2);
        System.out.println("Problem 2 test case 2 result: "+result2); // Expected: 4
    


        // Promblem 3
        // Test Case 1
        int[] preorder1 = {5, 2, 1, 3, 6};
        System.out.println("Problem 3 test case 1: " + midterm.verifyPreorder(preorder1)); // Output: true
        
        // Test Case 2
        int[] preorder2 = {5, 2, 6, 1, 3};
        System.out.println("Problem 3 test case 2: " + midterm.verifyPreorder(preorder2)); // Output: false

        // Problem 4
        // Test Case 1: The ball can roll directly to the destination
        int[][] maze1 = {
            {0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0},
            {1, 1, 0, 1, 1},
            {0, 0, 0, 0, 0}
        };
        int[] start1 = {0, 4};
        int[] destination1 = {4, 4};
        System.out.println("Problem 4 test case 1: " + midterm.shortestDistance(maze1, start1, destination1)); 
        // Expected: Should be a valid distance, not -1

        // Test case 2: The ball cannot reach the destination
        int[][] maze2 = {
            {0, 0, 1, 0, 0},
            {0, 1, 0, 0, 0},
            {0, 1, 1, 1, 0},
            {0, 0, 0, 0, 0},
            {1, 1, 0, 1, 1}
        };
        int[] start2 = {0, 4};
        int[] destination2 = {3, 2};
        System.out.println("Problem 4 test case 2: " + midterm.shortestDistance(maze2, start2, destination2)); 
        // Expected: -1, because the destination is blocked by walls
        // Test case 3: The ball cannot reach the destination
        int[][] maze3 = {
                {0,0,0,0,0},
                {1,1,0,0,1},
                {0,0,0,0,0},
                {0,1,0,0,1},
                {0,1,0,0,0}
        };
        int[] start3 = {4, 3};
        int[] destination3 = {0, 1};
        System.out.println("Problem 4 test case 3: " + midterm.shortestDistance(maze3, start3, destination3));
    }
}
