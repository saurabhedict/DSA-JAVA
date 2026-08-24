// class Solution {
//     public int minimumDeletions(String s) {
//         if(s.length() == 1) return 0;
//         Stack<Character> st = new Stack<>();
//         int x = 0;
//         int count = 0;
//         while(x<s.length()){
//             if(!st.isEmpty() && (st.peek() == 'b' && s.charAt(x) == 'a')){
//                 st.pop();
//                 count++;
//             }
//             else{
//                st.push(s.charAt(x));
//             }
//             x++;
//         }
//         return count;
//     }
// }




// class Solution {
//     public int minimumDeletions(String s) {
//        int n = s.length();
//        int[] Bbefore = new int[n];
//        int[] Aafter = new int[n];
       
//        int b = 0;
//        for(int i = 0; i<n; i++){
//          Bbefore[i] = Bbefore[i] + b;
//          if(s.charAt(i) == 'b') b++;
//        }

//        int a = 0;
//        for(int i = n-1; i>=0; i--){
//          Aafter[i] = Aafter[i] + a;
//          if(s.charAt(i) == 'a') a++;
//        }


//        int[] sum = new int[n];
//         for(int i = 0; i<n; i++){
//          sum[i] = Bbefore[i] + Aafter[i];
//        }
//        int min = Integer.MAX_VALUE;
//        for(int i = 0; i<n; i++){
//          min = Math.min(sum[i], min);
//        }
//        return min;
//     }
// }




// class Solution {
//     public int minimumDeletions(String s) {
//        int n = s.length();
//        int[] Aafter = new int[n];
//        int b = 0;
//        int a = 0;
//        for(int i = n-1; i>=0; i--){
//          Aafter[i] = Aafter[i] + a;
//          if(s.charAt(i) == 'a') a++;
//        }

//        int min = Integer.MAX_VALUE;
//        for(int i = 0; i<n; i++){
//           int sum = Aafter[i] + b;
//           if(s.charAt(i) == 'b') b++;
//           min = Math.min(min,sum);
//        }
//        return min;
//     }
// }




class Solution {
    public int minimumDeletions(String s) {
       int n = s.length();
       int b = 0;
       int a = 0;
       for(int i = 0; i<n; i++){
         if(s.charAt(i) == 'a') a++;
       }

       int min = Integer.MAX_VALUE;
       for(int i = 0; i<n; i++){
          if(s.charAt(i) == 'a') a--;
          int sum = a + b;
          if(s.charAt(i) == 'b') b++;
          min = Math.min(min,sum);
       }
       return min;
    }
}



