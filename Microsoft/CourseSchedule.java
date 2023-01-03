package Microsoft;

import java.util.*;

//uses topological sort to get the linear ordered tasks.
// if the topo list size is equal to the courses it means each course could be completed and hence return true,if not
//it implies a cycle exits in the graph and hence not possible.

class Solution {
    public boolean canFinish(int num, int[][] pre) {
        int[] visited = new int[num];

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < num; i++)
            adj.add(new ArrayList<>());

        for (int i = 0; i < pre.length; i++)
            adj.get(pre[i][1]).add(pre[i][0]);

        int[] in = new int[num];
        Queue<Integer> queue = new LinkedList<>();

        // calculating the indegree
        for (int i = 0; i < num; i++) {
            for (Integer it : adj.get(i))
                in[it]++;
        }

        for (int i = 0; i < in.length; i++)
            if (in[i] == 0)
                queue.offer(i);

        List<Integer> topo = new ArrayList<>();

        while (queue.size() > 0) {
            int node = queue.poll();
            topo.add(node);

            for (Integer it : adj.get(node)) {
                in[it]--;

                if (in[it] == 0)
                    queue.offer(it);
            }
        }

        if (topo.size() == num)
            return true;

        return false;

    }

}