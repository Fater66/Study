package LeetCode.BFS;

import javafx.util.Pair;
import javafx.util.Pair;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

// 279. Perfect Squares
// https://leetcode-cn.com/problems/perfect-squares/description/
// 该方法会导致 Time Limit Exceeded 或者 Memory Limit Exceeded
// 时间复杂度: O(2^n)
// 空间复杂度: O(2^n)

//BFS算法组成的套路：
//
//        1.初始化三元素：
//        Node = node(n) queue = [Node] visited = set([Node.value])
//        2.操作队列 —— 弹出队首节点：
//        vertex = queue.pop(0)
//        3.操作弹出的节点 —— 根据业务生成子节点（一个或多个）：
//        [node(vertex.value - n*n, Node.step+1) for n in range(1,int(vertex.value**.5)+1)]
//        4.判断这些节点 —— 符合业务条件，则return，不符合业务条件，且不在已访问集合，则追加到队尾，并加入已访问集合：`
//        5.若以上遍历完成仍未return，下面操作返回未找到代码：
//        return -1

public class PerfectSquare {
    public int numSquares(int n) {
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(n,0));
        //由于从不同的节点，都可以到同一个节点，每个节点只需要入队一次即可
        HashMap<Integer,Boolean> visited = new HashMap<>();
        visited.put(n,true);
        while(!queue.isEmpty())
        {
            Pair<Integer,Integer> curr = queue.poll();
            int num = curr.getKey();
            int step = curr.getValue();
            if (num == 0) return step;
            for (int i = 1;num - i* i >= 0;i++)
            {
                if (!visited.containsKey(num-i*i))
                {
                    //进一步优化
                    if (num -i * i == 0)
                        return step +1;
                    queue.offer(new Pair<>(num-i*i,step+1));
                    visited.put(num-i*i,true);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println((new PerfectSquare()).numSquares(12));
        System.out.println((new PerfectSquare()).numSquares(13));
    }
}
