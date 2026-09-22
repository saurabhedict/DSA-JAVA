class Solution {
    public int rev(int num){
        int ans = 0;
        while(num>0){
            ans = ans*10;
            ans += num%10;
            num = num/10;
        } 
        return ans;
    }

    public int countNicePairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i<nums.length; i++){
            nums[i] = nums[i] - rev(nums[i]);
        }
        long count = 0;
        for(int ele : nums){
            if(map.containsKey(ele)){
                int freq = map.get(ele);
                count +=  freq;
                map.put(ele, freq+1);
            }
            else map.put(ele, 1);
        }
        return (int)(count % 1000000007L);

    }
}