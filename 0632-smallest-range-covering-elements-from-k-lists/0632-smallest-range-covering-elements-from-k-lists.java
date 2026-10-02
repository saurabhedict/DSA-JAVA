// class Solution {
//     public class Triplet implements Comparable<Triplet>{
//        int ele;
//        int row;
//        int col;

//        Triplet(int ele, int row, int col){
//         this.ele = ele;
//         this.row = row;
//         this.col = col;
//        }

//        public int compareTo(Triplet p){
//          return this.ele - p.ele; //min will be prioratize
//        }
//     }
//     public int[] smallestRange(List<List<Integer>> nums) {
//         PriorityQueue<Triplet> pq = new PriorityQueue<>();
//         int n = nums.size();

//         int a = Integer.MAX_VALUE;
//         int b = Integer.MIN_VALUE;


//         for(int j = 0; j<1; j++){ //col
//             for(int i = 0; i<n; i++){ //row
//                 Triplet t = new Triplet(nums.get(i).get(j), i, j);
//                 pq.add(t);
//                 b = Math.max(b, nums.get(i).get(j));
//             }
//         }
//         a = pq.peek().ele;
//         int max = b;

//         while(true){
//             Triplet top = pq.remove();
//             if(top.col < nums.get(top.row).size()-1){
//                 Triplet x = new Triplet(nums.get(top.row).get(top.col+1),top.row, top.col+1);
//                 pq.add(x);
//                 if(max-top.ele < b-a){
//                     b = max;
//                     a = top.ele;
//                 }
//                 max = Math.max(max, x.ele); //order of updating max after checing the condition is very important
//             }
//             else {
//                 if(max-top.ele < b-a){
//                     b = max;
//                     a = top.ele;
//                 }
//                 break;
//             }
//         }

//         int[] ans = {a, b};
//         return ans;
//     }
// }




// class Solution {
//     public class Triplet implements Comparable<Triplet>{
//        int ele;
//        int row;
//        int col;

//        Triplet(int ele, int row, int col){
//         this.ele = ele;
//         this.row = row;
//         this.col = col;
//        }

//        public int compareTo(Triplet p){
//          return this.ele - p.ele; //min will be prioratize
//        }
//     }
//     public int[] smallestRange(List<List<Integer>> nums) {
//         PriorityQueue<Triplet> pq = new PriorityQueue<>();
//         int n = nums.size();

//         int a = Integer.MAX_VALUE;
//         int b = Integer.MIN_VALUE;


//         for(int j = 0; j<1; j++){ //col
//             for(int i = 0; i<n; i++){ //row
//                 Triplet t = new Triplet(nums.get(i).get(j), i, j);
//                 pq.add(t);
//                 b = Math.max(b, nums.get(i).get(j));
//             }
//         }
//         a = pq.peek().ele;
//         int max = b;

//         while(true){
//             Triplet top = pq.remove();
//             if(max-top.ele < b-a){
//                     b = max;
//                     a = top.ele;
//             }
//             if(top.col < nums.get(top.row).size()-1){
//                 Triplet x = new Triplet(nums.get(top.row).get(top.col+1),top.row, top.col+1);
//                 pq.add(x);
//                 max = Math.max(max, x.ele); //order of updating max after checing the condition is very important
//             }
//             else break;
            
//         }

//         int[] ans = {a, b};
//         return ans;
//     }
// }




class Solution {
    public class Triplet implements Comparable<Triplet>{
       int ele;
       int row;
       int col;

       Triplet(int ele, int row, int col){
        this.ele = ele;
        this.row = row;
        this.col = col;
       }

       public int compareTo(Triplet p){
         return this.ele - p.ele; //min will be prioratize
       }
    }
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        int n = nums.size();

        int a = Integer.MAX_VALUE;
        int b = Integer.MIN_VALUE;


        for(int j = 0; j<1; j++){ //col
            for(int i = 0; i<n; i++){ //row
                Triplet t = new Triplet(nums.get(i).get(j), i, j);
                pq.add(t);
                b = Math.max(b, nums.get(i).get(j));
            }
        }
        a = pq.peek().ele;
        int max = b;

        while(true){
            Triplet top = pq.remove();
            if(max-top.ele < b-a){
                    b = max;
                    a = top.ele;
            }
            if(top.col == nums.get(top.row).size()-1) break;
            Triplet x = new Triplet(nums.get(top.row).get(top.col+1),top.row, top.col+1);
            max = Math.max(max, x.ele);
            pq.add(x);
        }
        
        int[] ans = {a, b};
        return ans;
    }
}

