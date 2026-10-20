class Solution {
    public int mostFreqChar(HashMap<Character, Integer> map){
        int max = Integer.MIN_VALUE;
        for(char ele : map.keySet()){
            max = Math.max(max, map.get(ele));
        }
        return max;
    }

    public int characterReplacement(String s, int k) {
        int n = s.length();
        int i = 0, j = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int result = Integer.MIN_VALUE;

        while(j<n){
         char ch = s.charAt(j);

         if(map.containsKey(ch)){
            int freq = map.get(ch);
            map.put(ch, freq+1);
         }
         else map.put(ch, 1);

         int len = j-i+1;
         int mostFreq = mostFreqChar(map);

         if(len-mostFreq <= k){
            result = Math.max(result, len);
         }

         else{
            while(len-mostFreq > k){
               int freq = map.get(s.charAt(i));
               map.put(s.charAt(i), freq-1);
               i++;
               //new window gets formed
               len = j-i+1;
               mostFreq = mostFreqChar(map);
            }
            //valid window
            result = Math.max(result, len);
         }

         j++;
        }

        return result;
    }
} //O(26*N)




// class Solution {
//     public int mostFreqChar(HashMap<Character, Integer> map){
//         int max = Integer.MIN_VALUE;
//         for(char ele : map.keySet()){
//             max = Math.max(max, map.get(ele));
//         }
//         return max;
//     }

//     public int characterReplacement(String s, int k) {
//         int n = s.length();
//         int i = 0, j = 0;
//         HashMap<Character, Integer> map = new HashMap<>();
//         int result = Integer.MIN_VALUE;
//         while(j<n){
//          char ch = s.charAt(j);
//          if(map.containsKey(ch)){
//             int freq = map.get(ch);
//             map.put(ch, freq+1);
//          }
//          else map.put(ch, 1);

//          int len = j-i+1;
//          int mostFreq = mostFreqChar(map);
//          if(len-mostFreq <= k){
//             result = Math.max(result, len);
//          }
//          else{
//             int freq = map.get(s.charAt(i));
//             map.put(s.charAt(i), freq-1);
//             i++;  
//          }
//          j++;
//         }

//         return result;
//     }
// } //O(26*N)



// class Solution {
//     public int characterReplacement(String s, int k) {
//         int n = s.length();
//         int i = 0, j = 0;
//         int maxF = Integer.MIN_VALUE;
//         HashMap<Character, Integer> map = new HashMap<>();
//         int result = Integer.MIN_VALUE;
//         while(j<n){
//          char ch = s.charAt(j);
//          if(map.containsKey(ch)){
//             int freq = map.get(ch);
//             map.put(ch, freq+1);
//             maxF = Math.max(maxF, freq+1);
//          }
//          else{
//             map.put(ch, 1);
//             maxF = Math.max(maxF, 1);
//          }

//          int len = j-i+1;
//          if(len-maxF <= k){
//             result = Math.max(result, len);
//          }
//          else{
//             int freq = map.get(s.charAt(i));
//             map.put(s.charAt(i), freq-1);
//             i++;  
//          }
//          j++;
//         }

//         return result;
//     }
// } //O(N) : Tricky