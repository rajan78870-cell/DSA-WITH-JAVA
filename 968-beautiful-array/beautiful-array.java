import java.util.*;

class Solution {
    public int[] beautifulArray(int n) {
        List<Integer> result = build(n);
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) ans[i] = result.get(i);
        return ans;
    }

    private List<Integer> build(int n) {
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(1);
            return res;
        }

        // Build odd part: elements = 2*x - 1
        List<Integer> odd = build((n + 1) / 2);
        for (int x : odd) res.add(2 * x - 1);

        // Build even part: elements = 2*x
        List<Integer> even = build(n / 2);
        for (int x : even) res.add(2 * x);

        return res;
    }
}
