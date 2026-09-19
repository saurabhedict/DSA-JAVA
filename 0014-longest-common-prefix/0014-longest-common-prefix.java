class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String ans = "";
        String s1 = strs[0];
        String s2 = strs[strs.length-1];
        for(int i = 0; i<s1.length(); i++){
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            if(ch1 == ch2) ans += ch1;
            else break;
        }
        return ans;
    }
}