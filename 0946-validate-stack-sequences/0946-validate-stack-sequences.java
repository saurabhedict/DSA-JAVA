class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack <Integer> st = new Stack<>();
        int n1 = pushed.length;
        int x = 0;
        int y = 0;
        while(y<n1 && x<n1){
            st.push(pushed[x]);
            while(!st.isEmpty() && y<n1 && (popped[y] == st.peek())){
                st.pop();
                y++;
            }
            x++;
           }

         return st.isEmpty();
        }
    }
