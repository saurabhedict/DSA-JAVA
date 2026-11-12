class Solution {
    public void BFS(List<List<Integer>> adj, List<Integer> topological, int[] incoming){
        int n = incoming.length;
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i<n; i++) if(incoming[i] == 0) que.add(i);
        
        while(!que.isEmpty()){
            int front = que.remove();
            topological.add(front);
            List<Integer> all = adj.get(front);
            for(int i = 0; i<all.size(); i++){
                int ele = all.get(i);
                incoming[ele]--;
                if(incoming[ele] == 0) que.add(ele);
            }
        }
    }
    public int[] findOrder(int n, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++) adj.add( new ArrayList<>());
        int[] incoming = new int[n];
        for(int i = 0; i<prerequisites.length; i++){
            int course = prerequisites[i][0];
            int req = prerequisites[i][1];
            adj.get(req).add(course);
            incoming[course]++;
        }
        List<Integer> topological = new ArrayList<>();
        BFS(adj, topological, incoming);
        int[] ans = new int[topological.size()];
        if(topological.size() != n) return new int[0];
        for(int i = 0; i<topological.size(); i++){
            ans[i] = topological.get(i);
        }
        return ans;
    }
}