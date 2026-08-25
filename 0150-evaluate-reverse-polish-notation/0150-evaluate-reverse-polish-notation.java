class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens.length == 1) return Integer.parseInt(tokens[0]);
        Stack<String> st = new Stack<>();
        int x = 0;
        int n = tokens.length;
        while(x<n){
            String s = tokens[x];
           if(s.equals("+") ||  s.equals("-") || s.equals("*") || s.equals("/")){
               int b = Integer.parseInt(st.pop());
               int a = Integer.parseInt(st.pop());
               if(s.equals("+")) st.push((a + b) + "");
               if(s.equals("-")) st.push((a - b) + "");
               if(s.equals("*")) st.push((a * b) + "");
               if(s.equals("/")) st.push((a / b) + "");

           }
           else{
            st.push(s);
           }
           x++;
        }
        return Integer.parseInt(st.pop());
    }
}