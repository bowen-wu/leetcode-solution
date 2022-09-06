package com.algorithmsAndDataStructures.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UndirectedGraph {
    // 邻接表 => key: 当前节点  value: 邻接节点集合
    private final Map<Node, List<Node>> adjacencyList;

    // 是否被访问涂色过
    private final boolean[] marked;

    // 统计连通分量
    private int connectComponentCount;

    public UndirectedGraph(int vertexCount) {
        this.adjacencyList = new HashMap<>();
        this.marked = new boolean[vertexCount];
        this.connectComponentCount = 0;
    }

    // Method
    public void addVertex(Node v) {
        if (!adjacencyList.containsKey(v)) {
            adjacencyList.put(v, new ArrayList<>());
        }
    }

    public void addEdge(Node u, Node v) {
        if (!adjacencyList.containsKey(u)) {
            addVertex(u);
        }
        if (!adjacencyList.containsKey(v)) {
            addVertex(v);
        }
        adjacencyList.get(u).add(v);
        adjacencyList.get(v).add(u);
    }

    public void printGraph() {
        for (Node key : adjacencyList.keySet()) {
            System.out.println(key.getNo() + ": " + adjacencyList.get(key).stream().map(Node::getNo).map(String::valueOf).collect(Collectors.joining(",", "[", "]")));
        }
    }

    // DFS 模板 => 遍历全图
    public void dfsInGraph() {
        Arrays.fill(marked, false);
        for (Node startNode : adjacencyList.keySet()) {
            if (!marked[startNode.getNo()]) {
                helper(startNode);
                connectComponentCount++;
            }
        }
    }

    // DFS 模板 => 以 start 节点为起点在某一连通分量上 DFS
    public void dfsInComponent(Node start) {
        Arrays.fill(marked, false);
        helper(start);
    }

    // DFS helper 函数
    public void helper(Node start) {
        marked[start.getNo()] = true;
        System.out.println("DFS current node: " + start.getNo() + " value: " + start.getValue());

        for (Node adjNode : adjacencyList.get(start)) {
            if (!marked[adjNode.getNo()]) {
                // 没有被访问过
                helper(adjNode);
            }
        }
    }

    public static void main(String[] args) {
        // 0 - 1 - 4
        // |   | /
        // 2 - 3
        UndirectedGraph undirectedGraph = new UndirectedGraph(7);
        Node zero = new Node(0, 1);
        Node one = new Node(1, 2);
        Node two = new Node(2, 3);
        Node three = new Node(3, 4);
        Node four = new Node(4, 5);
        Node five = new Node(5, 6);
        Node six = new Node(6, 7);
        undirectedGraph.addEdge(zero, one);
        undirectedGraph.addEdge(zero, two);
        undirectedGraph.addEdge(one, four);
        undirectedGraph.addEdge(one, three);
        undirectedGraph.addEdge(three, two);
        undirectedGraph.addEdge(three, four);
        undirectedGraph.addEdge(five, six);
        undirectedGraph.printGraph();
        System.out.println("Starting from node 0");
        undirectedGraph.dfsInComponent(zero);
        System.out.println("Starting from node 1");
        undirectedGraph.dfsInComponent(one);
        System.out.println("Traversal graph");
        undirectedGraph.dfsInGraph();
        System.out.println(undirectedGraph.connectComponentCount);
    }

}

class Node {
    int no;
    int value;

    public Node(int no, int value) {
        this.no = no;
        this.value = value;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
