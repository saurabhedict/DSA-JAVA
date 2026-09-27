class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        //Stored the freq. of all characters in Map
        for(char ele : tasks){
            if(map.containsKey(ele)){
                int freq = map.get(ele);
                map.put(ele, freq+1);
            }
            else map.put(ele, 1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        //Stored all characters freq in max heap
        for(char key : map.keySet()){
          pq.add(map.get(key));
        }

        int intervals = 0;
        ArrayList<Integer> temp =  new ArrayList<>();

        while(!pq.isEmpty()){

        for(int i = 1; i<=n+1; i++){
            int x = pq.remove();
            x--;
            temp.add(x);
            if(pq.isEmpty()) break;
        }

        for(int i = 0; i<temp.size(); i++){
            int num = temp.get(i);
            if(num > 0) pq.add(num);
        }

        if(pq.isEmpty()) intervals += temp.size();
        else intervals += (n+1);

        temp.clear();
        }
      
      return intervals;
}
}