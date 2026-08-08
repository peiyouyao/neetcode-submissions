class Solution {
    public int findDuplicate(int[] nums) {
        int s=0, f=0;
        while(true){
            s=nums[s];
            f=nums[nums[f]];
            if(s==f)break;
        }
        f=0;
        while(s!=f){
            s=nums[s];
            f=nums[f];
        }
        return s;
    }
}
