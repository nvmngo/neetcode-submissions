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
    public TreeNode invertTree(TreeNode root) {
        //Post-order traversal of tree
        invertTreeHelper(root);
        return root;
    }

    public void invertTreeHelper(TreeNode root) {
        if (root != null) {
            invertTreeHelper(root.left);
            invertTreeHelper(root.right);

            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;

        } return;
    }
}
