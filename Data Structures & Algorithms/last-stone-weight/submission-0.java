class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> q=new PriorityQueue<>((x, y) -> y - x);
        for(int s:stones)q.offer(s);
        while(q.size()>1){
            int x=q.poll();
            int y=q.poll(); // x>=y
            if(x>y)q.offer(x-y);
        }
        return q.size()==0 ? 0 : q.poll();
    }
}
