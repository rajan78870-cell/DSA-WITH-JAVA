import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;

        dfs(root, "", result);
        return result;
    }

    private void dfs(TreeNode node, String path, List<String> result) {
        if (node == null) return;

        // Add current node value to path
        path += node.val;

        // If it's a leaf, add the complete path to result
        if (node.left == null && node.right == null) {
            result.add(path);
        } else {
            // Continue to explore children
            path += "->";
            dfs(node.left, path, result);
            dfs(node.right, path, result);
        }
    }
}
