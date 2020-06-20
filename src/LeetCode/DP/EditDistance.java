package LeetCode.DP;

public class EditDistance {
    /**
     * leetcode 72 经典dynamic programming
     * word1 = "horse", word2 = "ros"
     *
     *      ""  h   o   r   s   e
     *  ""  0   1   2   3   4   5
     *  r   1   1   2   2   3   4
     *  o   2   2   1   2   3   4
     *  s   3   3   2   2   2   3
     *
     *  相等时 = 【左上】 比较 （【左边】，【上边】）+1
     *  不相等时 =  （【左上】，【左边】，【上边】） + 1
     *
     */

    public static void main(String[] args) {
        EditDistance editDistance =new EditDistance();
        String word1 = "eat";
        String word2 = "sea";
        System.out.println("1");
        for(int i = 0;i<=word1.length();i++)
        {
            for(int j = 0 ;j<=word2.length();j++)
            {
                System.out.print(editDistance.minDistance(word1,word2)[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println("2");
        for(int i = 0;i<=word1.length();i++)
        {
            for(int j = 0 ;j<=word2.length();j++)
            {
                System.out.print(editDistance.minDistance2(word1,word2)[i][j] + "  ");
            }
            System.out.println();
        }
    }
    public int[][] minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        int[][] dp = new int[len1+1][len2+1];

        for(int i = 0;i <= len1;i++)
            dp[i][0] = i;
        for(int i = 0;i <= len2;i++)
            dp[0][i] = i;

        for(int i = 1;i<= len1; i ++)
        {
            for(int j = 1;j<= len2; j++)
            {
                if(word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                {
                    if(i == j) dp[i][j] = dp[i-1][j-1] +1;
                    else
                        dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j])) +1;
                }
            }
        }
        return dp;
    }

    public int[][] minDistance2(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();


        // DP 数组
        int [][] D = new int[n + 1][m + 1];

        // 边界状态初始化
        for (int i = 0; i < n + 1; i++) {
            D[i][0] = i;
        }
        for (int j = 0; j < m + 1; j++) {
            D[0][j] = j;
        }

        // 计算所有 DP 值
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                int left = D[i - 1][j] + 1;
                int down = D[i][j - 1] + 1;
                int left_down = D[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1))
                    left_down += 1;
                D[i][j] = Math.min(left, Math.min(down, left_down));

            }
        }
        return D;
    }
}
