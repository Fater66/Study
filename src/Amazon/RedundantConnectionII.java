package Amazon;

import java.util.*;

public class RedundantConnectionII {

    public static void main(String[] args) {
        RedundantConnectionII test = new RedundantConnectionII();
        int[] result = test.findRedundantDirectedConnection(new int[][]{{1,2}, {1,3}, {2,3}});
        System.out.println(result[0] + "," + result[1]);
    }
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int N = edges.length;
        Map<Integer,Integer> parent = new HashMap();
        List<int[]> candidates = new ArrayList<>();
        for(int[] edge:edges)
        {
            //如果parent中已经有了 说明此node有两个parents
            if(parent.containsKey(edge[1]))
            {
                //将当前edge和之前的edge都加入candidates
                candidates.add(new int[]{parent.get(edge[1]),edge[1]});
                candidates.add(edge);
            }
            else parent.put(edge[1],edge[0]);
        }
        //利用orbit找到两次visit的node或者tree顶
        int root = orbit(1,parent).node;
        //If there are no candidates, then every vertex has one parent, such as in the case 1->2->3->4->1->5. From any node, we walk towards it's parent until we revisit a node - then we must be inside the cycle, and any future seen nodes are part of that cycle. Now we take the last edge that occurs in the cycle.
        if(candidates.isEmpty()){
            Set<Integer> cycle = orbit(root,parent).seen;
            int[] ans = new int[]{0,0};
            for(int[] edge:edges)
            {
                if(cycle.contains(edge[0])&&cycle.contains(edge[1]))
                    ans = edge;
            }
            return ans;
        }

        //Otherwise, we'll see if the graph induced by parent is a rooted tree. We again take the root by walking from any node towards the parent until we can't, then we perform a depth-first search on this root.
        //构造树的过程
        Map<Integer,List<Integer>> children = new HashMap<>();
        for(int v:parent.keySet())
        {
            int pv = parent.get(v);
            if(!children.containsKey(pv))
                children.put(pv,new ArrayList<Integer>());
            children.get(pv).add(v);
        }
        //做dfs
        boolean[] seen = new boolean[N+1];
        seen[0] = true;
        Stack<Integer> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty())
        {
            int node = stack.pop();
            if(!seen[node]){
                seen[node] = true;
                if(children.containsKey(node))
                    for(int c:children.get(node))
                        stack.push(c);
            }

        }
        //If we visit every node, then removing the last of the two edge candidates is acceptable, and we should. Otherwise, we should remove the first of the two edge candidates.
        for(boolean b:seen) if(!b)
            return candidates.get(0);
        return candidates.get(1);
    }


    public OrbitResult orbit(int node,Map<Integer,Integer> parent)
    {
        Set<Integer> seen = new HashSet<>();
        //如果node有parent而且没有访问过
        while(parent.containsKey(node) && !seen.contains(node))
        {
            seen.add(node);
            //获取parent继续搜索
            node = parent.get(node);
        }
        return new OrbitResult(node,seen);
    }
}
class OrbitResult{
    int node;
    Set<Integer> seen;
    OrbitResult(int n,Set<Integer> s)
    {
        node = n;
        seen = s;
    }
}
