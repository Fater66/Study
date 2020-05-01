package LeetCode.Dijkstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Dijkstra {

    /**
     * 743. Network Delay Time
     * @param args
     */
    public  static void main(String[] args)
    {
        Dijkstra test = new Dijkstra();
        int[][] matrix = {{1,2,1}};
        System.out.println(test.networkDelayTime(matrix,2,2));
    }

    HashMap<Integer,Integer> dist;
    public int networkDelayTime(int[][] times, int N, int K) {
        //using map to store the paths
        HashMap<Integer,List<int[]>> map = new HashMap<>();
        for(int[] time:times)
        {
            List<int[]> cl = map.getOrDefault(time[0],new ArrayList<int[]>());
            cl.add(new int[]{time[1],time[2]});
            map.put(time[0],cl);
        }
        dist = new HashMap<>();
        boolean[] seen = new boolean[N+1];
        for(int i =1;i<=N;i++)
        {
            if(i != K) dist.put(i,Integer.MAX_VALUE);
            else dist.put(K,0);
        }
        while(true)
        {
            int candNode=-1;
            int candDist = Integer.MAX_VALUE;
            for(int i =1;i<=N;i++)
            {
                if(!seen[i] && dist.get(i) < candDist)
                {
                    candNode = i;
                    candDist = dist.get(i);
                }
            }
            //all hav been seen
            if (candNode == -1) break;
            seen[candNode] = true;
            if(map.containsKey(candNode))
            {
                for(int[] adj:map.get(candNode))
                {
                    //relaxation step
                    dist.put(adj[0],Math.min(dist.get(adj[0]),dist.get(candNode) + adj[1]));
                }
            }

        }
        int result = Integer.MIN_VALUE;
        for(int node:dist.keySet())
        {
            if(dist.get(node) == Integer.MAX_VALUE) return -1;
            result = Math.max(dist.get(node),result);
        }
        return result;
    }
}
