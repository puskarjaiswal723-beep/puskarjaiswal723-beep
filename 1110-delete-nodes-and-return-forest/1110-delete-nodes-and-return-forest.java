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
    HashSet<Integer> set=new HashSet<>();
    HashSet<TreeNode> add=new HashSet<>();
    List<TreeNode> list=new ArrayList();
    TreeNode del(TreeNode root){
        if(root==null){
            return root;
        }
        root.left=del(root.left);
        root.right=del(root.right);
        if(set.contains(root.val)){
            if(root.left!=null){
                list.add(root.left);
            }
            if(root.right!=null){
                list.add(root.right);
            }
            add.add(root);
            return null;
        }
    return root;}
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for(int x:to_delete){
            set.add(x);
        }
        del(root);
        if(!set.contains(root.val)){
            list.add(root);
        }
        return list;
    }
}