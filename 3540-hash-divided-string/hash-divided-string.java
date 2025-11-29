class Solution {
    public String stringHash(String s, int k) {
        StringBuilder result = new StringBuilder();
        int n = s.length();

        for (int i = 0; i < n; i += k) {
            int sum = 0;
            
            // Process substring of length k
            for (int j = i; j < i + k; j++) {
                sum += s.charAt(j) - 'a'; // hash value of character
            }

            int hashedChar = sum % 26;
            result.append((char) (hashedChar + 'a'));
        }

        return result.toString();
    }
}
