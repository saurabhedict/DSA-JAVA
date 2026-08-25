class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        int n = asteroids.length;
        int i = 0;
        while(i<n){
            while(!st.isEmpty() && i<n && (st.peek()>0   && asteroids[i] < 0)){
                if(st.peek() > Math.abs(asteroids[i])) i++;
                else if(st.peek() == Math.abs(asteroids[i])) {
                    st.pop();
                    i++;
                }
                else st.pop();
               }
               if(i<n) st.push(asteroids[i]);
               i++;
        
            }
            Stack<Integer> helper = new Stack<>();
            while(!st.isEmpty()){
                helper.push(st.pop());
            }
            int[] ans = new int[helper.size()];
            int j = 0;
            while(!helper.isEmpty()){
                ans[j] = helper.pop();
                j++;
            }
            return ans;
            
        }
    }
