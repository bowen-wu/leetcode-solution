package com.algorithmsAndDataStructures.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class DirectedGraph {
    private final List<DirectedGraphNode> graphNodes;

    public DirectedGraph(List<DirectedGraphNode> graphNodes) {
        this.graphNodes = graphNodes;
    }

    public List<DirectedGraphNode> topologicalSort() {
        // 1. 计算每个图节点的入度，用 map 维护，key：当前图节点，value：入度值
        Map<DirectedGraphNode, Integer> inDegreeMap = new HashMap<>();
        for (DirectedGraphNode node : graphNodes) {
            for (DirectedGraphNode adjacencyNode : node.getAdjacencyNodes()) {
                inDegreeMap.merge(adjacencyNode, 1, Integer::sum);
            }
        }

        // 2. 将入度为 0 的节点入队
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        for (DirectedGraphNode node : graphNodes) {
            if (!inDegreeMap.containsKey(node)) {
                queue.offer(node);
            }
        }


        // 3. BFS
        List<DirectedGraphNode> topologicalList = new ArrayList<>();
        while (!queue.isEmpty()) {
            DirectedGraphNode node = queue.poll();
            topologicalList.add(node);

            // 得到节点的邻接节点，将所有邻接节点的入度减1，并更新 map => 若邻接节点更新后的入度为0，加入队列
            for (DirectedGraphNode adjacencyNode : node.getAdjacencyNodes()) {
                int newInDegree = inDegreeMap.get(adjacencyNode) - 1;
                inDegreeMap.put(adjacencyNode, newInDegree);
                if (newInDegree == 0) {
                    queue.offer(adjacencyNode);
                }
            }
        }

        return topologicalList;
    }

    public static void main(String[] args) {
        DirectedGraphNode node5 = new DirectedGraphNode(5);
        DirectedGraphNode node2 = new DirectedGraphNode(2, Collections.singletonList(node5));
        DirectedGraphNode node3 = new DirectedGraphNode(3, Collections.singletonList(node5));
        DirectedGraphNode node6 = new DirectedGraphNode(6, Collections.singletonList(node5));
        DirectedGraphNode node4 = new DirectedGraphNode(4, Arrays.asList(node5, node6));
        DirectedGraphNode node1 = new DirectedGraphNode(1, Arrays.asList(node2, node3, node4));
        List<DirectedGraphNode> graphNodes = Arrays.asList(node1, node2, node3, node4, node5, node6);
        DirectedGraph directedGraph = new DirectedGraph(graphNodes);
        List<DirectedGraphNode> directedGraphNodes = directedGraph.topologicalSort();
        directedGraphNodes.forEach(node -> System.out.println(node.getNo()));
    }
}
