class Solution {
    public String removeDuplicates(String s) {
        int n = 0;
        Stack<Character> st = new Stack<>();
        Stack<Character> helper = new Stack<>();
        String ans = "";
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

        while(!st.isEmpty()){
           helper.push(st.pop());
        }

        while(!helper.isEmpty()){
            ans += helper.pop();
        }

        return ans;
    }
}