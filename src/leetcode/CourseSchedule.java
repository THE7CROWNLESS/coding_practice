package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//图的遍历
//拓扑排序 ：
//        1、后序遍历的reverse（规律）
//        2、bfs的出队顺序（更符合逻辑）
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        //数组存的是对象，需要一个个new，否则会报空指针异常
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] inDegree = new int[numCourses];

        //构建图
        buildGraph(graph, numCourses, prerequisites, inDegree);

        //bfs遍历
//        int count = bfs(graph, inDegree);
//        return count == numCourses;
        boolean[] path = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < numCourses && !visited[i]; i++) {
            if (!dfs(i,graph,path,visited)){
                return false;
            }
        }
        return true;
    }


    public boolean dfs(int course, List<Integer>[] graph, boolean[] path,boolean[] visited) {
        if (path[course]){
            return false;
        }
        path[course] = true;
        visited[course] = true;
        for (Integer next : graph[course]) {
            dfs(next, graph, path,visited);
        }
        path[course] = false;

        return true;
    }


    //bfs广度优先
    public int bfs(List<Integer>[] graph, int[] inDegree) {
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int out = queue.poll();
            count++;
            for (Integer course : graph[out]) {
                inDegree[course]--;
                if (inDegree[course] == 0) {
                    queue.offer(course);
                }
            }
        }
        return count;
    }

    //构建图
    public void buildGraph(List<Integer>[] graph, int numCourses, int[][] prerequisites, int[] inDegree) {
        for (int i = 0; i < numCourses; i++) {
            for (int j = 0; j < prerequisites.length; j++) {
                if (i == prerequisites[j][1]) {
                    int tmp = prerequisites[j][0];
                    inDegree[tmp]++;
                    graph[i].add(tmp);
                }
            }
        }
    }
}
