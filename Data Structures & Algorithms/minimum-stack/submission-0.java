class MinStack {

    private List<Integer> numStk=new ArrayList<>();

    private List<Integer> minStk=new ArrayList<>();

    public MinStack() {}
    
    public void push(int val) {
        numStk.add(val);
        if (!minStk.isEmpty() && minStk.getLast() <= val) minStk.add(minStk.getLast());
        else minStk.add(val);
    }
    
    public void pop() {
        minStk.removeLast();
        numStk.removeLast();
    }
    
    public int top() {
        return numStk.getLast();
    }
    
    public int getMin() {
        return minStk.getLast();
    }
}
