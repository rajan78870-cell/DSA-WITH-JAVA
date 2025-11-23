// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
}

class Solution {
    // --- wrapper expected by the driver ---
    public TreeNode searchBST(TreeNode root, int val) {
        // choose iterative or recursive implementation
        return searchBSTIterative(root, val);
        // return searchBSTRecursive(root, val);
    }

    // Recursive implementation
    public TreeNode searchBSTRecursive(TreeNode root, int val) {
        if (root == null || root.val == val) return root;
        if (val < root.val) return searchBSTRecursive(root.left, val);
        else return searchBSTRecursive(root.right, val);
    }

    // Iterative implementation
    public TreeNode searchBSTIterative(TreeNode root, int val) {
        while (root != null) {
            if (root.val == val) return root;
            root = (val < root.val) ? root.left : root.right;
        }
        return null;
    }
}
