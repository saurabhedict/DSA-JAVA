class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int a = 0, b = 0, i = 0, j = 0;
        int kCount = 0;

        //initial configuration of first window
        while(i<n && nums[i]%2 == 0) i++;
        while(j<n && kCount < k){
            if(nums[j]%2 != 0) kCount++;
            j++;
        }
        j--;
        if(kCount < k) return 0; //edge case
        
        b = j+1;
        while(b<n && nums[b]%2 == 0) b++;
        b--;

        int count   = 0;

        //sliding window
        while(b<n){ 
            count += (i-a+1)*(b-j+1);

            a = i + 1;
            i++;
            while(i<n && nums[i]%2 == 0) i++;

            j = b + 1;
            b = j + 1;
            while(b<n && nums[b]%2 == 0) b++;
            b--;
        }

        return count;
    }
}