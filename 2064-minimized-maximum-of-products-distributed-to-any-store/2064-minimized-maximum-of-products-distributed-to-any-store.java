class Solution {
    public int minimizedMaximum(int x, int[] nums) {
        int n = nums.length;
        int lo = 1;
        int hi = Integer.MIN_VALUE;
        long Prosum = 0;
        for(int i = 0; i<n; i++){
            hi = Math.max(hi,nums[i]);
            Prosum += nums[i];
        }
        int ans = hi;
        if(x == 1) return ans;

       while(lo<=hi){
        int mid = lo + (hi-lo)/2;
        int stores = x;
        int i = 0;
        long sum = Prosum;
        while(stores>0 && i<n && sum>0){
           int pro = nums[i];
           while(pro>0 && stores>0){
            if(pro >= mid){
                 pro = pro - mid;
                 sum = sum - mid;
            }
            else {
                sum = sum - pro;
                pro = 0;
            }
            stores--;
           }
           i++;
        }

        if(sum>0){
            lo = mid + 1;
        }
        else{
            ans = Math.min(mid,ans);
            hi = mid - 1;
        }
       }
       return ans;

    }
}