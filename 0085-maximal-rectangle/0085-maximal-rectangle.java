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
    public int maximalRectangle(char[][] matrix) {
        int n = matrix[0].length; //cols
        int m = matrix.length; //rows

        int ans = -1;
        int[] height = new int[n];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(matrix[i][j] == '1') height[j]++;
                else height[j] = 0;
            }
            int[] width = Calculatewidth(height, n);
            for(int k = 0; k<n; k++){
                int area = height[k]*width[k];
                ans = Math.max(area, ans);
            }
        }

        return ans;
    }
}