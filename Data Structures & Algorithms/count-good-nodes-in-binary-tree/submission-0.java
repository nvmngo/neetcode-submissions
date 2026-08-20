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
    public int goodNodes(TreeNode root) {
        return goodNodesHelper(root, root.val);
    }

    public int goodNodesHelper(TreeNode node, int max) {
        if (node == null) {
            return 0;
        }
        
        int add = 0;
        if (node.val >= max) {
            max = node.val;
            add++;
        }

        return goodNodesHelper(node.left, max) + goodNodesHelper(node.right, max) + add;
    }
}
