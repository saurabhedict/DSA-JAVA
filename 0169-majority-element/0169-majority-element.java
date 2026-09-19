class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int ele : nums){
            if(map.containsKey(ele)){
                int val = map.get(ele);
                map.put(ele, val+1);
            }
            else{
                map.put(ele, 1);
            }
        }
        for(int i = 0; i<nums.length; i++){
            int val = map.get(nums[i]);
            if(val > nums.length/2) return nums[i];
        }
        return -1;
    }
}