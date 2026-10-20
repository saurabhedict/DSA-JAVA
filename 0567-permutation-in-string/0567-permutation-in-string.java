// class Solution {
//     public void copy(HashMap<Character, Integer> map1, HashMap<Character, Integer> map2){
//         for(char ele : map1.keySet()){
//             int freq = map1.get(ele);
//             map2.put(ele, freq);
//         }
//     }
//     public boolean checkInclusion(String s1, String s2) {
//         int n = s1.length();
//         HashMap<Character, Integer> map1 = new HashMap<>();
//         for(int i = 0; i<n; i++){
//             char ele = s1.charAt(i);
//             if(map1.containsKey(ele)){
//                 int freq = map1.get(ele);
//                 map1.put(ele, freq+1);
//             }
//             else map1.put(ele, 1);
//         }

//         for(int i = 0; i<s2.length(); i++){
//             char ch = s2.charAt(i);
//             if(!map1.containsKey(ch)) continue;
//             HashMap<Character, Integer> map2 = new HashMap<>();
//             copy(map1, map2);
//             int freq = map2.get(ch);
//             freq--;
//             if(freq == 0) map2.remove(ch);
//             else map2.put(ch, freq);
//             if(map2.size() == 0) return true;

//             for(int j = i+1; j<s2.length(); j++){
//                 char chh = s2.charAt(j);
//                 if(!map2.containsKey(chh)) break;
//                 int freqq = map2.get(chh);
//                 freqq--;
//                 if(freqq == 0) map2.remove(chh);
//                 else map2.put(chh, freqq);
//                 if(map2.size() == 0) return true;
//             }
//         }
//         return false;
//     }
// } //BF : TC :  O(n + m(n+m), SC : O(n)




// class Solution {
//     public boolean isAnagram(String s1, String s2){
//         char[] ch1 = s1.toCharArray();
//         char[] ch2 = s2.toCharArray();

//         Arrays.sort(ch1);
//         Arrays.sort(ch2);

//         String sorted1 = new String(ch1);
//         String sorted2 = new String(ch2);

//         return sorted1.equals(sorted2);
//     }
//     public boolean checkInclusion(String s1, String s2) {
//         int n = s1.length();
//         int m = s2.length();
        
//         int i = 0, j = 0;
//         while(j<m){
//             if(j-i+1 > n) i++;
//             if(j-i+1 == n){
//               boolean res = isAnagram(s1, s2.substring(i, j+1));
//               if(res) return res;
//             }
//             j++;
//         }
//         return false;
        
//     }
// }





class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        HashMap<Character, Integer> map1 = new HashMap<>();

        for(int i = 0; i<n; i++){
            char ch = s1.charAt(i);
            if(map1.containsKey(ch)){
                int freq = map1.get(ch);
                map1.put(ch, freq+1);
            }
            else map1.put(ch, 1);
        }

        HashMap<Character, Integer> map2 = new HashMap<>();
        
        int i = 0, j = 0;
        map2.put(s2.charAt(j), 1);
        while(j<m){
            if(j-i+1 > n){
                int freq = map2.get(s2.charAt(i));
                freq--;
                if(freq == 0) map2.remove(s2.charAt(i));
                else map2.put(s2.charAt(i), freq);
                i++;
            }
            if(j-i+1 == n){
              if(map1.equals(map2)) return true;
            }
            j++;
            if(j<m){ 
                if(map2.containsKey(s2.charAt(j))) {
                  int freq = map2.get(s2.charAt(j));
                  freq++;
                  map2.put(s2.charAt(j), freq);
            }
            else map2.put(s2.charAt(j), 1);
        }
        
    }
    return false;
}
}