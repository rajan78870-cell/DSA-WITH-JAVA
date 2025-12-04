class Solution {
    public int countCollisions(String directions) {
        int n = directions.length();
        int left = 0, right = n - 1;
        
        // Remove left 'L's (they never collide)
        while (left < n && directions.charAt(left) == 'L') {
            left++;
        }

        // Remove right 'R's (they never collide)
        while (right >= 0 && directions.charAt(right) == 'R') {
            right--;
        }

        int count = 0;
        
        // Count remaining non-'S' cars in middle, they will collide
        for (int i = left; i <= right; i++) {
            if (directions.charAt(i) != 'S') {
                count++;
            }
        }

        return count;
    }
}
