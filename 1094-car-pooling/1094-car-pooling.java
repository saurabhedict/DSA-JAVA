// class Solution {
//     public boolean carPooling(int[][] trips, int capacity) {
//         int n = trips.length;

//         PriorityQueue<Integer> minheap = new PriorityQueue<>();
//         for(int i = 0; i<n; i++){
//             minheap.add(trips[i][1]);
//         }
//         int start = minheap.peek();

//         PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
//         for(int i = 0; i<n; i++){
//             maxheap.add(trips[i][2]);
//         }
//         int end = maxheap.peek();
//         int size = 0;
//         if(start == 0) size = end+1;
//         else size = end;

//         int[] arr = new int[size];

//         for(int i = 0; i<n; i++){
//             int passenger = trips[i][0];
//             int from = trips[i][1];
//             int to = trips[i][2];

//             for(int j = from; j<=to-1; j++){
//                 arr[j] += passenger;
//             }
//         }
//         for(int i = 0; i<arr.length; i++){
//             if(arr[i] > capacity) return false;
//         }
//         return true;
//     }
// }



class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int n = trips.length;

        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i<n; i++){
            minheap.add(trips[i][1]);
            maxheap.add(trips[i][2]);
        }
        int start = minheap.peek();
        int end = maxheap.peek();
        
        int size = 0;
        if(start == 0) size = end+1;
        else size = end;

        int[] arr = new int[size];

        for(int i = 0; i<n; i++){
            int passenger = trips[i][0];
            int from = trips[i][1];
            int to = trips[i][2];

            for(int j = from; j<=to-1; j++){
                arr[j] += passenger;
                 if(arr[j] > capacity) return false;
            }
        }

        return true;
    }
}