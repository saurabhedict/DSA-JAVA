// class Solution {
//     public int lengthOfLongestSubstring(String s) {
        
//         int max = Integer.MIN_VALUE;
//         HashMap<Character, Integer> map = new HashMap<>();
        
//         for(int i = 0;  i<s.length(); i++){
//             for(int  j = i; j<s.length(); j++){
//             char ch = s.charAt(j);
//             if(map.containsKey(ch)){
//              max = Math.max(max, map.size());
//              map.clear();
//              map.put(ch, 1);
//             }
//             else {
//                 map.put(ch, 1);
//                 max = Math.max(max, map.size());
//             }
//             }
//             map.clear();
//         }
//         return max;
//     }
// } //O(n2) : Brute Force




// class Solution {
//     public int lengthOfLongestSubstring(String s) {
        
//         int max = Integer.MIN_VALUE;
//         HashMap<Character, Integer> map = new HashMap<>();
        
//         int i = 0;
//         int j = i;
//         while(j<s.length()){
//             char ch = s.charAt(j);
//             if(map.containsKey(ch)){
//                 if(i > map.get(ch)){
//                     map.put(ch, j);
//                     max = Math.max(max, j-i);
//                 }
//                 else{
//                 max = Math.max(max, j-i);
//                 i = map.get(ch) + 1;
//                 map.remove(ch);
//                 map.put(ch, j);
//                 }
//             }
//             else {
//                 map.put(ch, j);
//                 max = Math.max(max, j-i+1);
//             }
//             j++;
//         }
//         max = Math.max(max, j-i);
//         return max;
//     }
// } 




class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = i; //sliding window
        while(j<s.length()){
            char ch = s.charAt(j);
            if(map.containsKey(ch) && i <= map.get(ch)) i = map.get(ch) + 1;
            map.put(ch, j);
            max = Math.max(max, j-i+1);
            j++;
        }
        return max;
    }
} 