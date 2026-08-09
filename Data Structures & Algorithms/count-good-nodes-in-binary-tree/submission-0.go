/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

func goodNodes(root *TreeNode) int {
    cnt := 0
    var dfs func(*TreeNode, int)
    dfs = func(root *TreeNode, pathMax int){
        if root == nil{
            return
        }
        if root.Val >= pathMax{
            cnt++
            pathMax = root.Val
        }
        dfs(root.Left, pathMax)
        dfs(root.Right, pathMax)
    }
    dfs(root, -101)
    return cnt
}
