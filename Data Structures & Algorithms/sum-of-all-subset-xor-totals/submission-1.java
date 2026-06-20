class Solution {
    int xorSum=0;
    int[] nums;
    boolean[] used;
    void backtrack(int start, int pathSum){
        xorSum+=pathSum;
        if (start==nums.length)return;
        for (int i=start; i<nums.length; i++){
            if (used[i])continue;
            used[i]=true;
            backtrack(i+1, pathSum ^ nums[i]);
            used[i]=false;
        }
    }

    public int subsetXORSum(int[] nums) {
        this.nums=nums;
        used=new boolean[nums.length];
        backtrack(0, 0);
        return xorSum;
    }
}