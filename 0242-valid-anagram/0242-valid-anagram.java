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



// class Solution {
//     public boolean isAnagram(String s, String t) {
//         if(s.length() != t.length()) return false;

//         HashMap<Character, Integer> Smap = new HashMap<>();
//         HashMap<Character, Integer> Tmap = new HashMap<>();

//         for(int i = 0; i<s.length(); i++){
//             char key = s.charAt(i);
//             if(Smap.containsKey(key)){
//                 int val = Smap.get(key);
//                 Smap.put(key, val+1);
//             }
//             else Smap.put(key, 1);
//         }

//         for(int i = 0; i<t.length(); i++){
//             char key = t.charAt(i);
//             if(Tmap.containsKey(key)){
//                 int val = Tmap.get(key);
//                 Tmap.put(key, val+1);
//             }
//             else Tmap.put(key, 1);
//         }

//         for(char key : Smap.keySet()){
//             if(!Tmap.containsKey(key)) return false;
//             if(!Smap.get(key).equals(Tmap.get(key))) return false;
//         }
//         return true;
        
//     }
// }


// //For some values, Java compares the object references, not the actual numbers.

// This usually works for small integers because Java caches Integer objects from -128 to 127.

// But your test case has a very long string, so some character frequencies are probably greater than 127.

// For example:

// Integer a = 200;
// Integer b = 200;

// System.out.println(a == b); // false

// Even though:

// a = 200
// b = 200

// they are different Integer objects.





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
            int val1 = Smap.get(key);
            int val2 = Tmap.get(key);
            if(val1 != val2) return false;
        }
        return true;
        
    }
}
