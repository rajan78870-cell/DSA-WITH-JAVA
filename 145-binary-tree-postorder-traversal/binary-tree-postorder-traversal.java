import java.util.*;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

class Solution {

    // Wrapper method expected by driver
    public List<Integer> postorderTraversal(TreeNode root) {
        // You can switch between recursive and iterative easily
        return postorderRecursive(root);
        // return postorderIterative(root);
    }

    // --------------------------
    // 1. Recursive Postorder
    // --------------------------
    private List<Integer> postorderRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderHelper(root, result);
        return result;
    }

    private void postorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) return;
        postorderHelper(node.left, result);   // Left
        postorderHelper(node.right, result);  // Right
        result.add(node.val);                 // Root
    }

    // --------------------------
    // 2. Iterative Postorder
    // --------------------------
    private List<Integer> postorderIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.peek();

            if (root.right == null || root.right == prev) {
                result.add(root.val);
                stack.pop();
                prev = root;
                root = null;
            } else {
                root = root.right;
            }
        }

        return result;
    }
}
