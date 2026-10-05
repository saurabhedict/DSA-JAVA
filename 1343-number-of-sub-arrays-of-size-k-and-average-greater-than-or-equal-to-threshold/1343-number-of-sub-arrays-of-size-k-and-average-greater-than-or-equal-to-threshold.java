class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n = arr.length;
        int ans = 0;
        int i = 0;
        int j = k-1;
        int sum = 0;
        for(int a = 0; a<=j; a++){
            sum += arr[a];
        }
        if(sum/k >= threshold) ans++;
        i++;
        j++;
        while(j<n){
            sum = sum - arr[i-1] + arr[j];
            if(sum/k >= threshold) ans++;
            i++;
            j++;
        }
        return ans;
    }
}