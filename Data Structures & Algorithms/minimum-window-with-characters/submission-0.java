class Solution {
    boolean isContained(int[] curr, int[] target){
        for(int i=0; i<256; i++)if(curr[i]<target[i])return false;
        return true;
    }
    public String minWindow(String s, String t) {
        char[] ss=s.toCharArray(), tt=t.toCharArray();
        int[] targetFreq=new int[256];
        for(char c:tt)targetFreq[c]++;
        int[] windowFreq=new int[256];
        int minSize=ss.length+1;
        int ti=-1, tj=-1;
        for(int i=0, j=0; i<ss.length; i++){
            windowFreq[ss[i]]++;
            while(isContained(windowFreq, targetFreq)){
                if(i-j+1<minSize){
                    ti=i; tj=j;
                    minSize=i-j+1;
                }
                windowFreq[ss[j]]--;
                j++;
            }
        }
        if(ti==-1)return "";
        return s.substring(tj, ti+1);
    }
}
