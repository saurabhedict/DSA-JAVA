// class Solution {
//     public void moveZeroes(int[] nums) {
//         int n = nums.length;
//         //Bubble Sort :

//         for(int x = 0; x<n-1; x++){
//             boolean flag = true;
//             for(int i = 0; i<n-1-x; i++){
//                 if(nums[i] == 0){
//                     int temp = nums[i];
//                     nums[i] = nums[i+1];
//                     nums[i+1] = temp;
//                     flag = false;
//                 }
//             }
//             if(flag == true) break;
//         }
//     }
// }





// class Solution {
//     public void moveZeroes(int[] nums) {
//         int n = nums.length;
//         //Bubble Sort :

//         int noz = 0;
//         for(int ele : nums){
//             if(ele == 0) noz++;
//         }
//         for(int x = 0; x<noz; x++){
//             for(int i = 0; i<n-1-x; i++){
//                 if(nums[i] == 0){
//                     int temp = nums[i];
//                     nums[i] = nums[i+1];
//                     nums[i+1] = temp;
//                 }
//             }
//         }
//     }
// }





class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> al = new ArrayList<>();

        int noz = 0;
        for(int ele : nums){
            if(ele != 0) al.add(ele);
            else noz++;
        }

        for(int i = 0; i<noz; i++){
            al.add(0);
        }
        for(int i = 0; i<n; i++){
            nums[i] = al.get(i);
        }
    }
}