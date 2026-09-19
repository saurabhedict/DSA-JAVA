class Solution {
    public String sort(String s){
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        String st = new String(arr);
        return st;
    }
    public List<List<String>> groupAnagrams(String[] strs) {
      HashMap<String, Integer> map = new HashMap<>();
      List<List<String>> ans = new ArrayList<>();
      int i = 0;
      for(String ele : strs){
        String sb = sort(ele);//sorted string
        if(map.containsKey(sb)){
            int idx = map.get(sb);
            ans.get(idx).add(ele);
        }
        else{
            ArrayList<String> list = new ArrayList<>();
            list.add(ele);
            ans.add(list);
            map.put(sb, i);
            i++;
        }
      }
      return ans;
    }
}