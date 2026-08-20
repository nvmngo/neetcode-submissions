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
        if (root == null) { return new ArrayList<Integer>(); }

        //use BFS, get the Nodes at each level, then take the one on the right
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        List<Integer> res = new ArrayList<>();
        res.add(root.val);

        TreeNode lastAdded = null;

        while (!queue.isEmpty()) {

            //finding the next level
            for (int i = 0, n = queue.size(); i < n; i++) {
                TreeNode node = queue.poll();
                if(node.left != null) {
                    queue.offer(node.left);
                    lastAdded = node.left;
                }
                if(node.right != null) {
                    queue.offer(node.right);
                    lastAdded = node.right;
                }
            }

            if (lastAdded != null) res.add(lastAdded.val);
            lastAdded = null;
        }

        return res;
    }
}
