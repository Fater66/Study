package LeetCode.backtrack;

import java.util.ArrayList;
import java.util.List;

class Nqueens {

    public  static void main(String[] args)
    {
        Nqueens test = new Nqueens();

        for(List<String> currList:test.solveNQueens(4))
        {
            for (String s:currList)
            {
                System.out.println(s);
            }
        }
    }
    boolean[][] queenLoc;
    ArrayList<List<String>> result = new ArrayList<>();
    boolean[] rows;
    boolean[] cols;
    boolean[] lefts;
    boolean[] rights;
    int n;
    boolean[][] isVisited;
    public List<List<String>> solveNQueens(int n) {
        queenLoc = new boolean[n][n];
        rows = new boolean[n];
        cols = new boolean[n];
        isVisited = new boolean[n][n];
        int m = 2*n-1;
        lefts = new boolean[m];
        rights = new boolean[m];
        this.n = n;
        backtrack(0,n,0);
        return result;
    }

    private void backtrack(int row,int target,int startc)
    {
        if(row == target)
        {
            addResult();
            return;
        }
            for(int j = 0;j<n;j++)
            {
                int currLeft = row-j+n-1;
                int currRight = row+j;
                if (!(rows[row] || cols[j] || lefts[currLeft]||rights[currRight]))
                {
                    queenLoc[row][j] = true;
                    rows[row] = true;
                    cols[j] = true;
                    lefts[currLeft] = true;
                    rights[currRight] = true;
//                    isVisited[row][j] = true;
                    backtrack(row+1,target,j);
                    queenLoc[row][j] = false;
                    rows[row] = false;
                    cols[j] = false;
                    lefts[currLeft] = false;
                    rights[currRight] = false;
//                    isVisited[i][j] = false;
                }
            }

    }

    private void addResult()
    {
        ArrayList<String> temp = new ArrayList<>();
        StringBuilder sb;
        for(int i = 0;i<n;i++)
        {
            sb = new StringBuilder();
            for(int j = 0;j<n;j++)
            {
                if (queenLoc[i][j])
                {
                    sb.append("Q");
                }
                else sb.append(".");
            }
            temp.add(sb.toString());
        }
        result.add(temp);
    }
}
