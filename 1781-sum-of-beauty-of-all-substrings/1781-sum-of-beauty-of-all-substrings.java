// class Solution {
//     public int[] prefixSum(String s, int i, int j, int n){
//       int[] arr = new int[n];
//       HashMap<Character, Integer> map = new HashMap<>();
//       for(int k = i; k<=j; k++){
//         char ch = s.charAt(k);
//         if(map.containsKey(ch)){
//             int freq = map.get(ch);
//             map.put(ch, freq+1);
//         }
//         else map.put(ch, 1);
//         arr[k] = map.get(ch);
//       }
//       return arr;
//     }
//     public int beauty(String s, int i, int j, int n){
//         int[] arr = prefixSum(s, i, j, n);
//         HashMap<Character, Integer> map = new HashMap<>();
//         for(int k = i; k<=j; k++){
//             char ch = s.charAt(k);
//             int num = arr[k];
//             map.put(ch, num); 
//         }
//         int min = Integer.MAX_VALUE;
//         int max = Integer.MIN_VALUE;
//         for(char key : map.keySet()){
//                 min = Math.min(min, map.get(key));
//                 max = Math.max(max, map.get(key));
//         }
//         map.clear();
//         return (max-min);
//     }
//     public int beautySum(String s) {
//         int n = s.length();
//         int count = 0;
//         for(int i = 0; i<s.length(); i++){
//             for(int j = i; j<s.length(); j++){
//                 count += beauty(s, i, j, n);
//             }
//         }
//         return count;
        
//     }
// } 




class Solution {
    public int[] prefixSum(String s, int i, int j, int n){
      int[] arr = new int[n];
      HashMap<Character, Integer> map = new HashMap<>();
      for(int k = i; k<=j; k++){
        char ch = s.charAt(k);
        if(map.containsKey(ch)){
            int freq = map.get(ch);
            map.put(ch, freq+1);
        }
        else map.put(ch, 1);
        arr[k] = map.get(ch);
      }
      return arr;
    }
    public int beauty(String s, int i, int j, HashMap<Character, Integer> map){
        HashMap<Character, Integer> mapp = map;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(char key : map.keySet()){
                min = Math.min(min, map.get(key));
                max = Math.max(max, map.get(key));
        }
        return (max-min);
    }
    public int beautySum(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int count = 0;
        for(int i = 0; i<s.length(); i++){
            for(int j = i; j<s.length(); j++){
                char ch = s.charAt(j);
                if(map.containsKey(ch)){
                    int freq = map.get(ch);
                    map.put(ch, freq+1);
                }
                else map.put(ch, 1);
                count += beauty(s, i, j, map);
            }
            map.clear();
        }
        return count;
        
    }
}