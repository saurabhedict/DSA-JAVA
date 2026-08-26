class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if(n == k) return "0";
        Stack<Integer> st = new Stack<>();

        int i = 0;
        while(i<n){
            int digit = Integer.parseInt(num.charAt(i) + "");
            while(!st.isEmpty() && digit < st.peek()){
                if(k>0){
                    st.pop();
                    k--;
                }
                else break;
            }
            if(st.size() > 0 || digit != 0) st.push(digit);
            i++;
        }

        if(k != 0){
            while(k>0 && !st.isEmpty()){
                st.pop();
                k--;
            }
        }
        if(st.size() == 0){
            return "0";
        }

        Stack<Integer> helper = new Stack<>();
        while(!st.isEmpty()){
            helper.push(st.pop());
        }
        String ans = "";
        while(!helper.isEmpty()){
            ans += helper.pop();
        }
        return ans;
    }
}