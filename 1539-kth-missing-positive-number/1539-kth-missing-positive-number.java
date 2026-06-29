class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        if(n == 1 ) {
            if(k>=arr[0]) return k + 1;
            else return k;
        }
        int lo = 0, hi = n-1;
        int missing = 0, ans = 0;
        while(lo<=hi){
            int mid = lo + (hi-lo)/2;
            missing = arr[mid]-(mid+1);
            if(missing < k) lo = mid + 1;            
            else hi = mid - 1;
        }
        if(hi<0) return k;
        else{
            int prevMissing = arr[hi] - (hi+1);
            int count = k - prevMissing;
            ans = arr[hi] + count;
        }
        return ans;
    }
}