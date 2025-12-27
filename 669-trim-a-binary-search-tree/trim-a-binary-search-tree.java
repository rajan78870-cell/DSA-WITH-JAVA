class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }

        // If current node is smaller than low, discard left subtree
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }

        // If current node is greater than high, discard right subtree
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }

        // Node is within range, trim both subtrees
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        return root;
    }
}
