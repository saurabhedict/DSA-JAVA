class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2*n];
        int i = 0;
        for(; i<n; i++){
          ans[i] = nums[i];
        }
        for(;i<2*n;i++){
            ans[i] = nums[i-n];
        }
        return ans;
    }
}