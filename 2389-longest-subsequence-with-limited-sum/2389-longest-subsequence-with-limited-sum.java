class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int n = nums.length;
        Arrays.sort(nums);

        for(int i = 1; i<n; i++){
            nums[i] += nums[i-1];
        }


        for(int i = 0; i<queries.length; i++){
            int lo = 0;
            int hi = n-1;
            int ele = queries[i];
            queries[i] = 0;

            while(lo<=hi){
                int mid = lo + (hi-lo)/2;
                if(nums[mid] > ele) hi = mid - 1;
                else{
                    queries[i] = Math.max(queries[i], mid+1);
                    lo = mid + 1;
                }
            }

        }
        return queries;
    }
}