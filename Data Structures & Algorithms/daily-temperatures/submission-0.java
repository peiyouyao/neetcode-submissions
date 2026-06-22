class Solution {
    public int[] dailyTemperatures(int[] temps) {
        int n=temps.length;
        int[] res=new int[n];
        List<Integer> stk=new ArrayList<>();
        for(int i=0; i<n; i++){
            while(!stk.isEmpty() && temps[stk.getLast()]<temps[i]){
                int prev=stk.removeLast();
                res[prev]=i-prev;
            }
            stk.add(i);
        }
        return res;
    }
}
