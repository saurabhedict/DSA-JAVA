class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        List<Integer> ans = new ArrayList<>();

        if(x<arr[0]){
            for(int i = 0; i<k; i++){
               ans.add(arr[i]);
            }
            return ans;
        }

        if(x>arr[n-1]){
            for(int i = n-1; i>=n-k; i--){
               ans.add(arr[i]);
            }
            Collections.sort(ans);
            return ans;
        }

        int lb = n;
        int lo = 0;
        int hi = n-1;
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            if(arr[mid]>=x) {
                lb = mid;
                hi = mid-1;
            }
            else {
                lo = mid+1;
            }
        }

        int i = lb-1;
        int j = lb;
        while(k>0 && i>=0 && j<n){
            int disI = Math.abs(x-arr[i]);
            int disJ = Math.abs(x-arr[j]);

            if(disI < disJ){
                ans.add(arr[i]);
                i--;
            }
            else if(disI > disJ){
                ans.add(arr[j]);
                j++;
            }
            else{
                if(arr[i] < arr[j]) {
                    ans.add(arr[i]);
                    i--;
                }
                else {
                    ans.add(arr[j]);
                    j++;
                }
            }
            k--;
        }
        if(i<0){
            while(k>0){
                ans.add(arr[j]);
                j++;
                k--;
            }
        }
        if(j == n){
            while(k>0){
                ans.add(arr[i]);
                i--;
                k--;
            }
        }

         Collections.sort(ans);
         return ans;

    }
}



// class Solution {
// class Pair implements Comparable<Pair> {
//     int num;
//     int dist;

//     Pair(int num, int dist) {
//         this.num = num;
//         this.dist = dist;
//     }

//     @Override
//     public int compareTo(Pair p) {
//         if (this.dist != p.dist) {
//             return Integer.compare(this.dist, p.dist);
//         }
//         return Integer.compare(this.num, p.num);
//     }
// }
//     public List<Integer> findClosestElements(int[] arr, int k, int x) {
//        int n = arr.length;
//        PriorityQueue<Pair> pq = new PriorityQueue<>();

//        for(int i = 0; i<n; i++){
//           Pair p = new Pair(arr[i], Math.abs(arr[i]-x));
//           pq.add(p);
//        }

//        List<Integer> list = new ArrayList<>();
//        while(k>0){
//         list.add(pq.remove().num);
//         k--;
//        }
//        Collections.sort(list);
//        return list;
//     }
// }