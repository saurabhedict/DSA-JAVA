// class Solution {
//     public void BFS(int i, List<List<Integer>> rooms, boolean[] visited){
//       Queue<Integer> q = new LinkedList<>();
//       int n = rooms.size();
//       q.add(i);
//       visited[i] = true;

//       while(!q.isEmpty()){
//         int front = q.remove();
//         for(int ele : rooms.get(front)){
//            if(visited[ele] == false) q.add(ele);
//             visited[ele] = true;
//            }
//         }

//     }
//     public boolean canVisitAllRooms(List<List<Integer>> rooms) {
//         int n = rooms.size(); //total rooms
//         boolean[] visited = new boolean[n];
//         BFS(0, rooms, visited);
//         for(int i = 0; i<n; i++){
//             if(visited[i] != true) return false;
//         }
//         return true;
//     }
// }


class Solution {
    public void DFS(int i, List<List<Integer>> rooms, boolean[] visited){
      int n = rooms.size();
      visited[i] = true;

        for(int ele : rooms.get(i)){
           if(visited[ele] == false){
            DFS(ele, rooms, visited);
            visited[ele] = true;
           }

        }

    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size(); //total rooms
        boolean[] visited = new boolean[n];
        DFS(0, rooms, visited);
        for(int i = 0; i<n; i++){
            if(visited[i] != true) return false;
        }
        return true;
    }
}