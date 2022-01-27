package com.gatsby;

/**
 * @author -- gatsby
 * @date -- 2022/1/26
 * @description -- leetcode 486 预测赢家
 */


public class _486PredictTheWinner {
    /*
     * @author -- gatsby
     * @description -- 计算玩家1-玩家2得到一个分数，这个分数的正负值用来判断结果true or false
     * turn这个参数用来控制，diff是玩家1-玩家2还是-玩家1+玩家2，这样才能将谁先取这个条件量化
     * player1的得分score1
     * player2的得分score2
     * 那么diff = score1 - score2 >= 0，根据题意，返回true，反之false。
     * 已知，如果player1的回合，那么就是score1 - score2；如果是player2的回合，那么是-score1 + score2，
     * 并且已知，两人的回合是交替的，也就是可以通过控制turn不断自身取反来控制score前的符号。
     * 如果递归，start++，end--，递归的结束条件就是start == end，在这一回合，只有一个人拿，且不用再turn取反了。
     *
     * @data -- 2022/1/26
     * @param -- [nums, start, end, turn]
     * @return -- int
     */
    private int culDiff(int[] nums, int start, int end, int turn) {
        if (start == end) {
            return nums[start] * turn;
        }

        int pickStart = nums[start] * turn + culDiff(nums, start + 1, end, -turn);
        int pickEnd = culDiff(nums, start, end - 1, -turn) + nums[end] * turn;

        if (turn == 1) return Math.max(pickStart, pickEnd);
        else return Math.min(pickStart, pickEnd);
    }

    public boolean PredictTheWinnerRecur(int[] nums) {
        return culDiff(nums, 0, nums.length - 1, 1) >= 0;
    }

    /*
     * @author -- gatsby
     * @description -- 但是这类博弈问题的常规解法是DP，把每种结果都记录下来。
     * 假设在数组只剩下index start-end的部分，那么我们可以选出最好的选择。
     * 我们先设想当start==end的时候，也就是说只剩下一个的时候，对于玩家来说只能选这个，最佳方案也就是nums[start](nums[end])。
     * 也就是说中间的对角线可以先初始化为nums[i]。
     * 接下来考虑还剩下两个元素的时候，一共就只有两种选择，选择nums[start]或者nums[end]
     * 如果当前的玩家选择的是start：那么nums[start]是自己的新得分，dp[start+1][end]是对手的得分；
     * 如果当前的玩家选择的是end：那么nums[end]就是自己的新得分，dp[start][end-1]是对手的得分。
     * 要使得自己的优势最大，就要选择nums[start]-dp[start+1][end]和nums[end]-dp[start][end-1]较大的那个方案。
     * DP的思路和上面递归的思路有点类似，但是又不完全一样。
     * 递归只考虑最大层面的最优解，DP考虑的是每次当前用户选择出来的最优解。
     * 最终dp[0][n-1]代表的意思是，第一轮拿的人，能不能得分大于等于0，因为此题中玩家1先拿，所以大于等于零就是符合题意的。
     * @data -- 2022/1/27
     * @param -- [nums]
     * @return -- boolean
    */
    public boolean PredictTheWinner(int[] nums) {
        final int n = nums.length;
        int[][] dp = new int[n][n];
        // dp[start][end] = max(nums[i]-dp[start+1][end], nums[j]-dp[start][end-1])
        for (int i = 0; i < n; ++i) {
            dp[i][i] = nums[i];
        }

        for (int i = n - 2; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1] >= 0;
    }

    public static void main(String[] args) {
        int[] nums = {0};
        _486PredictTheWinner solution = new _486PredictTheWinner();
        System.out.println(solution.PredictTheWinnerRecur(nums));
    }
}