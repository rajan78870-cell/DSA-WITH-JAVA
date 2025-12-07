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

class Solution {
    public TreeNode pruneTree(TreeNode root) {
        return containsOne(root) ? root : null;
    }

    private boolean containsOne(TreeNode node) {
        if (node == null) return false;

        // Check left subtree
        boolean leftContainsOne = containsOne(node.left);
        if (!leftContainsOne) {
            node.left = null; // Prune left subtree
        }

        // Check right subtree
        boolean rightContainsOne = containsOne(node.right);
        if (!rightContainsOne) {
            node.right = null; // Prune right subtree
        }

        // Return true if current node or any subtree contains 1
        return node.val == 1 || leftContainsOne || rightContainsOne;
    }
}
