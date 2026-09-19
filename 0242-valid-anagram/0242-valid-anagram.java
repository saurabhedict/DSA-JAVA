// class Solution {
//     public boolean isAnagram(String s, String t) {
        
//         char[] ch = s.toCharArray();
//         char[] kh = t.toCharArray();

//         Arrays.sort(ch);
//         Arrays.sort(kh);

//         if(ch.length != kh.length) return false;
//         for(int i = 0; i<ch.length; i++){
//             if(ch[i] != kh[i]) return false;
//         }

//         return true;
//     }
// }



class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        HashMap<Character, Integer> Smap = new HashMap<>();
        HashMap<Character, Integer> Tmap = new HashMap<>();

        for(int i = 0; i<s.length(); i++){
            char key = s.charAt(i);
            if(Smap.containsKey(key)){
                int val = Smap.get(key);
                Smap.put(key, val+1);
            }
            else Smap.put(key, 1);
        }

        for(int i = 0; i<t.length(); i++){
            char key = t.charAt(i);
            if(Tmap.containsKey(key)){
                int val = Tmap.get(key);
                Tmap.put(key, val+1);
            }
            else Tmap.put(key, 1);
        }

        for(char key : Smap.keySet()){
            if(!Tmap.containsKey(key)) return false;
            if(!Smap.get(key).equals(Tmap.get(key))) return false;
        }
        return true;
        
    }
}