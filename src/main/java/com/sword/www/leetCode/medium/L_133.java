package com.sword.www.leetCode.medium;

import java.util.*;

/**
 * 133. 克隆图
 * 给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
 *
 * 图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
 *
 * class Node {
 *     public int val;
 *     public List<Node> neighbors;
 * }
 *
 * 测试用例格式：
 * 简单起见，每个节点的值都和它的索引相同。例如，第一个节点值为 1（val = 1），第二个节点值为 2（val = 2），以此类推。该图在测试用例中使用邻接列表表示。
 * 邻接列表 是用于表示有限图的无序列表的集合。每个列表都描述了图中节点的邻居集。
 * 给定节点将始终是图中的第一个节点（值为 1）。你必须将 给定节点的拷贝 作为对克隆图的引用返回。
 * 示例 1：
 * 输入：adjList = [[2,4],[1,3],[2,4],[1,3]]
 * 输出：[[2,4],[1,3],[2,4],[1,3]]
 * 解释：
 * 图中有 4 个节点。
 * 节点 1 的值是 1，它有两个邻居：节点 2 和 4 。
 * 节点 2 的值是 2，它有两个邻居：节点 1 和 3 。
 * 节点 3 的值是 3，它有两个邻居：节点 2 和 4 。
 * 节点 4 的值是 4，它有两个邻居：节点 1 和 3 。
 * 示例 2：
 * 输入：adjList = [[]]
 * 输出：[[]]
 * 解释：输入包含一个空列表。该图仅仅只有一个值为 1 的节点，它没有任何邻居。
 * 示例 3：
 * 输入：adjList = []
 * 输出：[]
 * 解释：这个图是空的，它不含任何节点。
 * 示例 4：
 * 输入：adjList = [[2],[1]]
 * 输出：[[2],[1]]
 * 提示：
 * 节点数不超过 100 。
 * 每个节点值 Node.val 都是唯一的，1 <= Node.val <= 100。
 * 无向图是一个简单图，这意味着图中没有重复的边，也没有自环。
 * 由于图是无向的，如果节点 p 是节点 q 的邻居，那么节点 q 也必须是节点 p 的邻居。
 * 图是连通图，你可以从给定节点访问到所有节点。
 *
 * @author linmeng
 * @version 1.0
 * @date 2020年12月4日 17:22
 */
public class L_133 {
    public static void main(String[] args) {
        Node node = new Node(1, new ArrayList<>());
        Node node2 = new Node(2, new ArrayList<>());
        Node node3 = new Node(3, new ArrayList<>());
        Node node4 = new Node(4, new ArrayList<>());
        node.neighbors.add(node2);
        node.neighbors.add(node3);
        node2.neighbors.add(node4);
        node3.neighbors.add(node4);
        Node node1 = cloneGraph2(node);
        System.out.println();
    }

    Map<Node,Node> visited = new HashMap<>();
    /**
     *  深度
     * 深度 优先搜索，使用map保存已经克隆过的node，先判断当前code有没有被克隆，没有的话new一个node ，
     * 把val放进去，然后遍历他的neighbor，递归获取neighbor中元素并克隆
     * @param node
     * @author linmeng
     * @date 2020年12月12日 14:28
     * @return com.sword.www.leetCode.medium.L_133.Node
     */
    public Node cloneGraph(Node node) {
        if (node==null){
            return null;
        }
        if (visited.containsKey(node)){
            return visited.get(node);
        }
        Node cloneNode = new Node(node.val, new ArrayList<>());

        visited.put(node,cloneNode);
        node.neighbors.forEach(neighbor-> cloneNode.neighbors.add(cloneGraph(neighbor)));

        return cloneNode;
    }
    public static Node cloneGraph2(Node node) {
        if (node==null){
            return null;
        }
        Map<Node,Node> visited = new HashMap<>();
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(node);
        visited.put(node,new Node(node.val,new ArrayList<>()));
        while (!queue.isEmpty()){
            Node remove = queue.remove();
            for (Node neighbor : remove.neighbors) {
                if (!visited.containsKey(neighbor)){
                    visited.put(neighbor,new Node(neighbor.val,new ArrayList<>()));
                    queue.add(neighbor);
                }
                visited.get(remove).neighbors.add(visited.get(neighbor));
            }

        }
        return visited.get(node);
    }
    static class Node {

        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
