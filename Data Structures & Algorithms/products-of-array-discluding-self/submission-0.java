class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] res=new int[n];
        int prod=1;
        int zeroIdx=-1;
        for(int i=0; i<n; i++){
            if(nums[i]==0){
                if(zeroIdx!=-1)return res;
                zeroIdx=i;
            }else prod *= nums[i];
        }
        if(zeroIdx!=-1) res[zeroIdx]=prod;
        else for(int i=0; i<n; i++) res[i] = prod/nums[i];
        return res;
    }
}  
