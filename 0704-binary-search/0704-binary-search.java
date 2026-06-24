class Solution {
    public int search(int[] nums, int target) {
      int n = nums.length;
      boolean flag = false;
      int lo = 0;
      int hi = n-1;

      while(lo<=hi){
        int mid = (lo+hi)/2;
        if(nums[mid] == target){
            flag = true;
            return mid;
        }
        else if(nums[mid]<target) lo = mid+1;
        else hi = mid - 1;
      }

      if(flag == false) return -1;
      else return 0;
    }
}