class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        int l=0, r=n;
        while(l<r){
            int m=l+(r-l)/2;
            if (target<=nums[m]) r=m;
            else l=m+1;
        }
        if (l==n || nums[l]!=target)return -1;
        return l;
    }
}
