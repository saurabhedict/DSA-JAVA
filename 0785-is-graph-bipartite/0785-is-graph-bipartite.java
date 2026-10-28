class Solution {
    class Pair{
        int num;
        int colour;
        Pair(int num, int colour){
            this.num = num;
            this.colour = colour;
        }
    }
    public boolean BFS(int[][] graph, int[] visited, int i){
        int n = visited.length;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, 0));
        visited[i] = 0;

        while(!q.isEmpty()){
            Pair front = q.remove();
            int parent = front.num;
            int parentColour = front.colour;

            for(int j = 0; j<graph[parent].length; j++){
                int ele = graph[parent][j];
               if(visited[ele] == -1){
                   if(parentColour == 0){
                     q.add(new Pair(ele, 1));
                     visited[ele] = 1;
                   }
                   else{
                    q.add(new Pair(ele, 0));
                    visited[ele] = 0;
                   }
            
               }

               else{
                if(parentColour == visited[ele]) return false;
               }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] visited = new int[n];
        Arrays.fill(visited, -1);

         for(int i = 0; i<n; i++){
            if(visited[i] == -1){
                boolean result = BFS(graph, visited, i);
                if(result ==  false) return false;
            }
         }
         return true;
    }
}