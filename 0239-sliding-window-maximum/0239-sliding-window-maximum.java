class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        int i = 0;

        while(i<n){
            //check the window is valid for the currant Ith element or not
            while(deque.size()>0 && deque.peekLast() <= i-k){
                deque.removeLast();
            }
            
            //remove the small elements from thw window which can never be the answer
            while(deque.size() > 0 && nums[deque.peekFirst()] < nums[i]){
                deque.removeFirst();
            }
            
            deque.addFirst(i);
            if(i >= k-1) ans.add(nums[deque.peekLast()]);
            i++;
            
        }

        int m = ans.size();
        int[] arr = new int[m];
        for(int l = 0; l<m; l++){
             arr[l] = ans.get(l);
        }
        return arr;
    }
}