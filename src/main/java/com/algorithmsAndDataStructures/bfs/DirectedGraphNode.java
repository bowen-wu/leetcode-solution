package com.algorithmsAndDataStructures.bfs;

import java.util.ArrayList;
import java.util.List;

public class DirectedGraphNode {
    private int no;
    private List<DirectedGraphNode> adjacencyNodes;

    public DirectedGraphNode(int no, List<DirectedGraphNode> adjacencyNodes) {
        this.no = no;
        this.adjacencyNodes = adjacencyNodes;
    }

    public DirectedGraphNode(int no) {
        this.no = no;
        this.adjacencyNodes = new ArrayList<>();
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public List<DirectedGraphNode> getAdjacencyNodes() {
        return adjacencyNodes;
    }

    public void setAdjacencyNodes(List<DirectedGraphNode> adjacencyNodes) {
        this.adjacencyNodes = adjacencyNodes;
    }
}

