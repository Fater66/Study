package LeetCode.DP;

import java.util.Arrays;

public class DungeonGame {
    /**
     * 此题不具有后无效性 因此只能从右下往左上遍历
     * @param args
     */
    public  static void main(String[] args)
    {
        DungeonGame test = new DungeonGame();
        int[][] dungeon = {{0,-3}};
        System.out.println(test.calculateMinimumHP(dungeon));
    }
    public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
        if (row == 0) return 0;
        int col = dungeon[0].length;
        if (col == 0) return 0;
        int[][] dp = new int[row][col];
        dp[row-1][col-1] = Math.max(0,-dungeon[row-1][col-1]);
        for (int i = row -2;i>=0;i--)
        {
            dp[i][col-1] = Math.max(0,dp[i+1][col-1] - dungeon[i][col-1]);
        }
        for (int i = col -2;i>=0;i--)
        {
            dp[row-1][i] = Math.max(0,dp[row-1][i+1] - dungeon[row-1][i]);
        }
        for (int i = row-2;i >= 0;i--)
        {
            for (int j = col-2;j >= 0;j--)
            {
                int pre = Math.min(dp[i+1][j]-dungeon[i][j],dp[i][j+1]-dungeon[i][j]);
                dp[i][j] = Math.max(dp[i][j],pre);
            }
        }
        return dp[0][0]+1;
    }

}
