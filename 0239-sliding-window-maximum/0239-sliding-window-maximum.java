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
            while(deque.size() > 0 && nums[i] > nums[deque.peekFirst()]){
                deque.removeFirst();
            }//i am trying to maintain Monotonically Decreasing order inside Deque, that's why i am removing smaller elements from front of deque

            deque.addFirst(i);
            if(i >= k-1) ans.add(nums[deque.peekLast()]); //I want maximum element of every window, which is maintained in last of Deque, that's why i am adding the element inside ans From Last of deque
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