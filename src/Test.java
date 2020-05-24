import javafx.util.Pair;

import java.lang.reflect.Array;
import java.util.*;

public class Test {

    public static void main(String[] args) {
        Test test = new Test();
//        char[][] matrix = {{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        char[][] matrix = {{'0','1'},{'0','1'}};
        System.out.println(test.maximalRectangle(matrix));
    }


        public int maximalRectangle(char[][] matrix) {
            int row = matrix.length;
            int col = matrix[0].length;
            int[][][] dp = new int[row][col][2];
            int result = 0;
            int maxHeight=1 ,maxWidth = 1;
            for(int i = 0;i<row;i++)
            {
                if(matrix[i][0] == '0') continue;
                if(i!=0) maxHeight= Math.max(1,dp[i-1][0][1]+1);
                else maxHeight =1;
                dp[i][0][0] = 1;
                dp[i][0][1] = maxHeight;
                result = Math.max(result,maxHeight);
            }
            for(int i = 0;i<col;i++)
            {
                if(matrix[0][i] == '0') continue;
                if(i!=0) maxWidth= Math.max(1,dp[0][i-1][0]+1);
                else maxWidth =1;
                dp[0][i][0] = maxWidth;
                dp[0][i][1] = 1;
                result = Math.max(result,maxWidth);
            }
            for(int i =1;i<row;i++)
            {
                for(int j = 1;j<col;j++)
                {
                    if(matrix[i][j] == '0') continue;
                    dp[i][j][0] = Math.max(dp[i][j-1][0]+1,1);
                    dp[i][j][1] = Math.max(dp[i-1][j][1]+1,1);
                    maxWidth = Math.max(1,Math.min(dp[i-1][j-1][0]+1,Math.min(dp[i][j-1][0]+1,dp[i-1][j][0])));
                    maxHeight=Math.max(1,Math.min(dp[i][j-1][1],Math.min(dp[i-1][j-1][1]+1,dp[i-1][j][1]+1)));

                    result = Math.max(result,maxHeight*maxWidth);
                }
            }
            return result;
        }

}