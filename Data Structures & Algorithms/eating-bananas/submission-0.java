class Solution {
    // 使用二分法解方程
    public int minEatingSpeed(int[] piles, int h) {
        int lower=1, upper=Integer.MAX_VALUE;
        while(lower<upper){
            int m=lower+(upper-lower)/2;
            int cost=0;
            for(int p:piles)cost += (p+m-1)/m;
            if(cost<=h)upper=m;
            else lower=m+1;
        }
        return lower;
    }
}
