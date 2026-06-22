class Solution {
    public int largestRectangleArea(int[] hs) {
        int n=hs.length;
        int[] lowerRight=new int[n], lowerLeft=new int[n];
        Arrays.fill(lowerRight, n); Arrays.fill(lowerLeft, -1);
        List<Integer> stk=new ArrayList<>();
        for(int i=0; i<n; i++){
            while(!stk.isEmpty() && hs[stk.getLast()]>hs[i]) lowerRight[stk.removeLast()]=i;
            stk.add(i);
        }
        stk.clear();
        for(int i=n-1; i>-1; i--){
            while(!stk.isEmpty() && hs[stk.getLast()]>hs[i]) lowerLeft[stk.removeLast()]=i;
            stk.add(i);
        }
        int maxArea=0;
        for(int i=0; i<n; i++){
            int area=hs[i] * (lowerRight[i] - lowerLeft[i] - 1);
            maxArea=Math.max(maxArea, area);
        }
        return maxArea;
    }
}
