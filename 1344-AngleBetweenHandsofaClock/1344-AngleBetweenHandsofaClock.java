// Last updated: 12/07/2026, 15:35:16
1class Solution {
2    public double angleClock(int hour, int minutes) {
3         double minuteAngle = minutes * 6;
4        double hourAngle = (hour % 12) * 30 + minutes * 0.5;
5        double angle = Math.abs(hourAngle - minuteAngle);
6        return Math.min(angle, 360 - angle);
7    }
8}