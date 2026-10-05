class Solution {
    public void swap(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for(int i = 0; i<n; i++){
            if((nums[i] < 1 || nums[i] > n) || nums[i] == i+1) continue;
            
            while(nums[i] != i+1){
                if((nums[i] < 1 || nums[i] > n) || nums[i] == i+1) break;
                if(nums[nums[i]-1] != nums[i]) swap(i, nums[i]-1, nums);
                else break;
            }
        }

        int ans = Integer.MAX_VALUE;

        for(int i = 0; i<n; i++){
            if(nums[i] != i+1) ans = Math.min(ans, i+1);
        }

        if(ans ==  Integer.MAX_VALUE) return n+1;
        else return ans;
    }
}