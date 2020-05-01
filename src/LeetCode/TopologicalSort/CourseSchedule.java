package LeetCode.TopologicalSort;

import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            int[] indegrees = new int[numCourses];
            for(int[] prerequisite:prerequisites)
            {
                indegrees[prerequisite[1]] ++;
            }
            Queue<Integer> queue = new LinkedList<>();
            for(int i = 0;i<indegrees.length;i++)
            {
                if(indegrees[i] == 0) queue.offer(i);
            }
            while(!queue.isEmpty())
            {
                int course = queue.poll();
                for(int[] pre:prerequisites)
                {
                    if(pre[0] != course) continue;
                    indegrees[pre[1]] --;
                    if(indegrees[pre[1]] ==0) queue.offer(pre[1]);
                }
                numCourses--;
            }
            return numCourses == 0;
        }
}
