// class Solution {
//     public void BFS(int i, int[][] isConnected, boolean[] visited){
//       Queue<Integer> q = new LinkedList<>();
//       int n = isConnected.length;
//       q.add(i);
//       visited[i] = true;
//       while(!q.isEmpty()){
//         int front = q.remove();
//         for(int j=0; j<n; j++){
//            if(isConnected[front][j] == 1 && visited[j] == false){
//             q.add(j);
//             visited[j] = true;
//            }
//         }
//       }

//     }
//     public int findCircleNum(int[][] isConnected) {
//         int n = isConnected.length; //number of cities/vertex

//         boolean[] visited = new boolean[n];
//         int count  = 0;
//         for(int i = 0; i<n; i++){
//             if(visited[i] != true){
//                 BFS(i, isConnected, visited);
//                 count++;
//             }
            
//         }
//         return count;
//     }
// }



class Solution {
    public void DFS(int i, int[][] isConnected, boolean[] visited){
      int n = isConnected.length;
      visited[i] = true;
      for(int j = 0; j<n; j++){
        if(isConnected[i][j] == 1 && visited[j] == false ){ //first condition kya i --> j se connected hai, if yes then kya visited[j] khi already to visited nhi if nhi then usko hi pehle DFS lga do.
            DFS(j, isConnected, visited);
        }
      }

    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length; //number of cities/vertex

        boolean[] visited = new boolean[n];
        int count  = 0;
        for(int i = 0; i<n; i++){
            if(visited[i] != true){
                DFS(i, isConnected, visited);
                count++;
            }
            
        }
        return count;
    }
}