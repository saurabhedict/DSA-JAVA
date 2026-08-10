class Solution {
    public String removeDuplicates(String s) {
        int n = 0;
        Stack<Character> st = new Stack<>();
        while(n<s.length()){
            char ch = s.charAt(n);
            if(st.isEmpty()){
                st.push(ch);
            }
            else if(st.peek() != ch){
                st.push(ch);
            }
            else {
                st.pop();
            }
            n++;
        }

        String ans = "";
        Stack<Character> helper = new Stack<>();
        while(!st.isEmpty()){
           helper.push(st.pop());
        }
        while(!helper.isEmpty()){
            ans += helper.pop();
        }
        return ans;
    }
}