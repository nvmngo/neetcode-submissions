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
    public int maxPathSum(TreeNode root) {
        //follow the same pattern as "Diameter of Binary Tree"
        //each node will have its maximum path sum, thus you can compare the maximum path sum
        
        if (root == null) return Integer.MIN_VALUE;
        
        int max = getMaxPath(root.left) + getMaxPath(root.right) + root.val;
        int max1 = maxPathSum(root.left);
        int max2 = maxPathSum(root.right);

        return Math.max(max, Math.max(max1, max2));
    }

    public int getMaxPath(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(getMaxPath(root.left) + root.val, Math.max(getMaxPath(root.right) + root.val, 0));
    }
}
