import java.util.Arrays;

public class Solution {
    private static final long MOD = 1_000_000_007L;

    public int numPrimeArrangements(int n) {
        int p = countPrimes(n);
        long ans = 1L;
        for (int i = 1; i <= p; i++) ans = (ans * i) % MOD;
        for (int i = 1; i <= n - p; i++) ans = (ans * i) % MOD;
        return (int) ans;
    }

    private int countPrimes(int n) {
        if (n < 2) return 0;
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) isPrime[j] = false;
            }
        }
        int cnt = 0;
        for (int i = 2; i <= n; i++) if (isPrime[i]) cnt++;
        return cnt;
    }

    // quick test
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numPrimeArrangements(5));   // expected 12
        System.out.println(s.numPrimeArrangements(100)); // expected 682289015
    }
}
