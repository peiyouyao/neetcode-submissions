class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqs=new HashMap<>();
        for(int num:nums)freqs.put(num, freqs.getOrDefault(num, 0)+1);
        Queue<Integer> q=new PriorityQueue<>((x, y)->freqs.get(x)-freqs.get(y));
        for(Integer num:freqs.keySet()){
            q.offer(num);
            if(q.size()>k)q.poll();
        }
        return q.stream().mapToInt(x->x).toArray();
    }
}
