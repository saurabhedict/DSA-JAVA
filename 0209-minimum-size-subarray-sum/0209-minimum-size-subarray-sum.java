// class Solution {
//     public int minSubArrayLen(int target, int[] nums) {
//         int n = nums.length;
//         int minLength = Integer.MAX_VALUE;
//         int sum = 0;
//         for(int i = 0; i<n; i++){
//             for(int j = i; j<n; j++){
//                  sum += nums[j];
//                  if(sum >= target){
//                     minLength =  Math.min(minLength, j-i+1);
//                     break;
//                  }
//             }
//             sum = 0;
//         }
//         if(minLength ==  Integer.MAX_VALUE) return 0;
//         else return minLength;
//     }
// }



class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        int i = 0;
        int j = 0;
        for(j = 0; j<n; j++){
            sum += nums[j];
            if(sum >= target) break;
        }
        if(sum >= target) minLength = Math.min(minLength, j-i+1);
        else return 0;
        while(j<n){
           i++;
           sum -= nums[i-1];
           if(sum >= target) minLength = Math.min(minLength, j-i+1);

           while(j<n && sum<target){
             j++;
             if(j<n) sum += nums[j];
             else break;
           }
           if(sum >= target) minLength =  Math.min(minLength, j-i+1);
        }

        if(minLength == Integer.MAX_VALUE) return 0;
        else return minLength;
    }
}