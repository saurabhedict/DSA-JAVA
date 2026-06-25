// class Solution {
//     public int mySqrt(int x) {
//         int lo = 0;
//         int hi = x;
//         int mid  = 0;

//         while(lo<=hi){
//             mid = lo + (hi-lo)/2;
//             if(mid*mid > x) {
//                 hi = mid - 1;
//             }
//             else if(mid*mid < x) {
//                 lo = mid + 1;
//             }
//             else return mid;
//         }
//         return hi;
//     }
// } //computation problem

// class Solution {
//     public int mySqrt(int x) {
//         if(x <= 1) return x;
//         int lo = 0;
//         int hi = x;
//         int mid  = 0;
        
//         while(lo<=hi){
//             mid = lo + (hi-lo)/2;
//             if(mid > x/mid) {
//                 hi = mid - 1;
//             }
//             else if(mid < x/mid) {
//                 lo = mid + 1;
//             }
//             else return mid;
//         }
//         return hi;
//     }
// }





class Solution {
    public int mySqrt(int x) {
        long lo = 0;
        long hi = (long)x;
        long mid  = 0;
        
        while(lo<=hi){
            mid = lo + (hi-lo)/2;
            if(mid*mid > (long)x) {
                hi = mid - 1;
            }
            else if(mid*mid < (long)x) {
                lo = mid + 1;
            }
            else return (int)mid;
        }
        return (int)hi;
    }
}//type casting