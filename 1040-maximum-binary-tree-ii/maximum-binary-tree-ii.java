class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        // If tree is empty or val is greater than root
        if (root == null || val > root.val) {
            TreeNode newNode = new TreeNode(val);
            newNode.left = root;
            return newNode;
        }

        // Otherwise, insert into right subtree
        root.right = insertIntoMaxTree(root.right, val);
        return root;
    }
}
