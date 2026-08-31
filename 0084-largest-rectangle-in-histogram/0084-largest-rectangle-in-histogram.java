class Solution {
    public void NextSmallestLeft(int[] arr, int[] NSL, int n){
       Stack<Integer> st = new Stack<>();
       for(int i = 0; i < n; i++){
        if(st.isEmpty()) NSL[i] = -1;
        else{
            while(!st.isEmpty() && (arr[st.peek()]) >= (arr[i])){
                st.pop();
            }
            if(st.isEmpty()) NSL[i] = -1;
            else NSL[i] = st.peek();
        }
        st.push(i);
       }
    }
    public void NextSmallestRight(int[] arr, int[] NSR, int n){
       Stack<Integer> st = new Stack<>();
       for(int i = n-1; i >=0; i--){
        if(st.isEmpty()) NSR[i] = n;
        else{
            while(!st.isEmpty() && (arr[st.peek()]) >= (arr[i])){
                st.pop();
            }
            if(st.isEmpty()) NSR[i] = n;
            else NSR[i] = st.peek();
        }
        st.push(i);
       }
    }
    public int[] Calculatewidth(int[] arr, int n){
        int[] brr = new int[n];
        int[] NSL = new int[n];
        int[] NSR = new int[n];
        NextSmallestLeft(arr, NSL, n);
        NextSmallestRight(arr, NSR, n);
        for(int i = 0; i<n; i++){
            brr[i] = (NSR[i] - NSL[i] - 1);
        }

        return brr;
    }
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int ans = -1;
        int[] width = Calculatewidth(heights, n);
        for(int i = 0; i<n; i++){
            int area = heights[i]*width[i];
            ans = Math.max(area, ans);
        }
        return ans;

    }
}