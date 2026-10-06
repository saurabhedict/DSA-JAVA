class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int zeroes = 0, ones = 0;
        int i = 0, j = 0;
        int maxLen = Integer.MIN_VALUE;
        
        for(j = 0; j<n; j++){
            if(nums[j] == 1) ones++;
            if(nums[j] == 0) zeroes++;
            if(zeroes == 2) break;
        }
        
        if(zeroes == 2) zeroes--;
        j--;
        
        maxLen = Math.max(maxLen, ones+zeroes-1);

        while(j<n){
          j++;
          if(j<n && nums[j] == 1){
            ones++;
            maxLen = Math.max(maxLen, ones+zeroes-1);

          }
          else{
            if(j<n){
               zeroes++;
               if(zeroes == 2){
                while(zeroes>=2){
                    if(nums[i] == 1) ones--;
                    else zeroes--;
                    i++;
                }
                }
            }
          }

        }
        if(maxLen == Integer.MIN_VALUE) return 0;
        return maxLen;
    }
}