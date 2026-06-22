class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] ss1=s1.toCharArray(), ss2=s2.toCharArray();
        int[] targetFreq=new int[26];
        for(char c:ss1)targetFreq[c-'a']++;
        int[] windowFreq=new int[26];
        for(int i=0, j=0; i<ss2.length; i++){
            windowFreq[ss2[i]-'a']++;
            if(i-j+1==ss1.length){
                boolean find=true;
                for(int cid=0; cid<26; cid++){
                    if(windowFreq[cid]!=targetFreq[cid]){
                        find=false;
                        break;
                    }
                }
                if(find)return true;
                windowFreq[ss2[j]-'a']--;
                j++;
            }
        }
        return false;
    }
}
