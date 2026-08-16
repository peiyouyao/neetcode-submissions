class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> q=new PriorityQueue<>((x, y) -> - (x[0]*x[0] + x[1]*x[1]) + (y[0]*y[0] + y[1]*y[1]));
        for(int[] p:points){
            q.offer(p);
            if(q.size()>k)q.poll();
        }
        return q.stream().toArray(int[][]::new);
    }
}
