class Solution {
    public int[] replaceElements(int[] arr) {
        int maxRight = -1;
        for(int i=arr.length-1; i>-1; i--){
            int t=arr[i];
            arr[i]=maxRight;
            maxRight=Math.max(maxRight, t);
        }
        return arr;
    }
}