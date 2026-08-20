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
    public int diameterOfBinaryTree(TreeNode root) {
        //Diameter of a Binary Tree - the longest path between any two nodes in a tree

        //Each node can have its longest path, which is the length coming up from its left node, and length coming from its right node
        int diameter = getLeft(root) + getRight(root);
        int diameter1 = root.left != null ? diameterOfBinaryTree(root.left) : 0;
        int diameter2 = root.right != null ? diameterOfBinaryTree(root.right) : 0;

        return Math.max(diameter, Math.max(diameter1, diameter2));
    }

    public int getLeft(TreeNode root) {
        if (root.left == null) {
            return 0;
        }

        return Math.max(getLeft(root.left) + 1, getRight(root.left) + 1);
    }

    public int getRight(TreeNode root) {
        if (root.right == null) {
            return 0;
        }

        return Math.max(getLeft(root.right) + 1, getRight(root.right) + 1);
    }
}
