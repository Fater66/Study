package LeetCode.MonotonousStack;

import java.util.Stack;

public class LargestRectangleinHistogram {
    /**
     * LC84
     * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
     * 维护一个单调栈 记得push（-1）
     */
    public int largestRectangleArea(int[] heights) {
        //维护一个单调栈
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = 0;
        for(int i =0;i<heights.length;i++)
        {
            while(stack.peek() != -1 && heights[stack.peek()] >= heights[i])
            {
                maxArea = Math.max(maxArea,heights[stack.pop()]*(i-stack.peek()-1));
            }
            stack.push(i);
        }
        //最后需要清空stack
        while(stack.peek() != -1)
        {
            maxArea = Math.max(maxArea,heights[stack.pop()]*(heights.length-stack.peek()-1));
        }
        return maxArea;
    }
}
