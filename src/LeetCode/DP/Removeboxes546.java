package LeetCode.DP;

public class Removeboxes546 {
    /**
     * Given several boxes with different colors represented by different positive numbers.
     * You may experience several rounds to remove boxes until there is no box left. Each time you can choose some continuous boxes with the same color (composed of k boxes, k >= 1), remove them and get k*k points.
     * Find the maximum points you can get
     *
     * Input: boxes = [1,3,2,2,2,3,4,3,1]
     * Output: 23
     * Explanation:
     * [1, 3, 2, 2, 2, 3, 4, 3, 1]
     * ----> [1, 3, 3, 4, 3, 1] (3*3=9 points)
     * ----> [1, 3, 3, 3, 1] (1*1=1 points)
     * ----> [1, 1] (3*3=9 points)
     * ----> [] (2*2=4 points)
     */

    /**
     * dp[l][r][k]表示boxes[l][r]可以获得的最大分数，同时r后有3个相同的数
     *
     * dp[l][r][k] = max(dp[l][r][k],dp[l][i][k+1] + dp[i+1][r-1][0];
     * i 位置的数跟k位置相同 可以一起消除
     * @param boxes
     * @return
     */

    public int removeBoxes(int[] boxes) {
        int[][][] dp = new int[100][100][100];
        return remove(dp,boxes,0,boxes.length-1,0);
    }

    private int remove(int[][][] dp,int[] boxes,int start,int end,int k)
    {
        if(start > end)
            return 0;
        if(dp[start][end][k] != 0)
            return dp[start][end][k];
        while(start < end && boxes[end] == boxes[end-1])
        {
            k++;
            end--;
        }
        //k == 0 因为后面的都被消除了
        dp[start][end][k] = remove(dp,boxes,start,end-1,0) + (k+1) * (k+1);
        for(int i = start;i<end;i++)
        {
            if(boxes[i] == boxes[end])
                //如果i位置的数跟后面的一样，比较大小 是中间区域加上两边分开的分数。
                dp[start][end][k] = Math.max(dp[start][end][k],remove(dp,boxes,start,i,k+1) + remove(dp,boxes,i+1,end-1,0));
        }
        return dp[start][end][k];
    }
}
