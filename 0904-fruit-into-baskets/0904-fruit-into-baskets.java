class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = fruits.length;
        int maxLen = Integer.MIN_VALUE;
        int i = 0;
        int j = 0;
        while(j<n){
          if(map.containsKey(fruits[j])){
           int freq =  map.get(fruits[j]);
           map.put(fruits[j], freq+1);
          }
          else{
            map.put(fruits[j], 1);
          }

            while(map.size() > 2){

              if(map.containsKey(fruits[i])){
                int freq =  map.get(fruits[i]);
                freq--;
                if(freq != 0){
                    map.put(fruits[i], freq);
                }
                else map.remove(fruits[i]);
               }
               i++;
            }

            int len = j-i+1;
            maxLen = Math.max(len, maxLen);
            j++;
          
        }
        return maxLen;
    }
}