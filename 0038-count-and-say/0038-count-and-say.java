// class Solution {
//     public String countAndSay(int n) {
//        String s =  "1";
//        if(n == 1) return s;
//        String str =  CAS(n, s, 1);
//        return str;
//     }
//     public String CAS(int n, String s, int x){
//         if(x == n) return s;
//         s = Sb(s);
//         return CAS(n, s, x+1);
//     }
//     public String Sb(String s){
//         StringBuilder st = new StringBuilder(s);
//         int n = s.length();
//         int i = 0;
//         int j = i;
//         String str = "";
//             int count = 0;
//             while(j<n){
//                 if(st.charAt(i) == st.charAt(j)){
//                     count++;
//                     j++;
//                 }
//                 else{
//                   str+=count;
//                   str+=st.charAt(i);
//                   i = j;
//                   count = 0;
//                 }
//         }
//          str+=count;
//          str+=st.charAt(i);
//          i = j;
//        return str;
//     }
    
// }



// class Solution {
//     public String countAndSay(int n) {
//        String s =  "1";
//        if(n == 1) return s;
//        String str =  CAS(n, s, 1);
//        return str;
//     }
//     public String CAS(int n, String s, int x){
//         if(x == n) return s;
//         s = Sb(s);
//         return CAS(n, s, x+1);
//     }
//     public String Sb(String s){
//         StringBuilder st = new StringBuilder(s + "@");
//         int n = st.length();
//         int i = 0;
//         int j = i;
//         String str = "";
//             int count = 0;
//             while(j<n){
//                 if(st.charAt(i) == st.charAt(j)){
//                     count++;
//                     j++;
//                 }
//                 else{
//                   str+=count;
//                   str+=st.charAt(i);
//                   i = j;
//                   count = 0;
//                 }
//         }
//        return str;
//     }
    
// }





class Solution {
    public String countAndSay(int n) {
       String s =  "1";
       if(n == 1) return s;
       String str =  CAS(n, s, 1);
       return str;
    }
    public String CAS(int n, String s, int x){
        if(x == n) return s;
        s = Sb(s);
        return CAS(n, s, x+1);
    }
    public String Sb(String s){
         s = s+ "@";
        int n = s.length();
        int i = 0;
        int j = i;
        String str = "";
            int count = 0;
            while(j<n){
                if(s.charAt(i) == s.charAt(j)){
                    count++;
                    j++;
                }
                else{
                  str+=count;
                  str+=s.charAt(i);
                  i = j;
                  count = 0;
                }
        }
       return str;
    }
    
}