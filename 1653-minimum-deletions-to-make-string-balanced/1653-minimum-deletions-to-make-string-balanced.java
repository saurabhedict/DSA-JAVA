class Solution {
    public int minimumDeletions(String s) {
        if(s.length() == 1) return 0;
        Stack<Character> st = new Stack<>();
        int x = 0;
        int count = 0;
        while(x<s.length()){
            if(!st.isEmpty() && (st.peek() == 'b' && s.charAt(x) == 'a')){
                st.pop();
                count++;
            }
            else{
               st.push(s.charAt(x));
            }
            x++;
        }
        return count;
    }
}