class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0; i<n; i++){
            if(nums[i]>0)break;
            if(i>0 && nums[i-1]==nums[i])continue;
            int j=i+1, k=n-1;
            while(j<k){
                int s=nums[i]+nums[j]+nums[k];
                if(s>0)k--;
                else if(s<0)j++;
                else{
                    res.add(List.of(nums[i],nums[j],nums[k]));
                    j++;
                    while(j<n && nums[j]==nums[j-1])j++;
                    k--;
                    while(k>i && nums[k]==nums[k+1])k--;
                }
            }
        }
        return res;
    }
}
