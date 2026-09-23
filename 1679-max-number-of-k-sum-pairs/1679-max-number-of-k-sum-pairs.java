// class Solution {
//     public int maxOperations(int[] nums, int k) {
//         int opt = 0;
//         HashMap<Integer, Integer> map = new HashMap<>();
//         for(int ele : nums){
//             int rem = k - ele;
//             if(map.containsKey(rem) || map.containsKey(ele)){
//               if(map.containsKey(rem)){
//               int val = map.get(rem);
//               val = val - 1;
//               if(val == 0) map.remove(rem);
//               else map.put(rem, val);
//               opt++;
//               }
//               else if(map.containsKey(ele)){
//                 int val = map.get(ele);
//                 map.put(ele, val+1);
//               }
//             }
//             else map.put(ele, 1);
//         }
//          return opt;
//     }
// }



class Solution {
    public int maxOperations(int[] nums, int k) {
        int opt = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int ele : nums) {
            int rem = k - ele;

            if (map.containsKey(rem)) {
                int val = map.get(rem);

                if (val == 1)
                    map.remove(rem);
                else
                    map.put(rem, val - 1);

                opt++;
            } 
            else {
                if (map.containsKey(ele)) {
                    int val = map.get(ele);
                    map.put(ele, val + 1);
                } 
                else {
                    map.put(ele, 1);
                }
            }
        }

        return opt;
    }
}