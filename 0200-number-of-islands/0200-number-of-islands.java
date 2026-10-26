// class Solution {
//     public class Pair{
//         int row;
//         int col;
//         Pair(int row, int col){
//             this.row = row;
//             this.col = col;
//         }
//     }
//     public void BFS(char[][] grid, boolean[][] visited, Pair p){
//       int m = grid.length;
//       int n = grid[0].length;
//       Queue<Pair> q = new LinkedList<>();
//       q.add(p);
//       while(!q.isEmpty()){
//         Pair front = q.remove();
//         int row = front.row;
//         int col = front.col;
//         if(row-1 >=0 && visited[row-1][col] == false && grid[row-1][col] == '1'){
//             Pair p1 = new Pair(row-1, col);
//             q.add(p1);
//             visited[row-1][col] = true;
//         }
//         if(col-1 >=0 && visited[row][col-1] == false && grid[row][col-1] == '1'){
//             Pair p1 = new Pair(row, col-1);
//             q.add(p1);
//             visited[row][col-1] = true;
//         }
//         if(row+1 < m && visited[row+1][col] == false && grid[row+1][col] == '1'){
//             Pair p1 = new Pair(row+1, col);
//             q.add(p1);
//             visited[row+1][col] = true;
//         }
//         if(col+1 < n && visited[row][col+1] == false && grid[row][col+1] == '1'){
//             Pair p1 = new Pair(row, col+1);
//             q.add(p1);
//             visited[row][col+1] = true;
//         }
//       }
//     }
//     public int numIslands(char[][] grid) {
//         int m = grid.length;
//         int n = grid[0].length;
//         boolean[][] visited = new boolean[m][n];

//         int count = 0;
//         for(int i = 0; i<m; i++){
//             for(int j = 0; j<n; j++){
//                 if(grid[i][j] == '1' && visited[i][j] == false){
//                     Pair p = new Pair(i, j);
//                     visited[i][j] = true;
//                     BFS(grid, visited, p);
//                     count++;
//                 }
                
//             }
//         }
//         return count;
//     }
// }



class Solution {
    public class Pair{
        int row;
        int col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public void DFS(char[][] grid, boolean[][] visited, Pair p){
      int m = grid.length;
      int n = grid[0].length;
     
        int row = p.row;
        int col = p.col;
        if(row-1 >=0 && visited[row-1][col] == false && grid[row-1][col] == '1'){
            Pair p1 = new Pair(row-1, col);
            visited[row-1][col] = true;
            DFS(grid, visited, p1);
        }
        if(col-1 >=0 && visited[row][col-1] == false && grid[row][col-1] == '1'){
            Pair p1 = new Pair(row, col-1);
            visited[row][col-1] = true;
            DFS(grid, visited, p1);
        }
        if(row+1 < m && visited[row+1][col] == false && grid[row+1][col] == '1'){
            Pair p1 = new Pair(row+1, col);
            visited[row+1][col] = true;
            DFS(grid, visited, p1);
        }
        if(col+1 < n && visited[row][col+1] == false && grid[row][col+1] == '1'){
            Pair p1 = new Pair(row, col+1);
            visited[row][col+1] = true;
            DFS(grid, visited, p1);
        }
      
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        int count = 0;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == '1' && visited[i][j] == false){
                    Pair p = new Pair(i, j);
                    visited[i][j] = true;
                    DFS(grid, visited, p);
                    count++;
                }
                
            }
        }
        return count;
    }
}