// Last updated: 24/10/2026, 10:28:23
1class Solution {
2    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
3        int arriveAliceDay = convertToDays(arriveAlice);
4        int leaveAliceDay = convertToDays(leaveAlice);
5        int arriveBobDay = convertToDays(arriveBob);
6        int leaveBobDay = convertToDays(leaveBob);
7        int start = Math.max(arriveAliceDay, arriveBobDay);
8        int end = Math.min(leaveAliceDay, leaveBobDay);
9        return Math.max(0, end - start + 1);
10    }
11    private int convertToDays(String date) {
12        int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
13        int month = Integer.parseInt(date.substring(0, 2));
14        int day = Integer.parseInt(date.substring(3, 5));
15        int totalDays = day;
16        for (int i = 0; i < month - 1; i++) {
17            totalDays += daysInMonths[i];
18        }
19        return totalDays;
20    }
21}