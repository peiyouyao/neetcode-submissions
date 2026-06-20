class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int maxpft=0;
        int[] maxToRight=new int[n];
        for(int i=n-1, m=0; i>-1; i--){
            m=Math.max(m, prices[i]);
            maxToRight[i]=m;
        }
        for(int i=0; i<n-1; i++){
            int p=prices[i];
            maxpft=Math.max(maxpft, maxToRight[i+1] - p);
        }
        return maxpft;
    }
}

/**
[10,1,5,6,7,1]
[10, 7, 7, 7, 7, 1]
arr[i] max value in [i, end]
*/
