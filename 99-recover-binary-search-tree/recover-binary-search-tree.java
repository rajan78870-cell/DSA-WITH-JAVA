class Solution {
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        inorder(root);
        
        // Swap the two nodes' value
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);

        // Detect swapped nodes
        if (first == null && prev.val > root.val) {
            first = prev;
        }

        if (first != null && prev.val > root.val) {
            second = root;
        }

        prev = root;

        inorder(root.right);
    }
}
