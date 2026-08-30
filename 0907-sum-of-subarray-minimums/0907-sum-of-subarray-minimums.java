// class Solution {

//     public void LeftSmallestElment(int[] arr, int n, int[] LSE){
//         Stack<Integer> st = new Stack<>();
//         for(int i = 0; i<n; i++){
//          if(st.isEmpty()) LSE[i] = -1;
//          else{
//             while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
//             st.pop();
//          }
//          if(st.isEmpty()) LSE[i] = -1;
//          else LSE[i] = st.peek();
//          }
//          st.push(i);
//         }
//     }
//     public void RightSmallestElement(int[] arr, int n,int[] RSE){
//         Stack<Integer> st = new Stack<>();
//         for(int i = n-1; i>=0; i--){
//          if(st.isEmpty()) RSE[i] = n;
//         else{
//              while(!st.isEmpty() && arr[st.peek()]>arr[i]){
//             st.pop();
//          }
//          if(st.isEmpty()) RSE[i] = n;
//          else RSE[i] = st.peek();
//          }
//          st.push(i);
//     }
//     }
//     public int sumSubarrayMins(int[] arr) {
//         int n = arr.length;
//         int[] LSE = new int[n];
//         int[] RSE = new int[n];
        
//         LeftSmallestElment(arr, n, LSE);
//         RightSmallestElement(arr, n, RSE);

//         long sum1 = 0;
//         for(int i = 0; i<n; i++){
//             int left = i-LSE[i];
//             int right = RSE[i] - i;
//             sum1 = (long)(sum1 + (long)((long)(left*right)*(long)(arr[i])));
//         }
//         long M = (long)Math.pow(10,9) + 7;
//         int sum = (int)(sum1%M);

//         return sum;
//     }
// }



class Solution {

    public void LeftSmallestElment(int[] arr, int n, long[] LSE){
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<n; i++){
         if(st.isEmpty()) LSE[i] = -1;
         else{
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
            st.pop();
         }
         if(st.isEmpty()) LSE[i] = -1;
         else LSE[i] = st.peek();
         }
         st.push(i);
        }
    }
    public void RightSmallestElement(int[] arr, int n,long[] RSE){
        Stack<Integer> st = new Stack<>();
        for(int i = n-1; i>=0; i--){
         if(st.isEmpty()) RSE[i] = n;
        else{
             while(!st.isEmpty() && arr[st.peek()]>arr[i]){
            st.pop();
         }
         if(st.isEmpty()) RSE[i] = n;
         else RSE[i] = st.peek();
         }
         st.push(i);
    }
    }
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long[] LSE = new long[n];
        long[] RSE = new long[n];
        
        LeftSmallestElment(arr, n, LSE);
        RightSmallestElement(arr, n, RSE);

        long sum1 = 0;
        for(int i = 0; i<n; i++){
            long left = (long)i-LSE[i];
            long right = RSE[i] - (long)i;
            sum1 = (sum1 +((left*right)*(long)(arr[i])));
        }
        long M = (long)Math.pow(10,9) + 7;
        int sum = (int)(sum1%M);

        return sum;
    }
}