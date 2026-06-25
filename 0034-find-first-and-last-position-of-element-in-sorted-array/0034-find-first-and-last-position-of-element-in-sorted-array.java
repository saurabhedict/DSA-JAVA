// class Solution {
//     public int[] searchRange(int[] nums, int target) {
//         int[] arr = {-1, -1};
//         int n = nums.length;
//         int lo = 0;
//         int hi = n-1;
//         int lb = n;
//         int ub = n;

//         boolean flag = false;

//         while(lo<=hi){
//             int mid = lo+(hi-lo)/2;

//             if(nums[mid]>=target) {
//             hi = mid-1;
//             lb = Math.min(mid,lb);
//             if(nums[mid]==target) flag = true;
//             }
//             else lo = mid+1;
//         }

//          lo = 0;
//          hi = n-1;
//          while(lo<=hi){
//             int mid = lo+(hi-lo)/2;

//             if(nums[mid]>target) {
//             hi = mid-1;
//             ub = Math.min(mid,ub);
//             }
//             else lo = mid+1;
//         }

//         int[] ans = {lb, ub-1};
//         if(flag == false) return arr;
//         else return ans;

        
//     }
// }




class Solution {
    public int[] searchRange(int[] nums, int target) {
       int n = nums.length;
       int lo = 0;
       int hi = n-1;
       int fp = -1;
       int lp = -1;
       while(lo<=hi){
        int mid = lo + (hi-lo)/2;
        if(nums[mid] == target){
            if(mid > 0 && nums[mid] ==  nums[mid-1]){
                hi = mid -1;
            }
            else{
                 fp = mid;
                break;
            }
        }
        else if(nums[mid] > target) hi =  mid-1;
        else lo = mid+1;
        }

        lo = 0;
        hi = n-1;
        while(lo<=hi){
        int mid = lo + (hi-lo)/2;
        if(nums[mid] == target){
            if(mid+1< n && nums[mid] ==  nums[mid+1]){
                lo = mid + 1;
            }
            else{
                 lp = mid;
                break;
            }
        }
        else if(nums[mid] > target) hi =  mid-1;
        else lo = mid+1;
        }
        
        int ans[] = {fp,lp};
        return ans;
    }
}