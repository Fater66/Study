package LeetCode.DP;

public class FreedomTrail {

    public  static void main(String[] args)
    {
        FreedomTrail test = new FreedomTrail();
        System.out.println(test.findRotateSteps("godding","gd"));
    }

//动态规划
//dp[i][j]，key的0~i位字符拼写后，ring的第j位对齐12：00方向，需要的最小步数
//前提：key[i] = ring[j]，若不满足，dp[i][j] = INT_MAX

    public int findRotateSteps(String ring, String key) {
        int r = ring.length();
        int k = key.length();
        int[][] dp = new int[k][r];
        for (int i = 0 ; i< r;i++)
        {
            if (ring.charAt(i) == key.charAt(0)) dp[0][i] = Math.min(i+1,r-i+1);
        }
        for (int i = 1; i <k;i++)
        {
            for (int j = 0;j<r;j++)
            {
                dp[i][j] = Integer.MAX_VALUE;
                if (key.charAt(i) != ring.charAt(j)) continue;//第一次判断 如果key i位置与ring j 位置不同 j位置dp没有作用
                else{
                    for (int m = 0;m<r;m++)
                    {
                        //第二次判断 如果key m-1位置与ring j位置不相同 j位置的dp就没有作用 转不到这个位置 不能用这个状态
                        if (key.charAt(m-1) != ring.charAt(j)) continue;
                        else
                        {
                            dp[i][j] = Math.min(dp[i][j],dp[i-1][m] + Math.min((j-m +r) %r,(m-j+r)%r)+1);
                        }
                    }
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0;i< r;i++)
        {
            if (key.charAt(k-1) == ring.charAt(i))
                result = Math.min(result,dp[k-1][i]);
        }
        return result;
    }
}
