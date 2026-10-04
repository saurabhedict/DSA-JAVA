// class Solution {
//     public int subarraySum(int[] nums, int k) {
//         int count = 0;
//         for(int i = 0; i<=nums.length-1; i++){
//             int sum = 0;
//             for(int j = i; j<=nums.length-1; j++){
//                 sum += nums[j];
//                 if(sum == k) count++; 
//             }
//         }
//         return count;
//     }
// }//Brute Force : O(n2)




class Solution {
      public int subarraySum(int[] nums, int k) {
       int count = 0;
       int n = nums.length;
       for(int i = 1; i < n; i++)
       {
           nums[i] += nums[i-1];
       }

       HashMap<Integer,Integer> map = new HashMap<>();
       for(int i = 0; i<n; i++)
       {
            if(nums[i] == k) count++;
          
            int rem = nums[i] - k;
            if(map.containsKey(rem)) count += map.get(rem);
            
            if(map.containsKey(nums[i]))
            {
                int freq = map.get(nums[i]);
                map.put(nums[i],freq+1);
            }
            else map.put(nums[i],1);     
       }

       return count;
    }
}
