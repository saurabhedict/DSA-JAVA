// class Solution {
//     public int[] dailyTemperatures(int[] temperatures) {
//         int n = temperatures.length;
//         int[] ans = new int[n];

//         for(int i = 0; i<n; i++){
//             for(int j = i+1; j<n; j++){
//                 if(temperatures[j] > temperatures[i]) {
//                     int count = j - i;
//                     ans[i] = count;
//                     break;
//                 }
//             }
//         }
//         return ans;
//     }
// }//brute force 



class Solution {
    class Pair {
    int val;
    int idx;

    Pair(int val, int idx) {
        this.val = val;
        this.idx = idx;
    }
    }
    public int[] dailyTemperatures(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];

        Stack<Pair> st = new Stack<>();
        int i = 0;
        while(i<n){
            if(st.isEmpty()){
                st.push(new Pair(arr[i], i));
                i++;
            }
            while(i<n && !st.isEmpty() && st.peek().val < arr[i]){
              Pair x = st.pop();
              ans[x.idx] = i-x.idx;
              if(!st.isEmpty() && st.peek().val >= arr[i])st.push(new Pair(arr[i], i));
            }
            if(i<n)st.push(new Pair(arr[i], i));
            i++;

                 
        }
        
        return ans;
    }
}