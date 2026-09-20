// class Solution {
//     public List<Integer> majorityElement(int[] nums) {
//         List<Integer> ans = new ArrayList<>();
//         if(nums.length == 1) {
//             ans.add(nums[0]);
//             return ans;
//         }
//         if(nums.length == 2){
//             if(nums[0] != nums[1]){
//                 ans.add(nums[0]);
//                 ans.add(nums[1]);
//                 return ans;
//             }
//         }
//         HashMap<Integer, Integer> map = new HashMap<>();
//         HashSet<Integer> set = new HashSet<>();

//         for(int ele : nums){
//             if(map.containsKey(ele)){
//                 int val = map.get(ele);
//                 val = val+1;
//                 if(val > nums.length/3) set.add(ele);
//                 map.put(ele, val);
//             }
//            else map.put(ele, 1);
//         }

//         for (int ele : set) {
//          ans.add(ele);
//         }
//         return ans;
//     }
// }




class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();

        for(int ele : nums){
            if(map.containsKey(ele)){
                int val = map.get(ele);
                val = val+1;
                if(val > nums.length/3) set.add(ele);
                map.put(ele, val);
            }
           else {
            map.put(ele, 1);
            if(1 > nums.length/3) set.add(ele);
            }
        }

        for (int ele : set) {
         ans.add(ele);
        }
        return ans;
    }
}