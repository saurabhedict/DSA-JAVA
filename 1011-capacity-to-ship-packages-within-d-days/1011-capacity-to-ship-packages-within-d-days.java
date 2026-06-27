class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int sumWeights =  0;
        int maxWeights = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            sumWeights += weights[i];
            maxWeights = Math.max(maxWeights, weights[i]);
        }
          int minCap = sumWeights;

        int lo = maxWeights;
        int hi = minCap;
        while(lo<=hi){
            int mid = lo + (hi-lo)/2;
            int d = days;
            int i = 0;
            while(d>0 && i<n){
                int sum = 0;
              while(sum<mid && i<n){
                sum+= weights[i];
                i++;
                if(sum>=mid) break;
              }
             
              if(sum>mid)
              {
                 i--;
                 sum = sum - weights[i];
              }
              d--;

            }
            if(i==n){
                minCap = Math.min(minCap,mid);
                hi = mid-1;
            }
            
            else{
                lo = mid + 1;
            }

        }
        return minCap;
    }
}