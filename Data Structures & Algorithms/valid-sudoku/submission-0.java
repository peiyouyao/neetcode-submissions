class Solution {
    char[][] board;
    boolean[] appeared=new boolean[9];
    boolean hasDuplicate(int i1, int j1, int i2, int j2){
        Arrays.fill(appeared, false);
        for(int i=i1; i<i2; i++){
            for(int j=j1; j<j2; j++){
                if(board[i][j]=='.')continue;
                int idx=board[i][j]-'1';
                if(appeared[idx])return true;
                appeared[idx]=true;
            }
        }
        return false;
    }
    public boolean isValidSudoku(char[][] board) {
        this.board=board;
        for(int i=0; i<9; i++)if(hasDuplicate(i, 0, i+1, 9))return false;
        for(int j=0; j<9; j++)if(hasDuplicate(0, j, 9, j+1))return false;
        for(int i=0; i<9; i+=3){
            for(int j=0; j<9; j+=3){
                if(hasDuplicate(i, j, i+3, j+3))return false;
            }
        }
        return true;
    }
}
