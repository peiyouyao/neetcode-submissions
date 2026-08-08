class Solution {
    int target;
    int[] nums;
    List<Integer> path=new ArrayList<>();
    List<List<Integer>> paths=new ArrayList<>();
    void backtrack(int start, int sum){
        if(sum>target)return;
        if(sum==target){
            paths.add(new ArrayList<>(path));
            return;
        }
        for(int i=start; i<nums.length; i++){
            if(i>start && nums[i] == nums[i-1])continue;
            path.add(nums[i]);
            backtrack(i+1, sum+nums[i]);
            path.removeLast();
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.target=target;
        nums=candidates;
        backtrack(0, 0);
        return paths;
    }
}
