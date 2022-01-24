package com.gatsby.graph;

import java.util.Arrays;

/**
 * @author -- gatsby
 * @date -- 2022/1/24
 * @description -- 邻接矩阵
 */


public class AdjacencyMatrix {
    private int[][] adjacencyMatrix;

    public AdjacencyMatrix(int vertex) {
        this.adjacencyMatrix = new int[vertex][vertex];
    }

    // 形如[0, 1, 3]表示顶点0->顶点1的权重是3
    public AdjacencyMatrix(int vertex, int[][] vertexEdgeWeight) {
        this.adjacencyMatrix = new int[vertex][vertex];
        for (int[] edge : vertexEdgeWeight) {
            this.adjacencyMatrix[edge[0]][edge[1]] = edge[2];
        }
    }

    public boolean addEdge(int vertexStart, int vertexEnd, int weight) {
        this.adjacencyMatrix[vertexStart][vertexEnd] = weight;
        return true;
    }

    public void printAdjacencyMatrix() {
        for (int[] row : adjacencyMatrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        AdjacencyMatrix adjacencyMatrix1 = new AdjacencyMatrix(3);
        adjacencyMatrix1.addEdge(1, 2, 1);
        adjacencyMatrix1.addEdge(2, 0, 3);
        adjacencyMatrix1.addEdge(0, 1, 3);

        int[][] vertexEdgeWeight = new int[][]{{1, 2, 1}, {2, 0, 3}, {0, 1, 3}};
        AdjacencyMatrix adjacencyMatrix2 = new AdjacencyMatrix(3, vertexEdgeWeight);
        adjacencyMatrix1.printAdjacencyMatrix();
        // [0, 3, 0]
        // [0, 0, 1]
        // [3, 0, 0]
        adjacencyMatrix2.printAdjacencyMatrix();
        // [0, 3, 0]
        // [0, 0, 1]
        // [3, 0, 0]
    }
}