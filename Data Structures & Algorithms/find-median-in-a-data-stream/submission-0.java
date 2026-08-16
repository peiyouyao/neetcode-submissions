class MedianFinder {
    Queue<Integer> left = new PriorityQueue<>((x, y) -> y - x); // MaxHeap
    Queue<Integer> right = new PriorityQueue<>(); // MinHeap
    public MedianFinder() {}

    public void addNum(int num) {
        left.offer(num);
        while (Math.abs(left.size() - right.size()) > 1
            || (left.isEmpty() ? Integer.MIN_VALUE : left.peek())
                > (right.isEmpty() ? Integer.MAX_VALUE : right.peek())) {
            if (left.size() > right.size())
                right.offer(left.poll());
            else
                left.offer(right.poll());
        }
    }

    public double findMedian() {
        if (left.size() == right.size())
            return ((double) left.peek() + (double) right.peek()) / 2;
        Queue<Integer> q = left.size() > right.size() ? left : right;
        return (double) q.peek();
    }
}
