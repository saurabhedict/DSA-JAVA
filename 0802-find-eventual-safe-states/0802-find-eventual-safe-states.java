class Solution {
    public void BFS(List<List<Integer>> adj, int[] incoming, List<Integer> topological){
        int n = adj.size();
        Queue<Integer> que = new LinkedList<>();

        for(int i = 0; i<n; i++) if(incoming[i] == 0) que.add(i);
        while(!que.isEmpty()){
            int front = que.remove();
            topological.add(front);
            for(int i = 0; i<adj.get(front).size(); i++){
                int ele = adj.get(front).get(i);
                incoming[ele]--;
                if(incoming[ele] == 0) que.add(ele);
            }
        }
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++) adj.add(new ArrayList<>());
        int[] incoming = new int[n];

        for(int i = 0; i<n; i++){
            for(int ele : graph[i]){
                adj.get(ele).add(i);
                incoming[i]++;
            }
        }

        List<Integer> topological = new ArrayList<>();
        BFS(adj, incoming, topological);
        Collections.sort(topological);
        return topological;
    }
}