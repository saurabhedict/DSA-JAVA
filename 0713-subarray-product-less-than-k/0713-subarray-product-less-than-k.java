class Solution {
  public int numSubarrayProductLessThanK(int[] nums, int k) {
    if(k<=1) return 0;
    int n = nums.length;
    int i = 0, j = 0;
    int prod = 1, count = 0;

    for(j = 0; j<n; j++){
        prod *= nums[j];
        if(prod >= k) break;
        count += j-i+1;
    }
    if(prod >= k){
        prod /= nums[j];
        j--;
    }
    else return count;

    while(j<n){
        j++;
        if(j<n){
            prod *= nums[j];
            if(prod >= k){
                while(prod>=k){
                    prod /= nums[i];
                    i++;
                }
            }

        count += j-i+1;
        }
    }
    return count;
}
}