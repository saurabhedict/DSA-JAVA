class Solution {
    public int reverse(int num){
        int ans = 0;
        while(num > 0){
            ans *= 10;
            ans += num%10;
            num = num/10;
        }
        return ans;
    }
    public int countDistinctIntegers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int ele : nums){
            int rev = reverse(ele);
            set.add(ele);
            set.add(rev);
        }
        return set.size();
    }
}