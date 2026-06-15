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
    public int height(TreeNode root){
        if(root == null){
            return 0;
        }
        else if (root.left == null && root.right == null){
            return 1;
        }
        
        int leftHeight = 1 + height(root.left);
        int rightHeight = 1 + height(root.right);

        return Math.max(leftHeight, rightHeight);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)){
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.max(leftHeight + rightHeight, Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)));
    }
}
