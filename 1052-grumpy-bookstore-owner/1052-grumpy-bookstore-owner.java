class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = grumpy.length;
        int i = 0, j = minutes-1;
        int a = i, b = j;
        
        int unhappy = 0, maxUnhappy = Integer.MIN_VALUE;

        for(int k = i; k<=j; k++){
            if(grumpy[k] == 1) unhappy += customers[k];
        }
        maxUnhappy = Math.max(maxUnhappy, unhappy);

        while(j<n){
            i++;
            j++;
            if(grumpy[i-1] == 1) unhappy -= customers[i-1];
            if(j<n && grumpy[j] == 1) unhappy += customers[j];
            if(unhappy > maxUnhappy){
                a = i;
                b = j;
                maxUnhappy = Math.max(maxUnhappy, unhappy);
            }
        }

        for(int k = a; k<=b; k++){
            if(grumpy[k] == 1) grumpy[k] = 0;
        }

        int ans = 0;
        for(int k = 0; k<n; k++){
            if(grumpy[k] == 0) ans += customers[k];
        }
        return ans;

    }
}