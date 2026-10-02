class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = capital.length;
        int[][] arr = new int[n][2];

        for(int i = 0; i<n; i++){
            arr[i][0] = capital[i];
            arr[i][1] = profits[i];
        }

        Arrays.sort(arr, (a,b) -> Integer.compare(a[0],b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int initial = w;
        int i = 0;

        while(k>0){
          while(i<n && k>0 && arr[i][0] <= initial){
            pq.add(arr[i][1]);
            i++;
          }
         if(!pq.isEmpty()) initial += pq.remove();
          k--;
        }
        return initial;
    }
}