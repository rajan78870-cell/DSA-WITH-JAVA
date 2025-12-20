class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        while (root != null) {

            // both nodes are smaller → go left
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            }
            // both nodes are larger → go right
            else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            }
            // split happens here → this is LCAiit
            else {
                return root;
            }
        }
        return null;
    }
}
