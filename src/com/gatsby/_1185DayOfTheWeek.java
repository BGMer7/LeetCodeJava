package com.gatsby;

/**
 * @author -- gatsby
 * @date -- 2022/1/3
 * @description -- leetcode 1185 一周的第几天
 */


public class _1185DayOfTheWeek {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] week = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        if (month < 3) {
            month += 12;
            year -= 1;
        }
        return week[(day + 13 * (month + 1) / 5 + year + year / 4 - year / 100 + year / 400) % 7];
    }

    public static void main(String[] args) {
        _1185DayOfTheWeek solution = new _1185DayOfTheWeek();
        solution.dayOfTheWeek(1, 2, 2021);
    }
}