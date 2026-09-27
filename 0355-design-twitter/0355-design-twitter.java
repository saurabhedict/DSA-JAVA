// class Twitter {
//     int time = 0;
//     public class Pair implements Comparable<Pair>{
//         int tweetId;
//         int timeStamp;
//         Pair(int tweetId, int timeStamp){
//             this.tweetId = tweetId;
//             this.timeStamp = timeStamp;
//         }
//         public int compareTo(Pair p){
//             return  p.timeStamp - this.timeStamp; //jiska time stamp big hai vo pehle q ki vo hi sbse new tweet hai.
//         }
//     }
    
//     HashMap<Integer, HashSet<Integer>> map = new HashMap<>(); //user Id, and the peoples followed by User.
//     HashMap<Integer, PriorityQueue<Pair>> feed = new HashMap<>();//user Id, and the post of the user.

//     public Twitter() {
        
//     }
    
//     public void postTweet(int userId, int tweetId) {
//         Pair post = new Pair(tweetId, time);
//         time++;
//         PriorityQueue<Pair> pq = feed.get(userId);

//         if(pq == null){
//             pq = new PriorityQueue<>();
//             pq.add(post);
//             feed.put(userId, pq);
//         }
//         else pq.add(post);
//     }

//     public void addFeed(List<Pair> temp ,int userId){
//        if(feed.get(userId) != null){
//             for(Pair post : feed.get(userId)){
//                 temp.add(post);
//             }
//         }
//     }

//     public void fillList(List<Integer> list, HashSet<Integer> following, int userId){
//         List<Pair> temp = new ArrayList<>();
//         addFeed(temp, userId);

//         if(following != null){
//             for(int followingId : following){
//               addFeed(temp, followingId);
//             }
//         }
//         Collections.sort(temp); //jiska time stamp zyada rhega vo latest hai to vo starting me aa jayega list ke
//         int count = 0;
//         for(Pair tweet : temp){
//             if(count<10) list.add(tweet.tweetId);
//             else break;
//             count++;
//         }

//     }
    
//     public List<Integer> getNewsFeed(int userId) {
//         List<Integer> list = new ArrayList<>();
//         HashSet<Integer> following = map.get(userId);
//         fillList(list, following, userId);
//         return list;
        
//     }

    
//     public void follow(int followerId, int followeeId) {
//       if(map.containsKey(followerId)){
//            HashSet<Integer> set = map.get(followerId); //following list
//            set.add(followeeId);
//            map.put(followerId, set);
//       }
//       else {
//         HashSet<Integer> set = new HashSet<>();
//         set.add(followeeId);
//         map.put(followerId, set);
//       }
//     }

//     public void unfollow(int followerId, int followeeId) {
//       if(map.containsKey(followerId)){
//          HashSet<Integer> set = map.get(followerId);
//          set.remove(followeeId);
//          map.put(followerId, set);
//       }

//     }
// }






// class Twitter {
//     int time = 0;
//     public class Pair implements Comparable<Pair>{
//         int tweetId;
//         int timeStamp;
//         Pair(int tweetId, int timeStamp){
//             this.tweetId = tweetId;
//             this.timeStamp = timeStamp;
//         }
//         public int compareTo(Pair p){
//             return  p.timeStamp - this.timeStamp; //jiska time stamp big hai vo pehle q ki vo hi sbse new tweet hai.
//         }
//     }
    
//     HashMap<Integer, HashSet<Integer>> map = new HashMap<>(); //user Id, and the peoples followed by User.
//     HashMap<Integer, List<Pair>> feed = new HashMap<>();//user Id, and the post of the user.

//     public Twitter() {
        
//     }
    
//     public void postTweet(int userId, int tweetId) {
//         Pair post = new Pair(tweetId, time);
//         time++;
//         List<Pair> myFeed = feed.get(userId);

//         if(myFeed == null){
//             myFeed = new ArrayList<>();
//             myFeed.add(post);
//             feed.put(userId, myFeed);
//         }
//         else myFeed.add(post);
//     }

//     public void addFeed(List<Pair> temp ,int userId){
//        if(feed.get(userId) != null){
//             for(Pair post : feed.get(userId)){
//                 temp.add(post);
//             }
//         }
//     }

//     public void fillList(List<Integer> list, HashSet<Integer> following, int userId){
//         List<Pair> temp = new ArrayList<>();
//         addFeed(temp, userId);

//         if(following != null){
//             for(int followingId : following){
//               addFeed(temp, followingId);
//             }
//         }
//         Collections.sort(temp); //jiska time stamp zyada rhega vo latest hai to vo starting me aa jayega list ke
//         int count = 0;
//         for(Pair tweet : temp){
//             if(count<10) list.add(tweet.tweetId);
//             else break;
//             count++;
//         }

//     }
    
//     public List<Integer> getNewsFeed(int userId) {
//         List<Integer> list = new ArrayList<>();
//         HashSet<Integer> following = map.get(userId);
//         fillList(list, following, userId);
//         return list;
        
//     }

    
//     public void follow(int followerId, int followeeId) {
//       if(map.containsKey(followerId)){
//            HashSet<Integer> set = map.get(followerId); //following list
//            set.add(followeeId);
//            map.put(followerId, set);
//       }
//       else {
//         HashSet<Integer> set = new HashSet<>();
//         set.add(followeeId);
//         map.put(followerId, set);
//       }
//     }

//     public void unfollow(int followerId, int followeeId) {
//       if(map.containsKey(followerId)){
//          HashSet<Integer> set = map.get(followerId);
//          set.remove(followeeId);
//          map.put(followerId, set);
//       }

//     }
// }


// postTweet  → O(1) average
// follow     → O(1) average
// unfollow   → O(1) average
// getNewsFeed → O(T log T)






class Twitter {
    int time = 0;
    public class Pair implements Comparable<Pair>{
        int tweetId;
        int timeStamp;
        Pair(int tweetId, int timeStamp){
            this.tweetId = tweetId;
            this.timeStamp = timeStamp;
        }
        public int compareTo(Pair p){
            return  this.timeStamp - p.timeStamp; //jiska time stamp big hai vo pehle q ki vo hi sbse new tweet hai.
        }
    }
    
    HashMap<Integer, HashSet<Integer>> map = new HashMap<>(); //user Id, and the peoples followed by User.
    HashMap<Integer, List<Pair>> feed = new HashMap<>();//user Id, and the post of the user.

    public Twitter() {
        
    }
    
    public void postTweet(int userId, int tweetId) {
        Pair post = new Pair(tweetId, time);
        time++;
        List<Pair> myFeed = feed.get(userId);

        if(myFeed == null){
            myFeed = new ArrayList<>();
            myFeed.add(post);
            feed.put(userId, myFeed);
        }
        else myFeed.add(post);
    }

    public void addFeed(PriorityQueue<Pair> temp ,int userId){
       if(feed.get(userId) != null){
            for(Pair post : feed.get(userId)){
                temp.add(post);
            }
        }
    }

    public void fillList(List<Integer> list, HashSet<Integer> following, int userId){
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        addFeed(pq, userId);

        if(following != null){
            for(int followingId : following){
              addFeed(pq, followingId);
            }
        }
         //jiska time stamp zyada rhega vo latest hai to vo starting me aa jayega list ke
        int count = 0;
        while(!pq.isEmpty()){
            Pair tweet = pq.remove();
            if(count<10) list.add(tweet.tweetId);
            else break;
            count++;
        }

    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> list = new ArrayList<>();
        HashSet<Integer> following = map.get(userId);
        fillList(list, following, userId);
        return list;
        
    }

    
    public void follow(int followerId, int followeeId) {
      if(map.containsKey(followerId)){
           HashSet<Integer> set = map.get(followerId); //following list
           set.add(followeeId);
           map.put(followerId, set);
      }
      else {
        HashSet<Integer> set = new HashSet<>();
        set.add(followeeId);
        map.put(followerId, set);
      }
    }

    public void unfollow(int followerId, int followeeId) {
      if(map.containsKey(followerId)){
         HashSet<Integer> set = map.get(followerId);
         set.remove(followeeId);
         map.put(followerId, set);
      }

    }
}
