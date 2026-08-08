/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

func maxDepth(root *TreeNode) int {
    _maxDepth := 0
    var dfs func(*TreeNode, int)
    dfs = func(root *TreeNode, depth int){
        if root == nil {
            return
        }
        depth ++
        _maxDepth = max(_maxDepth, depth)
        dfs(root.Left, depth)
        dfs(root.Right, depth)
    }
    dfs(root, 0)
    return _maxDepth
}
