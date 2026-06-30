class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>(); 
        Parenthesis(n, ans, "",0, 0);
        return ans;
    }
    public void Parenthesis(int n,List<String> ans, String x, int open, int close){
        if(x.length() == 2*n) {
            ans.add(x);
            return;
        };
        if(open<n) Parenthesis(n,ans, x+"(", open+1, close);
        if(close<open) Parenthesis(n,ans, x+")",open, close+1);
    }
}