// class Solution {
//     public class Pair implements Comparable<Pair>{
//         char ch;
//         int freq;
//         Pair(char ch, int freq){
//             this.ch = ch;
//             this.freq = freq;
//         }
//         public int compareTo(Pair p){
//             if(p.freq != this.freq) return p.freq - this.freq; //it will make max heap : bigger freq first
//             else return p.ch - this.ch; //bigger character first
//         }
//     }
//     public String reorganizeString(String s) {
//         int n = s.length();
//         PriorityQueue<Pair> pq = new PriorityQueue<>();
//         HashMap<Character, Integer> map = new HashMap<>();

//         for(int i = 0; i<n; i++){
//             char ch = s.charAt(i);

//             if(map.containsKey(ch)){
//                 int freq = map.get(ch);
//                 freq += 1;
//                 if(freq> (n+1)/2) return ""; //imp
//                 map.put(ch, freq);
//             }

//             else{
//                 map.put(ch, 1);
//             }
//         }


//         for(char key : map.keySet()){
//             int val = map.get(key);
//             pq.add(new Pair(key, val));
//         }

//         if(pq.size() == 1 && pq.peek().freq>1) return "";
         
//          String ans = "";
//          while(pq.size() >=2){
//            Pair first = pq.remove();
//            Pair second = pq.remove();
//            ans += first.ch;
//            ans += second.ch;
//            if(first.freq-1 != 0) pq.add(new Pair(first.ch, first.freq-1));
//            if(second.freq-1 != 0) pq.add(new Pair(second.ch, second.freq-1));
//            if(pq.size() == 0) return ans;
//          }

//          if(pq.size() == 1 && pq.peek().freq>1) return "";
//          ans += pq.remove().ch;
//          return ans;
//     }
// }



class Solution {
    public class Pair implements Comparable<Pair>{
        char ch;
        int freq;
        Pair(char ch, int freq){
            this.ch = ch;
            this.freq = freq;
        }
        public int compareTo(Pair p){
            return p.freq - this.freq; //it will make max heap : bigger freq first
            
        }
    }
    public String reorganizeString(String s) {
        int n = s.length();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i<n; i++){
            char ch = s.charAt(i);

            if(map.containsKey(ch)){
                int freq = map.get(ch);
                freq += 1;
                if(freq> (n+1)/2) return ""; //imp
                map.put(ch, freq);
            }

            else{
                map.put(ch, 1);
            }
        }


        for(char key : map.keySet()){
            int val = map.get(key);
            pq.add(new Pair(key, val));
        }

        if(pq.size() == 1 && pq.peek().freq>1) return "";
         
         StringBuilder ans = new StringBuilder();
         while(pq.size() >=2){
           Pair first = pq.remove();
           Pair second = pq.remove();
           ans.append(first.ch);
           ans.append(second.ch);
           if(first.freq-1 != 0) pq.add(new Pair(first.ch, first.freq-1));
           if(second.freq-1 != 0) pq.add(new Pair(second.ch, second.freq-1));
           if(pq.size() == 0) return ans.toString();
         }
         
         if(pq.size() == 1 && pq.peek().freq>1) return "";
         ans.append(pq.remove().ch);
         return ans.toString();
    }
}