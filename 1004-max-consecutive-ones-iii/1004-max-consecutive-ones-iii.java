class Solution {
    public int longestOnes(int[] nums, int k) {
       int n = nums.length, maxLen = Integer.MIN_VALUE;
       int len = 0, i = 0, j = 0;
       int zeroes = 0, ones = 0;

       for(j = 0; j<n; j++){
         if(zeroes >= k) break;
         if(nums[j] == 0) zeroes++;
         if(nums[j] == 1) ones++;
       }
       j--;
       
       if(j>=n) return (zeroes + ones);
       maxLen = Math.max(zeroes+ones, maxLen);
       while(j<n){
          while(zeroes >k){
            if(nums[i] == 0) zeroes--;
            else ones--;
            i++;
          }

          j++;
          if(j<n){
            if(nums[j] == 0) zeroes++;
            else ones++;
          }
         if(zeroes<=k) maxLen = Math.max(zeroes+ones, maxLen);    
       }
       return maxLen;

    }
}