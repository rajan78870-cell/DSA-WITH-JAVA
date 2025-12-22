// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    private TreeNode curr; // Keeps track of the current node in the new tree

    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummy = new TreeNode(0); // Temporary dummy node
        curr = dummy;
        inOrder(root);
        return dummy.right; // The real new root
    }

    private void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);          // Traverse left subtree
        node.left = null;            // Remove left child
        curr.right = node;           // Append current node to the right
        curr = node;                 // Move current pointer
        inOrder(node.right);         // Traverse right subtree
    }
}
