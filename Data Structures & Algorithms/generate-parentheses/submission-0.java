class Solution {
    int n;
    List<String> paths=new ArrayList<>();
    StringBuilder path=new StringBuilder();
    void backtrack(int l, int r){
        if(l>n || r>n || r>l)return;
        if(r==n && l==n){
            paths.add(path.toString());
            return;
        }
        int len=path.length();
        if(l>r){
            path.append(")");
            backtrack(l, r+1);
            path.setLength(len);
        }
        path.append("(");
        backtrack(l+1, r);
        path.setLength(len);
    }

    public List<String> generateParenthesis(int n) {
        this.n=n;
        backtrack(0,0);
        return paths;
    }
}
