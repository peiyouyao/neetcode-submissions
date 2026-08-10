/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

func maxPathSum(root *TreeNode) int {
	_maxPathSum := math.MinInt
    var dfs func(*TreeNode) (int)
	dfs = func(root *TreeNode) (int) {
		if root == nil {
			return 0
		}
		l := dfs(root.Left)
		l = max(l, 0)
		r := dfs(root.Right)
		r = max(r, 0)
		
		_maxPathSum = max(_maxPathSum, root.Val + l + r)
		
		return max(l, r) + root.Val
	}
	dfs(root)
	return _maxPathSum
}
