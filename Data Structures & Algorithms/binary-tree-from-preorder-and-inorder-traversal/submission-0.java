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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //pre-order:    moving from the left branch to the right branch
        //in-order:     moving in value ascending order (of bst)
        
        if (preorder.length == 0) return null;
        if (preorder.length == 1) return new TreeNode(preorder[0]);
        
        TreeNode root = new TreeNode(preorder[0]); 
        
        int i = 0;
        while (inorder[i] != root.val) {
            i++;
        }

        int[] leftInOrder = Arrays.copyOfRange(inorder, 0, i);
        int[] rightInOrder = Arrays.copyOfRange(inorder, i + 1, inorder.length);

        int[] leftPreOrder = Arrays.copyOfRange(preorder, 1, leftInOrder.length + 1);
        int[] rightPreOrder = Arrays.copyOfRange(preorder, leftInOrder.length + 1, preorder.length);

        root.left = buildTree(leftPreOrder, leftInOrder);
        root.right = buildTree(rightPreOrder, rightInOrder);

        return root;
    }
}
