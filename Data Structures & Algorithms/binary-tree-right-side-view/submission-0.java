/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightVals=new ArrayList<>();
        if(root==null)return rightVals;
        Queue<TreeNode> q=new ArrayDeque<>();
        q.offer(root);
        while(!q.isEmpty()){
            rightVals.add(q.peek().val);
            int sz=q.size();
            for(; sz>0; sz--){
                TreeNode curr=q.poll();
                if(curr.right!=null)q.offer(curr.right);
                if(curr.left!=null)q.offer(curr.left);
            }
        }
        return rightVals;
    }
}
