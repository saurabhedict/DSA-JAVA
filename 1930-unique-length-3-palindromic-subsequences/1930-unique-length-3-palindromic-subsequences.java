class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        HashMap<Character, Integer> first = new HashMap<>();
        HashMap<Character, Integer> last = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        int count = 0;

        for(int i = 0; i<n; i++){
           char ch = s.charAt(i);
           if(!first.containsKey(ch)){
            first.put(ch, i);
           }
           last.put(ch, i);
        }

        for(char key : first.keySet()){
           if(!(first.get(key) == last.get(key))){
             int start = first.get(key) + 1;
             int end = last.get(key) - 1;
             for(int i = start; i<=end; i++){
                set.add(s.charAt(i));
             }
             count += set.size();
             set.clear();
           }
        }
        return count;
    }
}