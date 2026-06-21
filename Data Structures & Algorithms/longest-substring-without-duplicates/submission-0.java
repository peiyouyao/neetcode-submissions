class Solution {
    public int lengthOfLongestSubstring(String s) {
        boolean[] appeared=new boolean[256];
        int maxl=0;
        for(int i=0, j=0; i<s.length(); i++){
            char c=s.charAt(i);
            while(appeared[c]){
                char rm=s.charAt(j);
                appeared[rm]=false;
                j++;
            }
            appeared[c]=true;
            maxl=Math.max(maxl, i-j+1);
        }
        return maxl;
    }
}
