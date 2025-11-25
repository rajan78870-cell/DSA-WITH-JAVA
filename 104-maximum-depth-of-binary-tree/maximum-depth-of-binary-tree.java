import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {

    // ----------------------------------------------------
    // Method 1: Recursive DFS (Most Common)
    // ----------------------------------------------------
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    // ----------------------------------------------------
    // Method 2: BFS (Level Order Traversal)
    // ----------------------------------------------------
    public int maxDepthBFS(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }

        return depth;
    }

    // ----------------------------------------------------
    // Testing the code
    // ----------------------------------------------------
    public static void main(String[] args) {
        Solution obj = new Solution();

        // Example 1: root = [3,9,20,null,null,15,7]
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);

        System.out.println(obj.maxDepth(root1));      // Output: 3
        System.out.println(obj.maxDepthBFS(root1));   // Output: 3

        // Example 2: root = [1,null,2]
        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(2);

        System.out.println(obj.maxDepth(root2));      // Output: 2
        System.out.println(obj.maxDepthBFS(root2));   // Output: 2
    }
}
