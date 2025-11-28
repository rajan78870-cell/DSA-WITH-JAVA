class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();

        for (int hour = 0; hour < 12; hour++) {
            for (int minute = 0; minute < 60; minute++) {
                // Count bits of hour + minute
                if (Integer.bitCount(hour) + Integer.bitCount(minute) == turnedOn) {
                    // Format minute to 2 digits (e.g., 01, 09, 32)
                    result.add(hour + ":" + String.format("%02d", minute));
                }
            }
        }

        return result;
    }
}
