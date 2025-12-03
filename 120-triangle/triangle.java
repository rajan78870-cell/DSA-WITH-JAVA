import java.util.List;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        // Create a DP array initialized with the last row
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }

        // Start from the second last row and move upwards
        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                // Choose the minimum path sum between adjacent numbers in the row below
                dp[col] = triangle.get(row).get(col) + Math.min(dp[col], dp[col + 1]);
            }
        }

        // The top element contains the minimum path sum
        return dp[0];
    }

    // Example usage
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        List<List<Integer>> triangle1 = List.of(
            List.of(2),
            List.of(3, 4),
            List.of(6, 5, 7),
            List.of(4, 1, 8, 3)
        );
        System.out.println(sol.minimumTotal(triangle1)); // Output: 11

        List<List<Integer>> triangle2 = List.of(
            List.of(-10)
        );
        System.out.println(sol.minimumTotal(triangle2)); // Output: -10
    }
}
