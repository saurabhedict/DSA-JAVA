class Solution {
    public class Pair implements Comparable<Pair>{
        char ch;
        int freq;
        Pair(char ch, int freq){
            this.ch = ch;
            this.freq = freq;
        }
        public int compareTo(Pair p){
            return p.freq-this.freq;
        }
    }
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(); //it will act like max heap because of Pair class
        if(a != 0) pq.add(new Pair('a', a));
        if(b != 0) pq.add(new Pair('b', b));
        if(c != 0) pq.add(new Pair('c', c));
        

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
           Pair top = pq.remove();
           char topChar = top.ch;
           int topCount = top.freq;

           if(sb.length() >=2 && (sb.charAt(sb.length()-1)==topChar && sb.charAt(sb.length()-2)==topChar)){
             if(pq.isEmpty()) break;

             Pair secondTop = pq.remove();
             char secondChar = secondTop.ch;
             int secondCount =secondTop.freq;

             sb.append(secondChar);
             secondCount -= 1;
             if(secondCount > 0) pq.add(new Pair(secondChar, secondCount));
           }
           else{
             sb.append(topChar);
             topCount -= 1;
           }
           if(topCount > 0) pq.add(new Pair(topChar, topCount));
            
        }
       
        return sb.toString();

    }
}