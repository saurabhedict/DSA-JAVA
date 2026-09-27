class Solution {
    public class Pair implements Comparable<Pair>{
        int exe;
        int idx;
        Pair(int exe, int idx){
            this.exe = exe;
            this.idx = idx;
        }
        
        public int compareTo(Pair p){
           if(this.exe != p.exe) return this.exe-p.exe;
           else return this.idx-p.idx;
        }
    }
    public int[] getOrder(int[][] tasks) {
        int[] ans = new int[tasks.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for(int i = 0; i<tasks.length; i++){
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(i);
            temp.add(tasks[i][0]);
            temp.add(tasks[i][1]);
            list.add(temp);
        }

        list.sort((a,b) -> a.get(1)-b.get(1));
        int time = list.get(0).get(1);
        int itr = 0;
        int k = 0;

        while(itr < list.size()){
           int arrival = list.get(itr).get(1);

            while(itr<list.size() && arrival <= time){
            int exe = list.get(itr).get(2);
            int idx = list.get(itr).get(0);
            pq.add(new Pair(exe, idx));
            itr++;
            if(itr<list.size()) arrival = list.get(itr).get(1);
            else break;
           }
            
            if(pq.isEmpty()) time = list.get(itr).get(1);

            else{
                Pair p = pq.remove();
                time += p.exe;
                ans[k] = p.idx;
                k++;
            }

           
        }
        while(!pq.isEmpty()){
            Pair p = pq.remove();
            time += p.exe;
            ans[k] = p.idx;
            k++;
        }
        return ans;
    }
}