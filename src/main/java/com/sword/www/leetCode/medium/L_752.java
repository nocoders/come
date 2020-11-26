package com.sword.www.leetCode.medium;

import java.util.*;

/**
 * 752. 打开转盘锁
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
 * 示例 1:
 * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * 输出：6
 * 解释：
 * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
 * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
 * 因为当拨动到 "0102" 时这个锁就会被锁定。
 * 示例 2:
 * 输入: deadends = ["8888"], target = "0009"
 * 输出：1
 * 解释：
 * 把最后一位反向旋转一次即可 "0000" -> "0009"。
 * 示例 3:
 * 输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 * 输出：-1
 * 解释：
 * 无法旋转到目标数字且不被锁定。
 * 示例 4:
 * 输入: deadends = ["0000"], target = "8888"
 * 输出：-1
 * 提示：
 * 死亡列表 deadends 的长度范围为 [1, 500]。
 * 目标数字 target 不会在 deadends 之中。
 * 每个 deadends 和 target 中的字符串的数字会在 10,000 个可能的情况 '0000' 到 '9999' 中产生。
 * @author linmeng
 * @version 1.0
 * @date 2020年11月26日 09:12
 */
public class L_752 {

    public static void main(String[] args) {
        String [] deadends = {"8887","8889","8878","8898","8788","8988","7888","9888"};
        int i = openLock(deadends, "8888");
        System.out.println(i);
    }

    /**
     * 从"0000" 到 target，只能对每位进行加一减一操作，不能碰到deadends里面的元素。
     *
     * 定义 一个队列保存未被遍历的元素，以null值区分。
     * 再定义一个队列保存已经走过的路，减少重复
     *
     * @param deadends
     * @param target
     * @author linmeng
     * @date 2020年11月26日 11:12
     * @return int
     */
    public static int openLock(String[] deadends, String target) {
        // 保存不能走的元素
        Set<String> deadSet = new HashSet<>();
        Collections.addAll(deadSet,deadends);
        // 队列维护走的路进行广度优先搜索
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        // 集合保存已经走过的路，防止重复行走
        HashSet<String> seen = new HashSet<>();
        seen.add("0000");
        queue.offer(null);
        int depthCount = 0;
        while (!queue.isEmpty()){
            String poll = queue.poll();
            if (poll==null){
                depthCount++;
                if (queue.peek()!=null){
                    queue.offer(null);
                }
            }else if (target.equals(poll)){
                return depthCount;
            }else if (!deadSet.contains(poll)){
                for (int i = 0; i < 4; i++) {
                    String str1 = poll.substring(0,i)+(poll.charAt(i)-'0'+9)%10+poll.substring(i+1);
                    if (!seen.contains(str1)){
                        queue.offer(str1);
                        seen.add(str1);
                    }
                    String str2 = poll.substring(0,i)+(poll.charAt(i)-'0'+1)%10+poll.substring(i+1);
                    if (!seen.contains(str2)){
                        queue.offer(str2);
                        seen.add(str2);
                    }
                }
            }
        }


        return -1;
    }
}
