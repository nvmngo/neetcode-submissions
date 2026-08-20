class Twitter {

    //The intuition for this question:
    /* 
    First design approach:
    
    - HashMap #1 :      one's own tweets
        -> Stores the entries of key & value
        WHERE the 'key' will be the unique 'userID'
        AND the 'value' will be the list of 'tweetsID' associcate to that 'userID'
    
    - HashMap #2:       one's newfeed
        -> Quite similar to hashMap#1, however
            -> Instead of linking the personal tweets to the user
            -> We're storing the top 10 recent tweets from their list of follow
        -> The Data Structure reckon to use to store the top 10 most recent tweets
            -> Heap - PriorityQueue
                -> Polling out the 10 newer tweets
                    -> Store them in a List<> when being called in getFeed
                    -> clear the heap -> transfer the tweets from the list to the heap

    - HashMap #3:       one's followees
        -> Storing the entries of key & value pairs
        WHERE the 'key' will be the unique 'userID'
        AND the 'value' will be the user's list of 'followee'

    Problem:
    ? How can we implement the priority of each of the tweet ?
        -> How can one's tweet timestamp can be compared to other tweet
        !! Store an iteration counter for the class 
    */

    //Decalaring data structures
    private HashMap<Integer, Queue<int[]>> myTweets;
    private HashMap<Integer, PriorityQueue<int[]>> myFeed;
    private HashMap<Integer, List<Integer>> myFollowers;
    //Setting up timeStamp
    private int timestamp;
    
    //Constructor
    public Twitter() {
        this.myTweets = new HashMap<>();
        this.myFeed = new HashMap<>();
        this.myFollowers = new HashMap<>();

        this.timestamp = 0;
    }
    
    //Posting tweets
    public void postTweet(int userId, int tweetId) {
        //Registering the user to the system
        registering(userId);

        //Create the tweet, update the timeStamp
        int[] tweet = new int[]{timestamp, tweetId};
        timestamp++;

        //Updating myTweets
        updateMyTweet(userId, tweet);

        //Updating myFeed
        updateMyFeed(userId, tweet);

        //Updating myFollowers feeds
        List<Integer> followers = myFollowers.get(userId);
        for (int follower : followers) {
            updateMyFeed(follower, tweet);
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {

        registering(userId);

        Queue<int[]> realFeed = new LinkedList<>();
        PriorityQueue<int[]> oldFeed = myFeed.get(userId);
        List<Integer> res = new ArrayList<>();

        int count = 10;
        while (!oldFeed.isEmpty() && count > 0) {
            int[] tweet = oldFeed.poll();
            realFeed.offer(tweet);
            res.add(tweet[1]);
            count--;
        }

        while (!realFeed.isEmpty()) {
            oldFeed.offer(realFeed.poll());
        }

        return res;
    }
    
    //When Follow, update the current feed with the followee tweets
    public void follow(int followerId, int followeeId) {
        
        registering(followerId);
        registering(followeeId);

        if (followerId == followeeId) {
            return;
        }

        List<Integer> followers = myFollowers.get(followeeId);

        if (followers.contains(followerId)) {
            return;
        }

        followers.add(followerId);

        PriorityQueue<int[]> feed = myFeed.get(followerId);
        Queue<int[]> tweets = myTweets.get(followeeId);

        for (int[] tweet : tweets) {
            feed.offer(tweet);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        
        if (followerId == followeeId) return;
        
        //Update followee's followers list
        List<Integer> followers = myFollowers.get(followeeId);
        followers.remove(Integer.valueOf(followerId));

        //Update the follower's feed
        PriorityQueue<int[]> feed = myFeed.get(followerId);
        Iterator<int[]> iterator = feed.iterator();
        Queue<int[]> tweets = myTweets.get(followeeId);

        while(iterator.hasNext()) {
            int[] tweet = iterator.next();

            if (tweets.contains(tweet)) {
                iterator.remove();
            }
        }
    }

    /*------------------------------------------------------------------------*/
    public void updateMyTweet(int userId, int[] tweet) {
        Queue tweets = myTweets.get(userId);
        tweets.offer(tweet);
        
        while (tweets.size() > 10) {
            tweets.poll();
        }
    }

    public void updateMyFeed(int userId, int[] tweet) {
        PriorityQueue<int[]> feed = myFeed.get(userId);
        feed.offer(tweet);
    }

    public void registering(int userId) {
        if (!myTweets.containsKey(userId)) {
            myTweets.put(userId, new LinkedList<>());
            myFeed.put(userId, new PriorityQueue<>(
                Comparator.comparingInt((int[] a) -> a[0]).reversed()
            ));
            myFollowers.put(userId, new LinkedList<>());
        }
    }
}
