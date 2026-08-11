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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> strs=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            if(curr!=null){
                strs.add(String.valueOf(curr.val));
                q.add(curr.left);
                q.add(curr.right);
            }else strs.add("null");
        }
        return strs.stream().collect(Collectors.joining(","));
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs=data.split(",");
        if(strs[0].equals("null"))return null;
        TreeNode root=new TreeNode(Integer.parseInt(strs[0]));
        Queue<TreeNode> q=new ArrayDeque<>();
        q.offer(root);
        int i=1;
        while(i<strs.length){
            TreeNode parent=q.poll();
            if(!strs[i].equals("null")){
                parent.left=new TreeNode(Integer.parseInt(strs[i]));
                q.offer(parent.left);
            }
            i++;
            if(!strs[i].equals("null")){
                parent.right=new TreeNode(Integer.parseInt(strs[i]));
                q.offer(parent.right);
            }
            i++;
        }
        return root;
    }
}
