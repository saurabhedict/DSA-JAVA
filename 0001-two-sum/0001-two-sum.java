// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         int n = nums.length;
//         int[] ans = {-1, -1};
//         boolean flag = false;
//         for(int i = 0; i<n; i++){
//             for(int j = i+1; j<n; j++){
//                 if(nums[i] + nums[j] == target){
//                     ans[0] = i;
//                     ans[1] = j;
//                     flag = true;
//                     break;
//                 }
//             }
//             if(flag == true) break;
//         }
//         return ans;
//     }
// }




class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = {-1, -1};
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            int rem = target-nums[i];
            if(map.containsKey(rem)){
                ans[0] = map.get(rem);
                ans[1] = i;
                return ans;
            }
            else map.put(nums[i], i);
        }
        return ans;
    }
}