import java.util.Stack;

public class test {

    public static int calculateRegion(int[] heights) {
        int totalRegion = 0;
        int n = heights.length;
        // 用于存储每个学生左侧和右侧第一个比他矮的学生位置的数组
        int[] leftFirstMin = new int[n];
        int[] rightFirstMin = new int[n];

        Stack<Integer> stack = new Stack<>();

        // 找到每个学生左侧第一个比他矮的学生的位置
        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {

                stack.pop();

            }
            leftFirstMin[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        // 找到每个学生右侧第一个比他矮的学生的位置
        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() && heights[(int)stack.peek()] >= heights[i]) {
                stack.pop();

            }
            rightFirstMin[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        // 计算每个学生的区域长度并加到总和中
        for (int i = 0; i < n; i++) {
            int left = leftFirstMin[i] + 1; // 计算左边界
            int right = rightFirstMin[i] - 1; // 计算右边界
            totalRegion += (right - left + 1); // 计算区域长度并累加
        }

        return totalRegion;
    }

    public static void main(String[] args) {
        int[] heights = {3, 5, 6}; // 学生高度数组
        System.out.println(calculateRegion(heights)); // 输出总区域长度之和
    }
}
