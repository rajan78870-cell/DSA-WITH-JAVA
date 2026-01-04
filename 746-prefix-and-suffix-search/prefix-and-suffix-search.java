import java.util.*;

class WordFilter {

    private Map<String, Integer> map;

    public WordFilter(String[] words) {
        map = new HashMap<>();

        for (int index = 0; index < words.length; index++) {
            String word = words[index];
            int len = word.length();

            // generate all suffix + "#" + prefix combinations
            for (int i = 0; i <= len; i++) {
                String suffix = word.substring(i);
                for (int j = 0; j <= len; j++) {
                    String prefix = word.substring(0, j);
                    map.put(suffix + "#" + prefix, index);
                }
            }
        }
    }

    public int f(String pref, String suff) {
        return map.getOrDefault(suff + "#" + pref, -1);
    }
}
