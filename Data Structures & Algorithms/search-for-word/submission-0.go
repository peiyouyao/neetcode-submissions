func exist(board [][]byte, word string) bool {
    di := [4]int{0, 1, 0, -1}
    dj := [4]int{1, 0, -1, 0}
    l := len(word)
    m, n := len(board), len(board[0])
    idx := 0

    var dfs func(int, int) bool
    dfs = func(i, j int) bool {
        if idx > l {
            return false
        }
        if idx == l {
            return true
        }
        if i<0 || i>= m || j<0 || j>= n {
            return false
        }
        if board[i][j] == '.'{
            return false
        }
        if board[i][j] != word[idx]{
            return false
        }
        c := board[i][j]
        board[i][j] = '.'
        idx ++

        for d := 0; d<4; d++{
            ni, nj := i+di[d], j+dj[d]
            if dfs(ni, nj){
                return true
            }
        }
        idx --
        board[i][j] = c
        return false
    }
    for i := 0; i<m ; i++{
        for j := 0; j<n; j++{
            if dfs(i, j){
                return true
            }
        }
    }
    return false
}
