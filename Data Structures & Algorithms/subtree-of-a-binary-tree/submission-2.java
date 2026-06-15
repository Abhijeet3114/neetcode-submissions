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

    public List<TreeNode> findSubroot(TreeNode root, int val, List<TreeNode> result){
        if(root == null){
            return result;
        }

        if(root.val == val){
            result.add(root);
        }

        findSubroot(root.left, val, result);
        findSubroot(root.right, val, result);
        
        return result;
    }

    public boolean isSameTree(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot == null){
            return true;
        }

        if((root == null && null != subRoot)
            || (root != null && subRoot == null)
            || (root.val != subRoot.val)
        )
        {
            return false;
        }

        return isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // find subroot in main tree if found, check is same tree, else return false
        List<TreeNode> result = new ArrayList<>();
        findSubroot(root, subRoot.val, result);

        boolean output = false;
        for(TreeNode root1 : result){
            output = isSameTree(root1, subRoot);
            if(output == true){
                return output;
            }
        }

        return output;

    }
}
