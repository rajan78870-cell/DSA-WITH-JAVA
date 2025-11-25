class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2,
                           int bx1, int by1, int bx2, int by2) {

        // Area of first rectangle
        int area1 = (ax2 - ax1) * (ay2 - ay1);

        // Area of second rectangle
        int area2 = (bx2 - bx1) * (by2 - by1);

        // Find overlap width
        int overlapWidth = Math.min(ax2, bx2) - Math.max(ax1, bx1);

        // Find overlap height
        int overlapHeight = Math.min(ay2, by2) - Math.max(ay1, by1);

        int overlapArea = 0;

        // If both width and height are positive, overlap exists
        if (overlapWidth > 0 && overlapHeight > 0) {
            overlapArea = overlapWidth * overlapHeight;
        }

        return area1 + area2 - overlapArea;
    }
}
