func permute(nums []int) [][]int {
    paths := [][]int{}
    path := []int{}
    n := len(nums)
    used := make([]bool, n)
    var backtrack func()
    backtrack = func(){
        if len(path)==n {
            p := make([]int, n)
            for i := range path {
                p[i]=path[i]
            }
            paths = append(paths, p)
            return
        }
        for i := 0; i < n; i++ {
            if used[i] {
                continue
            }
            used[i] = true
            path = append(path, nums[i])
            backtrack()
            path = path[:len(path)-1]
            used[i] = false
        }
    }
    backtrack()
    return paths
}
