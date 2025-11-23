
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // If both trees are empty
        if (p == null && q == null)
            return true;


        if (p == null || q == null)
            return false;


        return (p.val == q.val)
                && isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }
}

