class Solution {
    List<List<Integer>> paths=new ArrayList<>();
    List<Integer> path=new ArrayList<>();
    int[] nums;
    void backtrack(int start){
        paths.add(new ArrayList<>(path));
        if (start==nums.length)return;
        for (int i=start; i<nums.length; i++){
            path.add(nums[i]);
            backtrack(i+1);
            path.removeLast();
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        this.nums=nums;
        backtrack(0);
        return paths;
    }
}
