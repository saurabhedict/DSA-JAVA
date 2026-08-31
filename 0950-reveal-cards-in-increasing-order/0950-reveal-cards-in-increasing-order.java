// class Solution {
//     public int[] deckRevealedIncreasing(int[] deck) {
//         int n = deck.length;
//         Arrays.sort(deck);
//         int[] ans = new int[n];

//         int j = 0; //deck
//         int i = 0; //ans
//         boolean mark = false;
//         while(j<n){
//            if(ans[i] == 0) {
//              if(mark == false){
//                 ans[i] = deck[j];
//                 j++;
//              }
//               mark = !mark;
//            }

//            i = (i+1)%n;
//         }
//         return ans;
//     }
// }


class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Arrays.sort(deck);
        int[] ans = new int[n];
        Queue<Integer> q = new LinkedList<>();
        int i = 0; //ans

        for(int k = 0; k<n; k++){
            q.add(k);
        }

        while(!q.isEmpty()){
            int idx = q.remove();
            if(ans[idx] == 0){
                ans[idx] = deck[i];
                if(!q.isEmpty()){
                    int x = q.remove();
                    q.add(x);
                }

            }
             i = (i+1)%n;
        }
        
        return ans;
    }
}