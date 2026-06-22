class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq=new int[26];
        int res=0;
        for(int i=0, j=0, maxf=0; i<s.length(); i++){
            char curr=s.charAt(i);
            freq[curr-'A']++;
            maxf=Math.max(maxf, freq[curr-'A']);

            while((i-j+1)-maxf > k){
                char rm=s.charAt(j);
                freq[rm-'A']--;
                j++;
            }
            res=Math.max(res, i-j+1);
        }
        return res;
    }
}
