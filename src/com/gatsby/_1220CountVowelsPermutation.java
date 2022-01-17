package com.gatsby;

/**
 * @author -- gatsby
 * @date -- 2022/1/17
 * @description -- leetcode 1220 统计元音字母序列的数目 动态规划
 * Each character is a lower case vowel ('a', 'e', 'i', 'o', 'u')
 * Each vowel 'a' may only be followed by an 'e'.
 * Each vowel 'e' may only be followed by an 'a' or an 'i'.
 * Each vowel 'i' may not be followed by another 'i'.
 * Each vowel 'o' may only be followed by an 'i' or a 'u'.
 * Each vowel 'u' may only be followed by an 'a'.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-vowels-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class _1220CountVowelsPermutation {
    /*
    根据题目列出来的条件，那么每一个状态方程其实都已经告诉我们了。
    前      后
    dp[a] = dp[e]
    dp[e] = dp[a]+dp[i]
    dp[i] = dp[a]+dp[e]+dp[o]+dp[u]
    dp[o] = dp[i]+dp[u]
    dp[u] = dp[a]
    这是在前面加字母

    如果要正序遍历还需要翻过来
    后      前
    dp[a] = dp[e]+dp[i]+dp[u]
    dp[e] = dp[a]+dp[i]
    dp[i] = dp[e]+dp[o]
    dp[o] = dp[i]
    dp[u] = dp[i]+dp[o]
     */
    /*
    public int countVowelPermutation(int n) {
        long mod = 1000000007;
        long[][] dp = new long[n + 1][5];
        for (int i = 0; i < 5; ++i) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < n + 1; ++i) {
            dp[i][0] = (dp[i - 1][1]) % mod;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % mod;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][4]) % mod;
            dp[i][3] = (dp[i - 1][2] + dp[i - 1][4]) % mod;
            dp[i][4] = (dp[i - 1][0]) % mod;
        }

        return (int) (dp[n][0] + dp[n][1] + dp[n][2] + dp[n][3] + dp[n][4]);
    }

     */

    public int countVowelPermutation(int n) {
        long mod = 1000000007;
        long[][] dp = new long[n + 1][5];
        for (int i = 0; i < 5; ++i) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < n + 1; ++i) {
            dp[i][0] = (dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][4]) % mod;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % mod;
            dp[i][2] = (dp[i - 1][1] + dp[i - 1][3]) % mod;
            dp[i][3] = (dp[i - 1][2]) % mod;
            dp[i][4] = (dp[i - 1][2] + dp[i - 1][3]) % mod;
        }

        long res = 0;
        for (int i = 0; i < 5; ++i) {
            res += (dp[n - 1][i]) % mod;
            res %= mod;
        }
        return (int) res;
    }

    public int countVowelPermutationInt(int n) {
        long mod = 1000000007;
        long a = 1, e = 1, i = 1, o = 1, u = 1;
        long resA = 0, resE = 0, resI = 0, resO = 0, resU = 0;
        for (int j = 0; j < n; ++j) {
            resA = (e + i + u) % mod;
            resE = (a + i) % mod;
            resI = (e + o) % mod;
            resO = i % mod;
            resU = (i + o) % mod;
            a = resA;
            e = resE;
            i = resI;
            o = resO;
            u = resU;
        }

        long res = 0;
        res += resA % mod;
        res %= mod;
        res += resE % mod;
        res %= mod;
        res += resI % mod;
        res %= mod;
        res += resO % mod;
        res %= mod;
        res += resU % mod;
        res %= mod;
        return (int) res;
    }
}