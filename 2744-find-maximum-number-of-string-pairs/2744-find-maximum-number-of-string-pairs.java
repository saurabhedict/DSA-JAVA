class Solution {
    public String reverse(String s){
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return sb.toString();
    }
    public int maximumNumberOfStringPairs(String[] words) {
        HashSet<String> set = new HashSet<>();
        
        int count = 0;
        for(String key : words){
            String rev = reverse(key);
            if(set.contains(rev)){
                count++;
                set.remove(rev); //understand why : not imp here but for some test cases it needed
            }
            else set.add(key);
        }
        return count;
    }
}