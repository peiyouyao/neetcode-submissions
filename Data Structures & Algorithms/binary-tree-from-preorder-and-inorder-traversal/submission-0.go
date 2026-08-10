/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

func buildTree(preorder []int, inorder []int) *TreeNode {
	n := len(inorder)
    if n==0{
		return nil
	}
	rootVal := preorder[0]
	rootIdx := 0
	for ; rootIdx<n; rootIdx++{
		if inorder[rootIdx]==rootVal{
			break
		}
	}
	leftNum := rootIdx
	// rightNum := n-1-rootIdx // 0 1 (2) 3 4 | n = 5 rootIdx = 2 rightNum = 5-2-1 = 2
	leftPreorder := preorder[1:1+leftNum]
	rightPreorder := preorder[1+leftNum:]
	leftInorder := inorder[0:leftNum]
	rightInorder := inorder[rootIdx+1:]
	return &TreeNode{
		rootVal,
		buildTree(leftPreorder, leftInorder),
		buildTree(rightPreorder, rightInorder),
	}
}
