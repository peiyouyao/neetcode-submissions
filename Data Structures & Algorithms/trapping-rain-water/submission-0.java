class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int[] water=new int[n];
        for(int i=0, h=0; i<n; i++){
            h=Math.max(h, height[i]);
            water[i]=h;
        }
        for(int i=n-1, h=0; i>-1; i--){
            h=Math.max(h, height[i]);
            water[i]=Math.min(water[i], h) - height[i];
        }
        return Arrays.stream(water).reduce(0, Integer::sum);
    }
}
