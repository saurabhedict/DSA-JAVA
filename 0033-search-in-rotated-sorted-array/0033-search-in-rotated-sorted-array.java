// class Solution {
//     public int search(int[] nums, int target) {
//         int n = nums.length;
//         int lo = 0;
//         int hi = n-1;
//         int pivot = -1;

//         if(n < 3){
//             for(int i = 0; i<n; i++){
//                 if(nums[i] == target) return i;
//             }
//         }

//         while(lo<=hi){
//             int mid = lo + (hi-lo)/2;
//             if((mid+1<n && mid-1>=0) && (nums[mid]<nums[mid+1] && nums[mid]<nums[mid-1])){
//                 pivot = mid;
//                 break;
//             }
//             else if((mid+1<n && mid-1>=0) && (nums[mid]>nums[mid+1] && nums[mid]>nums[mid-1])){
//                 pivot = mid+1;
//                 break;
//             }
//             else{
//                 if(nums[mid]>nums[n-1]) lo = mid + 1;
//                 else hi = mid - 1;
//             }
//             }
            

//             if(pivot == -1){
//               return bs(nums,target,lo,n-1);
//             }

//        else{ 
//          int left =  bs(nums,target,0,pivot-1);
//          if(left != -1) return left;
//          int right = bs(nums,target,pivot,n-1);
//          return right;
//        }
//     }

//     public int bs(int[] nums, int target, int lo, int hi){
//           while(lo<=hi){
//             int mid = lo + (hi-lo)/2;
//             if(nums[mid]  == target) return mid;
//             if(nums[mid] > target) hi =  mid-1;
//             else lo = mid + 1;
//         }
//         return -1;
//     }
// }




class Solution {
    public int search(int[] nums, int target) {
    int n = nums.length;
    int lo = 0;
    int hi = n-1;

    while(lo<=hi){
        int mid = lo + (hi-lo)/2;

        if(nums[mid] == target) return mid;
        else if(nums[mid]<=nums[hi]){
            if(target>nums[mid] && target<=nums[hi]) lo = mid+1;
            else hi = mid -1;
        }
        else{
            if(target>=nums[lo] && target<nums[mid]) hi = mid-1;
            else lo = mid + 1;
        }
    }
    return -1;
      
}
}