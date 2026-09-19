// Last updated: 19/09/2026, 23:22:24
1class Solution {
2    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
3        int closestX = Math.max(x1, Math.min(xCenter, x2));
4        int closestY = Math.max(y1, Math.min(yCenter, y2));
5        
6        int distanceX = xCenter - closestX;
7        int distanceY = yCenter - closestY;
8        
9        return (distanceX * distanceX + distanceY * distanceY) <= (radius * radius);
10    }
11}