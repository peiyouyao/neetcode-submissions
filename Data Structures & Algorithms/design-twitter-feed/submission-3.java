class Twitter {
    Map<Integer, Set<Integer>> follower2followee=new HashMap<>();
    Map<Integer, List<int[]>> user2tweet=new HashMap<>();
    int timestamp=0;

    private void userSetup(int userId){
        user2tweet.putIfAbsent(userId,new ArrayList<>());
        follower2followee.putIfAbsent(userId,new HashSet<>());
    }


    public Twitter(){}
    
    public void postTweet(int userId, int tweetId) {
        userSetup(userId);
        List<int[]> tweetList = user2tweet.get(userId);
        tweetList.add(new int[]{tweetId, timestamp});
        timestamp++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> feederSet=follower2followee.getOrDefault(userId, new HashSet<>());
        feederSet.add(userId);
        int n=feederSet.size();
        List<int[]>[] tweetLists=new List[n];
        int[] idxs=new int[n];
        Queue<int[]> q=new PriorityQueue<>((x,y)->-x[2]+y[2]);
        int i=0;
        for(int feederId: feederSet){
            List<int[]> tweetList=user2tweet.get(feederId);
            tweetLists[i]=tweetList;
            idxs[i]=tweetList.size()-1;
            if(idxs[i]>-1){
                int[] tweet=tweetList.get(idxs[i]);
                q.offer(new int[]{i, tweet[0], tweet[1]});
            }
            i++;
        }
        List<Integer> last10tweets=new ArrayList<>();
        while(last10tweets.size()<10 && !q.isEmpty()){
            int[] selected=q.poll();
            last10tweets.add(selected[1]);
            i=selected[0];
            idxs[i]--;
            if(idxs[i]==-1)continue;
            List<int[]> tweetList=tweetLists[i];
            int[] tweet=tweetList.get(idxs[i]);
            q.offer(new int[]{i, tweet[0], tweet[1]});
        }

        return last10tweets;
    }
    
    public void follow(int followerId, int followeeId) {
        userSetup(followerId); userSetup(followeeId);
        Set<Integer> followeeSet=follower2followee.get(followerId);
        followeeSet.add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        userSetup(followerId); userSetup(followeeId);
        Set<Integer> followeeSet=follower2followee.get(followerId);
        followeeSet.remove(followeeId);
    }
}
