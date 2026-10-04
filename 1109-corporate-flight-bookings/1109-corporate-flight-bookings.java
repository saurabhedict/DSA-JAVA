// class Solution {
//     public int[] corpFlightBookings(int[][] bookings, int n) {
//         int[] ans = new int[n]; //suppose idx starts from 1

//         for(int i = 0; i<bookings.length; i++){
//             int[] arr = bookings[i];

//             for(int j = arr[0]-1; j<=arr[1]-1; j++){
//                 ans[j] += arr[2];
//             }
//         }

//         return ans;

//     }
// }



class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n]; //suppose idx starts from 1
        
        for(int i = 0; i<bookings.length; i++){
            int first = bookings[i][0];
            int last  = bookings[i][1];
            int val = bookings[i][2];

            ans[first-1] += val;
            if(last < n) ans[last] += -1 * val;
        }

        for(int i = 1; i<n; i++){
            ans[i] += ans[i-1];
        }
        return ans;

    }
}