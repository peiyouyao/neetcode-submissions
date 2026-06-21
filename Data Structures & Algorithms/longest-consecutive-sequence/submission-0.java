class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int num:nums)set.add(num);
        int maxl=0;
        for(int num:nums){
            if(!set.contains(num))continue;
            int l=1;
            for(int i=num+1; set.contains(i); i++){
                l++;
                set.remove(i);
            }
            for(int i=num-1; set.contains(i); i--){
                l++;
                set.remove(i);
            }
            maxl=Math.max(maxl, l);
        }
        return maxl;
    }
}
