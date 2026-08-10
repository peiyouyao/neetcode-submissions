/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

func kthSmallest(root *TreeNode, k int) int {
    var dfs func(*TreeNode) int
	dfs = func(root *TreeNode) int {
		if root == nil {
			return -1
		}
		l := dfs(root.Left)
		if l != -1 {
			return l
		}
		if k==1 {
			return root.Val
		}
		k --
		r := dfs(root.Right)
		if r != -1 {
			return r
		}
		return -1
	}
	return dfs(root)
}
