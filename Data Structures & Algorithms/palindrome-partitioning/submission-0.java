class Solution {
    boolean isPalindrome(int i, int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j-1))return false;
            i++; j--;
        }
        return true;
    }
    String s;
    List<Integer> path=new ArrayList<>();
    List<List<String>> paths=new ArrayList<>();
    void backtrack(int start){
        if(start==s.length()){
            paths.add(new ArrayList<>());
            int l=0;
            for(int r:path){
                paths.getLast().add(s.substring(l, r));
                l=r;
            }
            return;
        }

        for(int i=start+1; i<=s.length(); i++){
            if(!isPalindrome(start, i))continue;
            path.add(i);
            backtrack(i);
            path.removeLast();
        }
    }

    public List<List<String>> partition(String s) {
        this.s=s;
        backtrack(0);
        return paths;
    }
}
