package com.gatsby.tencent.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _22GenerateParentheses
 * @Description: leetcode 22 括号生成
 * @author: Gatsby
 * @date: 2022/3/11 17:51
 */

public class _22GenerateParentheses {
    /**
     * @MethodName:  backTrack
     * @Parameter: [stringBuilder, left, right, n, res]
     * @Return void
     * @Description: 如果左括号的数量仍然少于n，那么还是可以加左括号的
     * 如果右括号的数量仍然少于左括号，那么还是可以加右括号的
     * @author: Gatsby
     * @date:  2022/3/11 18:10
     */
    private void backTrack(StringBuilder stringBuilder, int left, int right, int n, List<String> res) {
        if (stringBuilder.length() == 2 * n) {
            res.add(stringBuilder.toString());
        }
        if (left < n) {
            stringBuilder.append("(");
            backTrack(stringBuilder, left + 1, right, n, res);
            // 做完加左括号的分支之后需要还原为没有加左括号的情况，也就是需要回溯
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
        if (left > right) {
            stringBuilder.append(")");
            backTrack(stringBuilder, left, right + 1, n, res);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        backTrack(stringBuilder, 0, 0, n, res);
        return res;
    }
}


