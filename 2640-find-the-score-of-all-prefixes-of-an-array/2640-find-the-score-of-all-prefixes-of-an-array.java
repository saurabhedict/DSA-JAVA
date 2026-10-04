class Solution {
    public long[] findPrefixScore(int[] nums) {
        int n = nums.length;
        long[] conver = new long[n];
        conver[0] = nums[0];
        int max = nums[0];
        for(int i = 0; i<n; i++){
            max = Math.max(max, nums[i]);
            conver[i] = nums[i] + max;
        }
        for(int i = 1; i<n; i++){
            conver[i] += conver[i-1];
        }
        return conver;
    }
}