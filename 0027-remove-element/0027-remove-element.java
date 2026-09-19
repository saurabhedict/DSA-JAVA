class Solution {
    public void swap(int i, int j, int[] nums){
         int temp = nums[i];
         nums[i] = nums[j];
         nums[j] =  temp;
    }
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length-1;
        
        while(i<=j){
            if(nums[i] != val && nums[j] == val){
                j--;
            }
            else if(nums[i] == val && nums[j] != val){
                swap(i, j, nums);
                i++;
                j--;
            }
            else if(nums[i] == val && nums[j] == val){
                j--;
            }
            else{
                i++;
            }
        }

        int count = 0;
        for(int k = 0; k<nums.length; k++){
            if(nums[k] != val) count++;
        }
        return count;

    }
}