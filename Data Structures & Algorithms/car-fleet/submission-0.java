class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n=position.length;
        int[][] ps=new int[n][2];
        for(int i=0; i<n; i++){
            ps[i][0]=position[i];
            ps[i][1]=speed[i];
        }
        Arrays.sort(ps, (x,y)->x[0]-y[0]);
        int[] slowerInRight=new int[n];
        Arrays.fill(slowerInRight, -1);
        List<Integer> stk=new ArrayList<>();
        for(int i=0; i<n; i++){
            while(!stk.isEmpty() && ps[stk.getLast()][1] > ps[i][1]){
                slowerInRight[stk.removeLast()]=i;
            }
            stk.add(i);
        }
        int fleets=0;
        for(int i=0; i<n; i++){
            if(slowerInRight[i]==-1)fleets++;
            else{
                int[] curr=ps[i];
                int[] slower=ps[slowerInRight[i]];
                // t_meet = (p_front - p_back) / (v_fast - v_slow)
                double meetTime = (double)(slower[0] - curr[0]) / (double)(curr[1] - slower[1]);
                double meetPos = curr[0] + curr[1] * meetTime;
                if(meetPos>(double)target) fleets++;
            }
        }
        return fleets;
    }
}

/*
反例场景：
假设有 A, B, C 三辆车同向行驶：

C车 最靠前，速度极慢（20 mph）。

B车 在中间，速度中等（50 mph）。

A车 在最后，速度极快（100 mph）。

按照你的 slowerInRight 逻辑，A 车右边第一个比它慢的是 B 车，你会通过公式计算 A 和 B 保持原速行驶的相遇点。
但是，这里忽略了一个“连锁反应”：
B 车可能在 A 追上它之前，就已经先追上了最前方的 C 车！
一旦 B 追上 C，B 的速度就会从 50 骤降到 20。此时 A 车追上 B 车的相遇点会大大提前。
你的公式基于 B 始终保持原速（50 mph）进行计算，自然会得出错误的结果。
*/
