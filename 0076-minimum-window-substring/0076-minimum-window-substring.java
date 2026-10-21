// class Solution {
//     public String minWindow(String s, String t) {
//         int m = s.length();
//         int n = t.length();

//         HashMap<Character, Integer> mapT = new HashMap<>();
        
//         for(int i = 0; i<n; i++){
//             char ch = t.charAt(i);

//             if(mapT.containsKey(ch)){
//                 int freq = mapT.get(ch);
//                 mapT.put(ch, freq+1);
//             }  
//             else mapT.put(ch, 1);
        
//         } //O(n)

//         int i = 0,  j = 0;
//         int minLength = Integer.MAX_VALUE;
//         int a = -1;
//         int b = -1;

//         HashMap<Character, Integer> helper = new HashMap<>();


//         while(j<m){ //O(m)
//             char ch = s.charAt(j);

//             if(mapT.containsKey(ch)){
//                 if(helper.containsKey(ch)){
//                     int freq = helper.get(ch);
//                     helper.put(ch, freq+1);
//                 }
//                 else helper.put(ch, 1);
//             }
            
//             boolean check = true; //O(26)

//             for(char ele : mapT.keySet()){
//                 if(!helper.containsKey(ele)){
//                     check = false;
//                     break;
//                 }
                
//                 int freq1 = mapT.get(ele);
//                 int freq2 = helper.get(ele);
//                 if(freq1 > freq2){
//                     check = false;
//                     break;
//                 }
                
//             }

//             if(check){
//                 int length  = j-i+1;
                
//                 if(length < minLength){
//                     minLength = Math.min(length, minLength);
//                     a = i;
//                     b = j;
//                 }

//                 boolean check2 = true;

//                 while(check2){

//                     if(helper.containsKey(s.charAt(i))) {
//                        int freq = helper.get(s.charAt(i));
//                        freq--;
//                        if(freq == 0) helper.remove(s.charAt(i));
//                        else helper.put(s.charAt(i), freq);
//                     }
//                     for(char ele : mapT.keySet()){
//                       if(!helper.containsKey(ele)){
//                         check2 = false;
//                         break;
//                       }
                      
//                         int freq1 = mapT.get(ele);
//                         int freq2 = helper.get(ele);
//                         if(freq1 > freq2){
//                             check2 = false;
//                             break;
//                         }
                       
//                     }
//                     length  = j-i+1;
                    

//                     if(length < minLength){
//                        minLength = Math.min(length, minLength);
//                        a = i;
//                        b = j;
//                     }
//                     i++;
//                 }
//             }
//             j++;
//         }

//         String ans = "";
//         if(a == -1 || b == -1) return "";
//         for(int k = a; k<=b; k++){
//             ans += s.charAt(k);
//         }
//         return ans;
//     }
// } //TC = O(n + m*k + m*k), where k is distinct elements in map,  O(n+m) : final
// //SC = by map : O(k), answer string : O(m) : at max




class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();

        HashMap<Character, Integer> mapT = new HashMap<>();
        
        for(int i = 0; i<n; i++){
            char ch = t.charAt(i);

            if(mapT.containsKey(ch)){
                int freq = mapT.get(ch);
                mapT.put(ch, freq+1);
            }  
            else mapT.put(ch, 1);
        
        } //O(n)

        int i = 0,  j = 0;
        int minLength = Integer.MAX_VALUE;
        int a = -1;
        int b = -1;

        HashMap<Character, Integer> helper = new HashMap<>();


        while(j<m){ //O(m)
            char ch = s.charAt(j);

            if(mapT.containsKey(ch)){
                if(helper.containsKey(ch)){
                    int freq = helper.get(ch);
                    helper.put(ch, freq+1);
                }
                else helper.put(ch, 1);
            }
            
            boolean check = true; //O(26)

            for(char ele : mapT.keySet()){
                if(!helper.containsKey(ele)){
                    check = false;
                    break;
                }
                
                int freq1 = mapT.get(ele);
                int freq2 = helper.get(ele);
                if(freq1 > freq2){
                    check = false;
                    break;
                }
                
            }

            if(check){
                int length  = j-i+1;
                
                if(length < minLength){
                    minLength = Math.min(length, minLength);
                    a = i;
                    b = j;
                }

                boolean check2 = true;

                while(check2){

                    if(helper.containsKey(s.charAt(i))) {
                       int freq = helper.get(s.charAt(i));
                       freq--;
                       if(freq == 0) helper.remove(s.charAt(i));
                       else helper.put(s.charAt(i), freq);
                    }
                    for(char ele : mapT.keySet()){
                      if(!helper.containsKey(ele)){
                        check2 = false;
                        break;
                      }
                      
                        int freq1 = mapT.get(ele);
                        int freq2 = helper.get(ele);
                        if(freq1 > freq2){
                            check2 = false;
                            break;
                        }
                       
                    }
                    length  = j-i+1;

                    if(length < minLength){
                       minLength = Math.min(length, minLength);
                       a = i;
                       b = j;
                    }
                    i++;
                }
            }
            j++;
        }

        StringBuilder sb = new StringBuilder("");
        if(a == -1 || b == -1) return "";
        for(int k = a; k<=b; k++){
            sb.append(s.charAt(k));
        }
        return sb.toString();
    }
} //TC = O(n + m*k + m*k), where k is distinct elements in map,  O(n+m) : final
//SC = by map : O(k), answer string : O(m) : at max