class Solution {
    public void copy(HashMap<Character, Integer> map1, HashMap<Character, Integer> map2){
        for(char ele : map1.keySet()){
            int freq = map1.get(ele);
            map2.put(ele, freq);
        }
    }
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        HashMap<Character, Integer> map1 = new HashMap<>();
        for(int i = 0; i<n; i++){
            char ele = s1.charAt(i);
            if(map1.containsKey(ele)){
                int freq = map1.get(ele);
                map1.put(ele, freq+1);
            }
            else map1.put(ele, 1);
        }

        for(int i = 0; i<s2.length(); i++){
            char ch = s2.charAt(i);
            if(!map1.containsKey(ch)) continue;
            HashMap<Character, Integer> map2 = new HashMap<>();
            copy(map1, map2);
            int freq = map2.get(ch);
            freq--;
            if(freq == 0) map2.remove(ch);
            else map2.put(ch, freq);
            if(map2.size() == 0) return true;

            for(int j = i+1; j<s2.length(); j++){
                char chh = s2.charAt(j);
                if(!map2.containsKey(chh)) break;
                int freqq = map2.get(chh);
                freqq--;
                if(freqq == 0) map2.remove(chh);
                else map2.put(chh, freqq);
                if(map2.size() == 0) return true;
            }
        }
        return false;
    }
}