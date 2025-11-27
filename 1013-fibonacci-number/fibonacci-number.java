class Solution { 

    int fibonicci(int n, int[] dp) {

        if(n <= 1) return n;

        if(dp[n] != -1) return dp[n];

        return dp[n] = fibonicci(n - 1, dp) + fibonicci(n - 2, dp);
    }

    public int fib(int n) {

        int[] dp = new int[n + 1];

        for(int i = 0; i <= n; i++){
            dp[i] = -1;
        }

        return fibonicci(n, dp);
    }
}
