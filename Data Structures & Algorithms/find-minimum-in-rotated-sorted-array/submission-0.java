class Solution {
    public int findMin(int[] nums) {
        int l=0, r=nums.length-1;
        int res=nums[0];
        while(l<=r){
            if(nums[l]<nums[r]) {
                res=Math.min(res, nums[l]);
                break;
            }

            int m=l+(r-l)/2;
            res=Math.min(res, nums[m]);
            if(nums[l]<=nums[m])l=m+1; // 前半段有序, 舍弃前半段
            else r=m-1; // 后半段有序, 舍弃后半段
        }
        return res;
    }
}
