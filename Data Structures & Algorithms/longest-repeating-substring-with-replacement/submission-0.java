class Solution {
    public int characterReplacement(String s, int k) {
        boolean[] appeared=new boolean[26];
        char[] ss=s.toCharArray();
        int res=0;
        for(char c: ss)appeared[c-'A']=true;
        for(int cid=0; cid<26; cid++){
            if(!appeared[cid])continue;
            char c=(char)(cid + 'A');
            int diffCnt=0;
            int maxl=0;
            for(int i=0, j=0; i<ss.length; i++){
                if(ss[i]!=c)diffCnt++;
                while(diffCnt>k){
                    if(ss[j]!=c) diffCnt--;
                    j++;
                }
                maxl=Math.max(maxl, i-j+1);
            }
            res=Math.max(res, maxl);
        }
        return res;
    }
}
