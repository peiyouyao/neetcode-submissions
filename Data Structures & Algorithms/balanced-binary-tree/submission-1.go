/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

func isBalanced(root *TreeNode) bool {
    var dfs func(*TreeNode) int
	dfs = func(root *TreeNode) int {
		if root == nil {
			return 0
		}
		l := dfs(root.Left)
		if l == -1 {
			return -1
		}
		r := dfs(root.Right)
		if r == -1 {
			return -1
		}
		if abs(l - r) > 1 {
			return -1
		}
		return 1 + max(l, r)
	}
	return dfs(root) != -1
}

func abs(x int) int {
	if x < 0 {
		return -x
	}
	return x
}
