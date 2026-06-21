class Solution {
    public int maxArea(int[] heights) {
        int ma=0;
        for(int i=0, j=heights.length-1;i<j;){
            int h=Math.min(heights[i], heights[j]);
            int l=j-i;
            ma=Math.max(ma, l*h);
            if(heights[j]<heights[i])j--;
            else i++;
        }
        return ma;
    }
}
