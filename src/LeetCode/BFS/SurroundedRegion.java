package LeetCode.BFS;

import java.util.Stack;

public class SurroundedRegion {

    public static void main(String[] args) {
        SurroundedRegion test = new SurroundedRegion();
        char[][] testChar = new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
//        test.solve1(testChar); //dfs 递归
        test.solve2(testChar); //dfs非递归 利用stack
        for (int i = 0;i < testChar.length;i++)
        {
            for (int j = 0 ;j < testChar[0].length;j++)
            {
                System.out.print(testChar[i][j] + " ");
            }
            System.out.println();
        }

//        System.out.println((new SurroundedRegion()).solve1());
    }

    //dfs 递归方法
    public void solve1(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        int row = board.length;
        int col = board[0].length;

        for (int i =0;i<row;i++)
        {
            for (int j = 0;j<col;j++)
            {
                boolean isEdge = (i == 0 || j==0||i == board.length-1 ||j == board[0].length-1);
                if (isEdge && board[i][j] == 'O')
                {
                    dfs(board,i,j);
                }
            }
        }

        for (int i = 0;i<row;i++)
        {
            for (int j= 0;j<col;j++)
            {

                if (board[i][j]=='#')
                    board[i][j]='O';
                else if (board[i][j] == 'O')
                    board[i][j]='X';

            }
        }
        return;
    }

    private void dfs(char[][] board,int i,int j)
    {
        if (i < 0 || i >= board.length || j <0 || j >= board[0].length ||board[i][j] == 'X' || board[i][j] == '#')
        {
            return ;
        }
        //already searched
        board[i][j] = '#';
        //上下左右
        dfs(board,i+1,j);
        dfs(board,i-1,j);
        dfs(board,i,j-1);
        dfs(board,i,j+1);
        return;
    }

    public class Pos{
        int i;
        int j;
        Pos(int i,int j)
        {
            this.i = i;
            this.j = j;
        }
    }
    //dfs 非递归 利用stack
    public void solve2(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        int row = board.length;
        int col = board[0].length;

        for (int i =0;i<row;i++)
        {
            for (int j = 0;j<col;j++)
            {
                boolean isEdge = (i == 0 || j==0||i == board.length-1 ||j == board[0].length-1);
                if (isEdge && board[i][j] == 'O')
                {
                    dfs2(board,i,j);
                }
            }
        }

        for (int i = 0;i<row;i++)
        {
            for (int j= 0;j<col;j++)
            {

                if (board[i][j]=='#')
                    board[i][j]='O';
                else if (board[i][j] == 'O')
                    board[i][j]='X';

            }
        }
        return;
    }

    private void dfs2(char[][] board,int i,int j)
    {
        Stack<Pos> stack = new Stack<>();
        stack.push(new Pos(i,j));
        board[i][j] = '#';
        while(!stack.isEmpty())
        {
            //不弹出 只查看最高的位置
            Pos curr = stack.peek();
            //上
            if(curr.i -1 >= 0 && board[curr.i-1][curr.j] == 'O')
            {
                stack.push(new Pos(curr.i-1,curr.j));
                board[curr.i-1][curr.j] = '#';
                continue;
            }
            //下
            if (curr.i+1 < board.length && board[curr.i+1][curr.j] == 'O')
            {
                stack.push(new Pos(curr.i+1,curr.j));
                board[curr.i+1][curr.j] = '#';
                continue;
            }
            //左
            if(curr.j -1 >= 0 && board[curr.i][curr.j-1] == 'O')
            {
                stack.push(new Pos(curr.i,curr.j-1));
                board[curr.i][curr.j-1] = '#';
                continue;
            }
            //右
            if (curr.j+1 < board[0].length && board[curr.i][curr.j+1] == 'O')
            {
                stack.push(new Pos(curr.i,curr.j+1));
                board[curr.i][curr.j+1] = '#';
                continue;
            }
            stack.pop();
        }

    }
}
