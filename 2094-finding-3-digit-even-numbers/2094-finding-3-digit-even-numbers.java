class Solution {
    public int[] listToArray(ArrayList<Integer> list){
        int[] arr = new int[list.size()];
        for(int i = 0; i<arr.length; i++){
            arr[i] = list.get(i);
        }
        return arr;
    }
    public int[] findEvenNumbers(int[] digits) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        for(int ele : digits){
          if(map.containsKey(ele)){
            int freq = map.get(ele);
            map.put(ele, freq+1);
          }
          else map.put(ele, 1);
        }

        for(int i = 100; i<=999; i += 2){ //even numbers
            int x  = i;
            
            int a = x%10; x = x/10;
            int b = x%10; x = x/10;
            int c = x%10;

            if(map.containsKey(a)){

                int freqA = map.get(a);
                if(freqA == 1) map.remove(a);
                else map.put(a, freqA-1);

                if(map.containsKey(b)){
                   int freqB = map.get(b);
                   if(freqB == 1) map.remove(b);
                   else map.put(b, freqB-1);

                   if(map.containsKey(c)){
                       list.add(i);
                   }
                   
                    map.put(b, freqB);
                } 

                map.put(a, freqA);

            }
        }
         
         return listToArray(list);
    }
}