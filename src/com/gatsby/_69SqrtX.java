package com.gatsby;

/**
 * @ClassName: _69SqrtX
 * @Description: leetcode 69 x的平方根
 * @author: Gatsby
 * @date: 2022/5/8 10:10
 */

/*
while (low <= high) {
    long mid = low + (high - low) / 2;
    long r = mid * mid;
    if (r > x) high = mid - 1;
    e
    else return (ilse if (r < x) low = mid + 1;nt) mid;
}
return (int) low - 1;
*/
/*
while (low < high) {
    long mid = low + (high - low) / 2;
    long r = mid * mid;
    if (r > x) high = mid;
    else if (r < x) low = mid + 1;
    else return (int) mid;
}
return (int) low - 1;
*/
/*
while (low < high) {
    long mid = low + (high - low + 1) / 2;
    long r = mid * mid;
    if (r > x) high = mid - 1;
    else if (r < x) low = mid;
    else return (int) mid;
}
return (int) low;
 */
public class _69SqrtX {
    public int mySqrtBS(int x) {
        if (x == 0) return 0;
        if (x == 1) return 1;

        int left = 1;
        int right = x/2;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                left = mid;
            };
        }
        return left;
    }
}


