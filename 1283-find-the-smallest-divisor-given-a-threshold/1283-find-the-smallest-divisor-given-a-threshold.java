// class Solution {
//     public int smallestDivisor(int[] nums, int threshold) {
//         int n = nums.length;
//         int mx = Integer.MIN_VALUE;
//         for(int i = 0; i<n; i++){
//            mx = Math.max(mx, nums[i]);
//         }
//         for(int d = 1; d<=mx; d++){
//             int sum = 0;
//             for(int i = 0; i<n; i++){
//                 if(nums[i]%d == 0) sum += nums[i]/d;
//                 else sum += nums[i]/d + 1;
//             }
//             if(sum<=threshold) return d;
//         }
//         return 0;
//     }   

// }



class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int mx = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
           mx = Math.max(mx, nums[i]);
        }
        int lo = 1;
        int hi = mx;
        int ans = mx;

        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            int sum = 0;
            for(int i = 0; i<n; i++){
                if(nums[i]%mid == 0) sum += nums[i]/mid;
                else sum += nums[i]/mid + 1;
            }
            if(sum>threshold){
                lo = mid+1;
            }
            if(sum<=threshold){
                ans = Math.min(ans,mid);
                hi = mid - 1;
            }
            
        }
        return ans;
    }   

}