package LeetCode.DP;

public class RegularExpression10 {
    /**
     * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
     *
     * '.' Matches any single character.
     * '*' Matches zero or more of the preceding element.
     * The matching should cover the entire input string (not partial).
     *
     */

    /**
     * dp[i][j]表示s的前i个字符与p的前j个字符能否匹配
     * 字母 + 星号的组合在匹配的过程中，本质上只会有两种情况
     * 1.匹配s末尾的一个字符，将该字符扔掉，而该组合还可以继续进行匹配；
     * 2.不匹配字符，将该组合扔掉，不再进行匹配。
     *
     * @param s
     * @param p
     * @return
     */

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        //初始化
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                //注意长度是len+1
                if (p.charAt(j - 1) == '*') {
                    //跳过这个组合
                    f[i][j] = f[i][j - 2];
                    //或者利用这个组合继续
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                }
                else {
                    //不是* 就取决于当前字符是否匹配
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
