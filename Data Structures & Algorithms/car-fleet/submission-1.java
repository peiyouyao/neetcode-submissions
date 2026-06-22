class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] ps = new int[n][2];
        for (int i = 0; i < n; i++) {
            ps[i][0] = position[i];
            ps[i][1] = speed[i];
        }
        
        // 按照位置从大到小排序（离终点越近的越在前面）
        Arrays.sort(ps, (a, b) -> Integer.compare(b[0], a[0]));
        
        int fleets = 0;
        double maxTime = -1.0; // 记录前方车队中最慢的到达时间
        
        for (int i = 0; i < n; i++) {
            // 计算当前车不受阻挡到达终点的时间（这里注意将分子转为 double 避免整除截断）
            double time = (double) (target - ps[i][0]) / ps[i][1];
            
            // 如果当前车的时间大于前面车队的最慢时间，说明追不上，形成新车队
            if (time > maxTime) {
                maxTime = time;
                fleets++;
            }
            // 否则（time <= maxTime），说明它会在终点前追上前面的车队，直接并入即可，无需累加 fleets
        }
        
        return fleets;
    }
}
