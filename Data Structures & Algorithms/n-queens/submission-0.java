class Solution {
    char[] line;
    int n;
    List<List<String>> boards=new ArrayList<>();
    List<Integer> path=new ArrayList<>();
    List<String> convertNumsToBoard(){
        List<String> board=new ArrayList<>();
        for(int pos:path){
            line[pos]='Q';
            board.add(new String(line));
            line[pos]='.';
        }
        return board;
    }
    boolean isValidPos(int pos){
        if (path.size()==0)return true;
        for(int i=0; i<path.size(); i++){
            int p=path.get(i);
            if(p==pos)return false;
            if(Math.abs(pos-p)==path.size()-i)return false;
        }
        return true;
    }
    void backtrack(){
        if(path.size()==n){
            List<String> board=convertNumsToBoard();
            boards.add(board);
            return;
        }
        for(int pos=0; pos<n; pos++){
            if(!isValidPos(pos))continue;
            path.add(pos);
            backtrack();
            path.removeLast();
        }
    }

    public List<List<String>> solveNQueens(int n) {
        this.n=n;
        this.line=new char[n];
        Arrays.fill(line, '.');
        backtrack();
        return boards;
    }
}
