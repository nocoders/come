package com.sword.www.leetCode.medium;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例 1：
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 *
 * 提示：
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xv8ka1/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author linmeng
 * @version 1.0
 * @date 2021年4月8日 21:34
 */
public class L_17 {

    private static final Map<Character,Character[]> MAP;
    static {
        MAP=new HashMap<>();
        MAP.put('2',new Character[]{'a','b','c'});
        MAP.put('3',new Character[]{'d','e','f'});
        MAP.put('4',new Character[]{'g','h','i'});
        MAP.put('5',new Character[]{'j','k','l'});
        MAP.put('6',new Character[]{'m','n','o'});
        MAP.put('7',new Character[]{'p','q','r','s'});
        MAP.put('8',new Character[]{'t','u','v'});
        MAP.put('9',new Character[]{'w','x','y','z'});
    }
    /**
     * 深度遍历
     *
     * @param digits
     * @author linmeng
     * @date 2021年4月8日 21:38
     * @return java.util.List<java.lang.String>
     */
    public List<String> letterCombinations(String digits) {
        ArrayList<String> res = new ArrayList<>();
        if (StringUtils.isBlank(digits)){
            return res;
        }
        backTrack(digits,res,0,digits.length(),new StringBuilder());
        return res;
    }

    private void backTrack(String digits, ArrayList<String> res, int i, int length, StringBuilder sb) {
        if (i==length){
            res.add(sb.toString());
        }else {
            Character[] chars = MAP.get(digits.charAt(i));
            for (int j = 0; j < chars.length; j++) {
                sb.append(chars[j]);
                backTrack(digits,res,i+1,length,sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}
