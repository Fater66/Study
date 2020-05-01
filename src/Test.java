import javafx.util.Pair;

import java.lang.reflect.Array;
import java.util.*;

public class Test {

    public static void main(String[] args) {
        Test test = new Test();


        int[] cost = {0,1,42,32,41,5};
        int[] dist = {0,1,300,401,410,500};
        //
        test.memo(cost,dist,0,5);
        System.out.println(test.memo[0]);
    }

    int[] memo = new int[6];
    private int result = Integer.MAX_VALUE;
    //cost存的是每个城市的酒店cost，dist存每个酒店到起点距离，
    // currentloc就是递归当前到的城市坐标，targetLoc就是终点，currCost就是从起点到currentLoc的cost和（不一定是最优的）
    public void nomemo(int[] cost,int[] dist,int currentLoc,int targetLoc,int currCost)
    {
        //终止条件
        if(currentLoc == targetLoc)
        {
            //当有个方法能到终点时，将这个方法的总cost和别的方法进行比较，取最小值
            result = Math.min(currCost,result);
        }
        //遍历之后的所有城市
        for(int i =currentLoc+1;i<=targetLoc;i++)
        {
            //判断能否从当前城市开到第i 个城市
            if(dist[i] - dist[currentLoc] <= 400)
            //如果可以，加上现在处在的酒店的cost
                nomemo(cost,dist,i,targetLoc,currCost+cost[currentLoc]);
        }
    }

    private int memo(int[] cost,int[] dist,int currentLoc,int targetLoc)
    {
        if(currentLoc == targetLoc)
        {
            return 0;
        }
        int minCost = Integer.MAX_VALUE;
        for(int i =currentLoc+1;i<=targetLoc;i++)
        {
            if(dist[i] - dist[currentLoc] <= 400)
            {
                if(memo[i] != 0)
                    minCost = Math.min(minCost,memo[i]+cost[currentLoc]);
                else
                {
                    minCost = Math.min(minCost,cost[currentLoc]+memo(cost,dist,i,targetLoc));
                }
            }
        }
        memo[currentLoc] = minCost;
        return minCost;
    }
}