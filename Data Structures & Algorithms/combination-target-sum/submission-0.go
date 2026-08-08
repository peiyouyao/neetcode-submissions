func combinationSum(nums []int, target int) [][]int {
    paths := [][]int{}
	path := []int{}

	var backtrack func(int, int)
	backtrack = func(start int, sum int){
		if sum > target {
			return
		}
		if sum == target {
			p := make([]int, len(path))
			for i := range p{
				p[i]=path[i]
			}
			paths = append(paths, p)
		}
		for i := start; i<len(nums); i++ {
			path = append(path, nums[i])
			backtrack(i, sum+nums[i])
			path = path[:len(path)-1]
		}
	}
	backtrack(0, 0)
	return paths
}
