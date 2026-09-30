// class MedianFinder {
//     List<Integer> list = new ArrayList<>();

//     public MedianFinder() {
        
//     }
    
//     public void addNum(int num) {
//         list.add(num);
//     }
    
//     public double findMedian() {
//         Collections.sort(list);
//         int n = list.size();
//         if(n%2 != 0) return list.get(n/2);
//         else return (list.get(n/2)+list.get((n/2)-1))/2.0;
//     }
// }


// class MedianFinder {
//     List<Integer> list;

//     public MedianFinder() {
//        list = new ArrayList<>();
//     }
    
//     public void addNum(int num) {
//         list.add(num);
//     }
    
//     public double findMedian() {
//         Collections.sort(list);
//         int n = list.size();
//         if(n%2 != 0) return list.get(n/2);
//         else return (list.get(n/2)+list.get((n/2)-1))/2.0;
//     }
// }




// class MedianFinder {
//     List<Integer> list;

//     public MedianFinder() {
//        list = new ArrayList<>();
//     }
    
//     public void addNum(int num) {
//         list.add(num);
//     }
    
//     public double findMedian() {
//         Collections.sort(list);
//         int n = list.size();
//         if(n%2 != 0) return list.get(n/2);
//         else return (list.get(n/2)+list.get((n/2)-1))/2.0;
//     }
// }



class MedianFinder {
    PriorityQueue<Integer> maxpq = new PriorityQueue<>(Collections.reverseOrder());//maxHeap
    PriorityQueue<Integer> minpq = new PriorityQueue<>();//minHeap


    public MedianFinder() {
    
    }
    
    public void addNum(int num) {
        //Addition :
       if(maxpq.size() == 0) maxpq.add(num);
       else{
        if(num > maxpq.peek()) minpq.add(num);
        else if(num <= maxpq.peek()) maxpq.add(num);
       }

       //Balance the Heaps : 
        if(maxpq.size() > minpq.size()+1){ //maxpq.size() == minpq.size()+2
            minpq.add(maxpq.remove());
        }
        
        if(minpq.size() > maxpq.size()+1){ //minpq.size() == maxpq.size()+2
            maxpq.add(minpq.remove());
        }
    }
    
    public double findMedian() {
        
         if(maxpq.size() == minpq.size()){
            return (maxpq.peek() + minpq.peek())/2.0;
         }
         else{
            if(maxpq.size() > minpq.size()){
                return maxpq.peek();
            }
            if(maxpq.size() < minpq.size()){
                return minpq.peek();
            }
         }
         return 0.0;
        }
    }


/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */