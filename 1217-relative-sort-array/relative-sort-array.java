import java.util.*;

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> freq = new HashMap<>();

        // Count frequency of elements in arr1
        for (int num : arr1) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int[] result = new int[arr1.length];
        int index = 0;

        
        for (int num : arr2) {
            int count = freq.get(num);
            while (count-- > 0) {
                result[index++] = num;
            }
            freq.remove(num); 
        }

       
        List<Integer> remaining = new ArrayList<>();
        for (int key : freq.keySet()) {
            int count = freq.get(key);
            while (count-- > 0) {
                remaining.add(key);
            }
        }

        
        Collections.sort(remaining);

        
        for (int num : remaining) {
            result[index++] = num;
        }

        return result;
    }
}
