import java.util.*;

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products); // Sort products lexicographically
        List<List<String>> result = new ArrayList<>();
        
        String prefix = "";
        for (char c : searchWord.toCharArray()) {
            prefix += c;
            result.add(findSuggestions(products, prefix));
        }
        
        return result;
    }
    
    private List<String> findSuggestions(String[] products, String prefix) {
        List<String> suggestions = new ArrayList<>();
        
        // Binary search to find the first position where prefix could appear
        int index = Arrays.binarySearch(products, prefix);
        
        if (index < 0) {
            index = -(index + 1); // Convert search result into insertion point
        }
        
        // Collect up to 3 matching products
        for (int i = index; i < products.length && suggestions.size() < 3; i++) {
            if (products[i].startsWith(prefix)) {
                suggestions.add(products[i]);
            } else {
                break;
            }
        }
        
        return suggestions;
    }
}
