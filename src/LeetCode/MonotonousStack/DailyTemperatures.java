package LeetCode.MonotonousStack;

import java.util.Stack;

public class DailyTemperatures {
    /**
     * LC 739
     * Given a list of daily temperatures T, return a list such that, for each day in the input,
     * tells you how many days you would have to wait until a warmer temperature.
     * If there is no future day for which this is possible, put 0 instead
     * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
     * @param T
     * @return
     */
    public int[] dailyTemperatures(int[] T) {
        //维护一个单调栈
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int[] result = new int[T.length];

        for(int i =0;i<T.length;i++)
        {
            while(stack.peek() != -1 && T[stack.peek()] < T[i])
            {
                result[stack.peek()] = i - stack.peek() ;
                stack.pop();
            }
            stack.push(i);
        }
        return result;
    }
}
