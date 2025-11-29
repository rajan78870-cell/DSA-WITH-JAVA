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
    int totalTilt = 0;

    public int findTilt(TreeNode root) {
        helper(root);
        return totalTilt;
    }
    
    // returns sum of subtree
    private int helper(TreeNode node) {
        if (node == null) return 0;
        
        int leftSum = helper(node.left);
        int rightSum = helper(node.right);
        
        // Calculate tilt for current node
        totalTilt += Math.abs(leftSum - rightSum);
        
        // Return subtree total sum to parent
        return leftSum + rightSum + node.val;
    }
}
