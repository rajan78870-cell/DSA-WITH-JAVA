class Solution {
    public String maximumOddBinaryNumber(String s) {
        int ones = 0, zeros = 0;

        for (char c : s.toCharArray()) {
            if (c == '1') ones++;
            else zeros++;
        }

        StringBuilder sb = new StringBuilder();

        // place (ones - 1) ones at the front
        for (int i = 0; i < ones - 1; i++) {
            sb.append('1');
        }

        // place all zeros
        for (int i = 0; i < zeros; i++) {
            sb.append('0');
        }

        // place last 1 to make number odd
        sb.append('1');

        return sb.toString();
    }
}
