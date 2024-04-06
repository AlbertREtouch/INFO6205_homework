package Midterm_Project;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Midterm {
    // Utility method to print the binary tree in pre-order traversal

    // Tree Node Class
    // Problem 1
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        // Base case
        if (root == null || root.left == null) {
            return root;
        }
        // Recursively call the function on the left child.
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        
        root.left.left = root.right;   // Turn the original right child into the new left child
        root.left.right = root;         // Turn the original root into the new right child
        
        root.left = null;               // Sever the link to the original left child
        root.right = null;              // Sever the link to the original right child
        
        return newRoot; // The new root is the leftmost leaf node
    }

    // Problem 2
    public int countUnivalSubtrees(TreeNode root) {
        int[] count = new int[1]; // Use an array to hold the count so it can be modified in the helper method
        isUnival(root, count, 0);
        return count[0];
    }

    private boolean isUnival(TreeNode node, int[] count, int parentVal) {
        if (node == null) return true;
        
        // Recursively check if left and right subtrees are uni-value
        boolean left = isUnival(node.left, count, node.val);
        boolean right = isUnival(node.right, count, node.val);
        
        // If one of the subtrees is not uni-value, then this tree is not uni-value
        if (!left || !right) return false;
        
        // Current tree is uni-value, increment the count and return true
        count[0]++;
        return node.val == parentVal;
    }

    //Problem 3
    public boolean verifyPreorder(int[] preorder) {
        int n = preorder.length;
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MIN_VALUE;

        for (int value : preorder) {
            // If we find a node that is on the right side and smaller than the root, return false
            if (value < root) {
                return false;
            }

            // Nodes greater than stack's top are right children; we pop until we find their parent
            while (!stack.isEmpty() && stack.peek() < value) {
                root = stack.pop();
            }

            // The current value must be the left or right child of the previous value
            stack.push(value);
        }

        return true;
    }

    //Problem 4
    //using BFS method

    
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int[][] DIRECTIONS = {{0,1}, {1,0}, {0,-1}, {-1,0}}; // right, down, left, up
        int m = maze.length, n = maze[0].length;
        int[][] distance = new int[m][n]; // Stores the shortest distance to reach each cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                distance[i][j] = Integer.MAX_VALUE; // Initialize distances as infinity
            }
        }
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start[0], start[1]});
        distance[start[0]][start[1]] = 0; // Distance to start cell is 0
        
        while (!queue.isEmpty()) {
            int[] s = queue.poll();
            for (int[] dir : DIRECTIONS) {
                int x = s[0] + dir[0];
                int y = s[1] + dir[1];
                int cnt = 0;
                
                while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                    cnt++;
                }
                
                // Roll back to the last valid position
                x -= dir[0];
                y -= dir[1];
                
                // If this path is shorter, update the distance and add to the queue
                if (distance[s[0]][s[1]] + cnt < distance[x][y]) {
                    distance[x][y] = distance[s[0]][s[1]] + cnt;
                    queue.offer(new int[]{x, y});
                }
            }
        }
        
        return distance[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : distance[destination[0]][destination[1]];
    }


}


