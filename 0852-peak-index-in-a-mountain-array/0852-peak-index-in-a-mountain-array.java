// class Solution {
//     public int peakIndexInMountainArray(int[] arr) {
        
//         int max = Integer.MIN_VALUE;
//         int maxI = -1;
//         int n = arr.length;
//         int lo = 0;
//         int hi = n-1;

//         while(lo<=hi){
//             int mid = lo + (hi-lo)/2;
//             if(mid+1 < n && arr[mid]>arr[mid+1]){
//                 if(arr[mid]>max) maxI = mid;
//                 max = Math.max(max, arr[mid]);
//                 hi = mid - 1;
    
//             }
//             else if(arr[mid] < arr[mid+1]){
//                 if(arr[mid]>max) maxI = mid;
//                 max = Math.max(max, arr[mid]);
//                 lo = mid + 1;
        
//             }
           
//         }

//         return maxI;
//     }
// }




class Solution {
    public int peakIndexInMountainArray(int[] arr) {
    
        int n = arr.length;
        int lo = 0;
        int hi = n-1;

        while(lo<=hi){
            int mid = lo + (hi-lo)/2;
            if(arr[mid]>arr[mid+1] && arr[mid]>arr[mid-1]){
                return mid;
    
            }
            else if(arr[mid] < arr[mid+1]){
               lo = mid + 1;
        
            }
            else hi = mid - 1;
           
        }

        return 0;
    }
}