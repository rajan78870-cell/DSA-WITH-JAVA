import java.util.*;

class Solution {
    public int minArraySum(int[] nums, int k, int op1, int op2) {
        int n = nums.length;
        int INF = 1_000_000_000;

        // dp[i][a][b] = min sum using first i elements, using a op1 and b op2
        int[][][] dp = new int[n + 1][op1 + 1][op2 + 1];

        for (int i = 0; i <= n; i++)
            for (int a = 0; a <= op1; a++)
                for (int b = 0; b <= op2; b++)
                    dp[i][a][b] = INF;

        dp[0][0][0] = 0;

        for (int i = 1; i <= n; i++) {
            int x = nums[i - 1];

            for (int a = 0; a <= op1; a++) {
                for (int b = 0; b <= op2; b++) {

                    // 1) do nothing
                    dp[i][a][b] = Math.min(dp[i][a][b],
                            dp[i - 1][a][b] + x);

                    // 2) only op1
                    if (a > 0) {
                        int v1 = (x + 1) / 2;
                        dp[i][a][b] = Math.min(dp[i][a][b],
                                dp[i - 1][a - 1][b] + v1);
                    }

                    // 3) only op2
                    if (b > 0 && x >= k) {
                        int v2 = x - k;
                        dp[i][a][b] = Math.min(dp[i][a][b],
                                dp[i - 1][a][b - 1] + v2);
                    }

                    // 4) both operations
                    if (a > 0 && b > 0) {
                        int best = INF;

                        // op1 then op2
                        int t1 = (x + 1) / 2;
                        if (t1 >= k)
                            best = Math.min(best, t1 - k);

                        // op2 then op1
                        if (x >= k) {
                            int t2 = x - k;
                            best = Math.min(best, (t2 + 1) / 2);
                        }

                        if (best < INF) {
                            dp[i][a][b] = Math.min(dp[i][a][b],
                                    dp[i - 1][a - 1][b - 1] + best);
                        }
                    }
                }
            }
        }

        int ans = INF;
        for (int a = 0; a <= op1; a++)
            for (int b = 0; b <= op2; b++)
                ans = Math.min(ans, dp[n][a][b]);

        return ans;
    }
}
