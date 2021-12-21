package com.gatsby;

/**
 * @author -- gatsby
 * @date -- 2021/12/21
 * @description -- 1154 日期是一年的第几天
 */


public class _1154DayOfTheYear {
    public int dayOfYear(String date) {
        String[] dates = date.split("-");
        int year = Integer.parseInt(dates[0]);
        int month = Integer.parseInt(dates[1]);
        int day = Integer.parseInt(dates[2]);
        boolean isLeapYear = year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);

        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (isLeapYear) days[1]++;
        int res = 0;
        for (int i = 0; i < month - 1; ++i) {
            res += days[i];
        }
        return res + day;
    }

    public static void main(String[] args) {
        String date = "2021-12-21";
        _1154DayOfTheYear solution = new _1154DayOfTheYear();
        System.out.println(solution.dayOfYear(date));
    }
}