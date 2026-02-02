class Solution {
    public String sortSentence(String s) {
        String[] words = s.split(" ");
        String[] result = new String[words.length];

        for (String word : words) {
            int n = word.length();
            int index = word.charAt(n - 1) - '0'; // get position
            result[index - 1] = word.substring(0, n - 1); // remove digit
        }

        return String.join(" ", result);
    }
}
