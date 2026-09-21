// class Solution {
//     public boolean canArrange(int[] arr, int k) {
//         HashMap<Integer, Integer> map = new HashMap<>();

//         for(int ele : arr){
//             ele = ele%k;
//             if(map.containsKey(ele)){
//                 int freq = map.get(ele);
//                 map.put(ele, freq+1);
//             }
//             else map.put(ele, 1);
//         }

//         for(int ele : map.keySet()){
//             if(ele == 0 && map.get(ele)%2 == 0) continue;
//             if(ele == 0 && map.get(ele)%2 != 0) return false;
//             int rem = k - ele;
//             if(!map.containsKey(rem)) return false;
//             else{
//                 int freq1 = map.get(ele);
//                 int freq2 = map.get(rem);
//                 if(freq1 != freq2) return false;
//             }
//         }
//         return true;
//     }
// } //solution is wrong 




// class Solution {
//     public boolean canArrange(int[] arr, int k) {
//         HashMap<Integer, Integer> map = new HashMap<>();

//         for(int ele : arr){
//             ele = ele%k;
//             if(ele < 0) ele += k;
//             if(map.containsKey(ele)){
//                 int freq = map.get(ele);
//                 map.put(ele, freq+1);
//             }
//             else map.put(ele, 1);
//         }
    
//         if(map.containsKey(0)){
//             if(map.get(0)%2 != 0) return false;
//             map.remove(0);
//         }
//         // if(k%2 == 0 && map.containsKey(k/2)){
//         //     if(map.get(k/2)%2 != 0) return false;
//         //     map.remove(k/2);
//         // } //we don't need this actually

//         for(int ele : map.keySet()){
//             int rem = k - ele;
//             if(!map.containsKey(rem)) return false;
//             else{
//                 int freq1 = map.get(ele);
//                 int freq2 = map.get(rem);
//                 if(freq1 != freq2) return false;
//             }
//         }
//         return true;
//     }
// }





// class Solution {
//     public boolean canArrange(int[] arr, int k) {
//         HashMap<Integer, Integer> map = new HashMap<>();

//         for(int ele : arr){
//             ele = ele%k;
//             if(ele < 0) ele += k;
//             if(map.containsKey(ele)){
//                 int freq = map.get(ele);
//                 map.put(ele, freq+1);
//             }
//             else map.put(ele, 1);
//         }
    
//         if(map.containsKey(0)){
//             if(map.get(0)%2 != 0) return false;
//             map.remove(0);
//         }

//         for(int ele : map.keySet()){
//             int rem = k - ele;
//             if(!map.containsKey(rem)) return false;
//             else{
//                 int freq1 = map.get(ele);
//                 int freq2 = map.get(rem);
//                 if(freq1 != freq2) return false;
//             }
//         }
//         return true;
//     }
// }




class Solution {
    public boolean canArrange(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int ele : arr){
            ele = ele%k;
            if(ele < 0) ele += k;
            if(map.containsKey(ele)){
                int freq = map.get(ele);
                map.put(ele, freq+1);
            }
            else map.put(ele, 1);
        }
    
        // if(map.containsKey(0)){
        //     if(map.get(0)%2 != 0) return false;
        //     map.remove(0);
        // }

        for(int ele : map.keySet()){
            if(ele == 0 && map.get(ele)%2 == 0) continue;
            int rem = k - ele;
            if(!map.containsKey(rem)) return false;
            else{
                int freq1 = map.get(ele);
                int freq2 = map.get(rem);
                if(freq1 != freq2) return false;
            }
        }
        return true;
    }
}