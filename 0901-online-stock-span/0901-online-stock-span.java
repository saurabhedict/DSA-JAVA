class StockSpanner {

    public StockSpanner() {
        
    }

    public class Pair{
          int val;
          int span;

          Pair(int val, int span){
            this.val = val;
            this.span = span;
          }
    }
    Stack<Pair> st = new Stack<>();

    public int next(int price) { 
        int count = 1;

        // if(st.isEmpty()){
        //     st.push(new Pair(price, count));
        // }

        while(!st.isEmpty() && price>st.peek().val){
            count += st.pop().span;
        }
        st.push(new Pair(price, count));
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */