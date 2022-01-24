package com.gatsby.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author -- gatsby
 * @date -- 2022/1/24
 * @description -- 邻接表
 */


public class AdjacencyList {
    private List<List<Integer>> adjacencyList;
    private List<Integer> vertex;

    public AdjacencyList() {
        this.adjacencyList = new ArrayList<>();
        this.vertex = new ArrayList<>();
    }

    public boolean addVertex(int n) {
        vertex.add(n);
        // 如果添加了节点，那么需要邻接表也加一行
        for (int i = adjacencyList.size(); i < vertex.size(); ++i) {
            adjacencyList.add(new ArrayList<>());
        }
        return true;
    }

    public boolean addEdge(int vertexStart, int vertexEnd) {
        adjacencyList.get(vertexStart).add(vertexEnd);
        // 无向图才需要两个方向都加以下，如果是有向图只需要一个方向
        // adjacencyList.get(vertexEnd).add(vertexStart);
        return true;
    }

    public void printAdjacencyList() {
        for (List<Integer> vertex : adjacencyList) {
            System.out.println(vertex.toString());
        }
    }

    public static void main(String[] args) {
        AdjacencyList adjacencyList = new AdjacencyList();
        for (int i = 0; i < 6; i++) {
            adjacencyList.addVertex(i);
        }

        adjacencyList.addEdge(1, 4);
        adjacencyList.addEdge(2, 4);
        adjacencyList.addEdge(4, 3);
        adjacencyList.addEdge(5, 2);

        adjacencyList.printAdjacencyList();
    }

}