class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        int r1=0, r2=mat.length;
        while(r1<r2){
            int m=r1+(r2-r1)/2;
            if(target<=mat[m][0])r2=m;
            else r1=m+1;
        }
        if(r1<mat.length){
            if (mat[r1][0]==target)return true;
            if (r1==0) return false;
        }
        // search in r1-1 row
        int c1=0, c2=mat[r1-1].length;
        while(c1<c2){
            int m=c1+(c2-c1)/2;
            if(target<=mat[r1-1][m])c2=m;
            else c1=m+1;
        }
        if(c1<mat[r1-1].length && mat[r1-1][c1]==target)return true;
        return false;
    }
}
