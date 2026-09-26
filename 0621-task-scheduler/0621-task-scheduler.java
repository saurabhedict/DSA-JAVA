class Solution {
    public int leastInterval(char[] tasks, int n) {

        // 1. Count frequency of each task
        int[] freq = new int[26];

        for (char task : tasks) {
            freq[task - 'A']++;
        }

        // 2. Max Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int f : freq) {
            if (f > 0) {
                pq.add(f);
            }
        }

        int time = 0;

        // 3. Process tasks in groups of n + 1
        while (!pq.isEmpty()) {

            int cycle = n + 1;
            int tasksDone = 0;

            ArrayList<Integer> remaining = new ArrayList<>();

            // Try to execute at most n + 1 different tasks
            while (cycle > 0 && !pq.isEmpty()) {

                int current = pq.poll();

                current--;
                tasksDone++;
                cycle--;

                if (current > 0) {
                    remaining.add(current);
                }
            }

            // Put remaining frequencies back into heap
            for (int f : remaining) {
                pq.add(f);
            }

            // If heap is empty, no idle time is needed
            if (pq.isEmpty()) {
                time += tasksDone;
            } 
            else {
                // Complete n+1 intervals for this cycle
                time += n + 1;
            }
        }

        return time;
    }
}