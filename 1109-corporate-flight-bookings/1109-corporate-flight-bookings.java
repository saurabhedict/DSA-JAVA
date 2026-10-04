class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n]; //suppose idx starts from 1

        for(int i = 0; i<bookings.length; i++){
            int[] arr = bookings[i];
            for(int j = arr[0]-1; j<=arr[1]-1; j++){
                ans[j] += arr[2];
            }
        }
        return ans;

    }
}