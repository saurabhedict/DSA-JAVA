class Twitter {
    int time = 0;
    public class Pair implements Comparable<Pair>{
        int tweetId;
        int timeStamp;
        int userId;
        Pair(int tweetId, int timeStamp, int userId){
            this.tweetId = tweetId;
            this.timeStamp = timeStamp;
            this.userId = userId;
        }
        public int compareTo(Pair p){
            return  p.timeStamp - this.timeStamp; //jiska time stamp big hai vo pehle q ki vo hi sbse new tweet hai.
        }
    }
    
    HashMap<Integer, HashSet<Integer>> map = new HashMap<>(); //user Id, and the peoples followed by User.
    HashMap<Integer, PriorityQueue<Pair>> feed = new HashMap<>();//user Id, and the post of the user.

    public Twitter() {
        
    }
    
    public void postTweet(int userId, int tweetId) {
        Pair post = new Pair(tweetId, time, userId);
        time++;
        PriorityQueue<Pair> pq = feed.get(userId);

        if(pq == null){
            pq = new PriorityQueue<>(Collections.reverseOrder());
            feed.put(userId, pq);
        }
        pq.add(post);
    }

    public void addFeed(List<Pair> temp ,int userId){
       if(feed.get(userId) != null){
            for(Pair post : feed.get(userId)){
                temp.add(post);
            }
        }
    }

    public void fillList(List<Integer> list, HashSet<Integer> following, int userId){
        List<Pair> temp = new ArrayList<>();
        addFeed(temp, userId);

        if(following != null){
            for(int followingId : following){
              addFeed(temp, followingId);
            }
        }
        Collections.sort(temp);
        int count = 0;
        for(Pair tweet : temp){
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

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */