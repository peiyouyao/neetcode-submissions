class Solution {
    int[] nums;
    List<Integer> path=new ArrayList<>();
    List<List<Integer>> paths=new ArrayList<>();
    void backtrack(int start){
        paths.add(new ArrayList<>(path));
        if(start==nums.length)return;

        for(int i=start; i<nums.length; i++){
            if(i>start && nums[i]==nums[i-1])continue; // 1 1 2 -> [1] [1,1] [1,2] [1,1,2]
            path.add(nums[i]);
            backtrack(i+1);
            path.removeLast();
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.nums=nums;
        backtrack(0);
        return paths;
    }
}
