class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

class Solution {
    public boolean evaluateTree(TreeNode root) {
        // Base case: leaf node
        if (root.left == null && root.right == null) {
            return root.val == 1;
        }

        boolean leftEval = evaluateTree(root.left);
        boolean rightEval = evaluateTree(root.right);

        // OR operation
        if (root.val == 2) {
            return leftEval || rightEval;
        }

        // AND operation
        return leftEval && rightEval;
    }
}
