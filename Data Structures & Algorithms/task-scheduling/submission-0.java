class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char t : tasks) freq[t - 'A']++;
        Queue<Integer> nextTaskQueue = new PriorityQueue<>((x, y) -> y - x);
        for (int f : freq) {
            if (f > 0)
                nextTaskQueue.offer(f);
        }
        Map<Integer, Integer> timeInque = new HashMap<>();
        int t = 0;
        while (!nextTaskQueue.isEmpty() || !timeInque.isEmpty()) {
            if (timeInque.containsKey(t)) {
                nextTaskQueue.offer(timeInque.remove(t));
            }
            if (!nextTaskQueue.isEmpty()) {
                int currTask = nextTaskQueue.poll();
                currTask--;
                if (currTask > 0) {
                    timeInque.put(t + n + 1, currTask);
                }
            }
            t++;
        }
        return t;
    }
}
