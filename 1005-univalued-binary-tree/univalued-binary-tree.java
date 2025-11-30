import java.util.LinkedList;
import java.util.Queue;

class Solution {

    // ---- DFS Method ----
    public boolean isUnivalTreeDFS(TreeNode root) {
        return dfs(root, root.val);
    }

    private boolean dfs(TreeNode node, int value) {
        if (node == null) return true;
        if (node.val != value) return false;

        return dfs(node.left, value) && dfs(node.right, value);
    }

    // ---- BFS Method ----
    public boolean isUnivalTreeBFS(TreeNode root) {
        if (root == null) return true;

        int value = root.val;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.val != value) return false;

            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }

        return true;
    }

    // ---- Main method that uses DFS by default ----
    public boolean isUnivalTree(TreeNode root) {
        return isUnivalTreeDFS(root); // or change to isUnivalTreeBFS(root);
    }
}
