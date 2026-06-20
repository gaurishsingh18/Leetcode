// Last updated: 20/06/2026, 23:46:04
1class Solution {
2    public double[] convertTemperature(double celsius) {
3        double kelvin = celsius + 273.15;
4        double farenheit = celsius * 1.80 + 32.00;
5        return new double[]{kelvin, farenheit};
6    }
7}