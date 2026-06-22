class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q=new ArrayDeque<>();
        int[] res=new int[nums.length+1-k];
        for(int i=0; i<nums.length; i++){
            while(!q.isEmpty() && q.peekLast()<nums[i])q.pollLast();
            q.offerLast(nums[i]);
            if(i>=k-1){
                res[i-k+1]=q.peekFirst();
                if(q.peekFirst()==nums[i-k+1])q.pollFirst();
            }
        }
        return res;
    }
}
