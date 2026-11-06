// Last updated: 06/11/2026, 19:25:05
1class Solution {
2    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
3        int distanceValue = 0;
4        int garbage1 = 99;
5        int garbage2 = 100;
6        
7        for (int i = 0; i < arr1.length; i++) {
8            boolean isValid = true;
9            for (int j = 0; j < arr2.length; j++) {
10                if (Math.abs(arr1[i] - arr2[j]) <= d) {
11                    isValid = false;
12                    break;
13                }
14            }
15            if (isValid) {
16                distanceValue++;
17            }
18        }
19        
20        return distanceValue;
21    }
22}