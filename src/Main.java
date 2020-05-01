import java.util.HashSet;
import java.util.Scanner;

public class Main {
    //用backtrack来做
    int[][] matrix;
    HashSet<Integer>[] rowS;
    HashSet<Integer>[] colS;
    HashSet<Integer>[] blockS;
    boolean isSolved;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main test = new Main();
        test.matrix = new int[9][9];
        test.rowS = new HashSet[9];
        test.colS = new HashSet[9];
        test.blockS = new HashSet[9];
        test.isSolved =false;
        //输入input
        for(int i =0;i<9;i++)
        {
            test.rowS[i] = new HashSet<>();
            test.colS[i] = new HashSet<>();
            test.blockS[i] = new HashSet<>();
        }
        for(int i = 0; i < 9; i++){
            String x = sc.next();
            int loc = 1;
            for(int j = 0; j < 9; j++){
                test.matrix[i][j] = Integer.valueOf(x.charAt(loc)-'0');
                test.rowS[i].add(test.matrix[i][j]);
                test.colS[j].add(test.matrix[i][j]);
                loc +=2;
            }
        }
        //计算
        outloop:
        for(int i =0;i<9;i++)
        {
            for(int j = 0;j<9;j++)
            {
                if (test.matrix[i][j] == 0)
                {
                    for(int num = 1;num<=9;num++)
                    {
                        int bindex = (i/3)*3+ j/3;
                        if(!test.rowS[i].contains(num) && !test.colS[j].contains(num)&&!test.blockS[bindex].contains(num))
                        {

                            test.matrix[i][j] = num;
                            test.rowS[i].add(num);
                            test.colS[j].add(num);
                            test.blockS[bindex].add(num);
                            test.backtrack(i,j,num);
                            if(test.isSolved)
                                break outloop;
                            test.matrix[i][j] = 0;
                            test.rowS[i].remove(num);
                            test.colS[j].remove(num);
                            test.blockS[bindex].remove(num);
                        }
                    }
                }
            }
        }
        //输出结果
        for(int i = 0; i < 9; i++){
            System.out.print("{");
            for(int j = 0; j < 9; j++){
                System.out.print(test.matrix[i][j]);
                if(j != 8) System.out.print(",");
            }
            System.out.print("}");
            if(i != 8) System.out.println();
        }

    }

    private void backtrack(int cr,int cc,int num)
    {
        boolean hasZero = false;
        outloop:
        //遍历查找矩阵每一个
        for(int i =0;i<9;i++)
        {
            for(int j = 0;j<9;j++)
            {
                if (matrix[i][j] == 0)
                {
                    int bindex = (i/3)*3+ j/3;
                    for(int n = 1;n<=9;n++)
                    {
                        if(!rowS[i].contains(n) && !colS[j].contains(n)&&!blockS[bindex].contains(n))
                        {
                            matrix[i][j] = n;
                            rowS[i].add(n);
                            colS[j].add(n);
                            blockS[bindex].add(num);
                            backtrack(i,j,n);
                            if(isSolved) return;
                            rowS[i].remove(n);
                            colS[j].remove(n);
                            blockS[bindex].remove(num);
                            matrix[i][j] = 0;
                            hasZero = true;
                        }
                    }
                }
            }
        }
        isSolved = !hasZero;
    }

}