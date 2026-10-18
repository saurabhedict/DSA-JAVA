// class Solution {
//     public int numberOfSubarrays(int[] nums, int k) {
//         int n = nums.length;
//         int a = 0, b = 0, i = 0, j = 0;
//         int kCount = 0;

//         //initial configuration of first window
//         while(i<n && nums[i]%2 == 0) i++;
//         while(j<n && kCount < k){
//             if(nums[j]%2 != 0) kCount++;
//             j++;
//         }
//         j--;
//         if(kCount < k) return 0; //edge case

//         b = j+1;
//         while(b<n && nums[b]%2 == 0) b++;
//         b--;

//         int count   = 0;

//         //sliding window
//         while(b<n){ 
//             count += (i-a+1)*(b-j+1);

//             a = i + 1;
//             i++;
//             while(i<n && nums[i]%2 == 0) i++;

//             j = b + 1;
//             b = j + 1;
//             while(b<n && nums[b]%2 == 0) b++;
//             b--;
//         }

//         return count;
//     }
// }




class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
       int n = nums.length;
       HashMap<Integer, Integer> map = new HashMap<>();
       int count  = 0;

       for(int i = 0; i<n; i++){
          if( nums[i]%2 == 0) nums[i] = 0;
          else nums[i] = 1;
       }

       for(int i = 1; i<n; i++){
        nums[i] = nums[i] + nums[i-1];
       }

       for(int i = 0; i<n; i++){

            if(!map.containsKey(nums[i])){
                map.put(nums[i], i);
            }

            if(nums[i] == k){
                int a =  0;
                int b =  0;
                if(map.containsKey(nums[i]-k)) a = map.get(nums[i]-k);
                if(map.containsKey(nums[i]-k+1)) b = map.get(nums[i]-k+1);
                count += b-a+1;
            }
            
            if(nums[i] > k){
                int a = 0; 
                if(map.containsKey(nums[i]-k)) a = map.get(nums[i]-k);
                int b = 0;
                if(map.containsKey(nums[i]-k+1)) b = map.get(nums[i]-k+1);
                count += b-a;
            }
       }

       return count;
    }
}
