class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map =  new HashMap<>();
        HashSet<Integer> set = new HashSet<>();

        for(int ele : arr){
            if(map.containsKey(ele)){
               int val = map.get(ele);
               map.put(ele, val+1);
            }
            else map.put(ele, 1);
        }

        for(int ele : map.keySet()){
            set.add(map.get(ele));
        }

        if(map.size() != set.size()) return false;
        return true;
    }
}