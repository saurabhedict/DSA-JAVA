// class Solution {
//     public boolean containsNearbyDuplicate(int[] nums, int k) {
//        int n = nums.length;
//        int i = 0;
//        int j = n-1;
//        if(nums.length > k) j = k;
//        HashMap<Integer, Integer> map = new HashMap<>();

//        for(int x = i; x<=j; x++){
//         if(!map.containsKey(nums[x])) map.put(nums[x], x);
//         else{
//             int first = map.get(nums[x]);
//             int second = x;
//             if(Math.abs(first-second) <= k ) return true;
//             map.put(nums[x], second);
//         }
//        }

//        while(j<n){
//            map.remove(nums[i]);
//            i++;
//            j++;
//            if(j<n){
//             if(!map.containsKey(nums[j]))  map.put(nums[j], j);
//             else{
//                 int first = map.get(nums[j]);
//                 int second = j;
//                 if(Math.abs(first-second) <= k) return true;
//                 map.put(nums[j], second);
//             }
//            }
//        }
//        return false;
//     }
// }




// class Solution {
//     public boolean containsNearbyDuplicate(int[] nums, int k) {
//        int n = nums.length;
//        HashSet<Integer> set = new HashSet<>();

//        for(int i = 0; i<n; i++){
//         if(set.contains(nums[i])) return true;
//         set.add(nums[i]);
//         if(set.size() > k) set.remove(nums[i-k]);
//        }
//        return false;
//     }
// }




class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
       int n = nums.length;
       HashMap<Integer, Integer> map = new HashMap<>();

       for(int i = 0; i<n; i++){
         if(!map.containsKey(nums[i])) map.put(nums[i], i);
         else{
            int first = map.get(nums[i]);
            int second = i;
            if(Math.abs(second-first) <= k) return true;
            map.put(nums[i], i);
         }
       }
       return false;
    }
}