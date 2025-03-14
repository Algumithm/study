package _0314;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Island {
    int x, y;
    public Island(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Edge implements Comparable<Edge> {
    int idx;
    double cost;
    
    public Edge(int idx, double cost) {
        this.idx = idx;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return Double.compare(this.cost, o.cost); 
    }
}

public class swea1251 {
    static int N;
    static double E;
    static Island[] islands;
    static boolean[] visited;
    static double[][] costMatrix;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int cs = Integer.parseInt(br.readLine()); 
        for (int c = 1; c <= cs; c++) {
            N = Integer.parseInt(br.readLine());
            islands = new Island[N];
            visited = new boolean[N];
            costMatrix = new double[N][N];

            int[] tempX = new int[N];
            int[] tempY = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) tempX[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) tempY[i] = Integer.parseInt(st.nextToken());

            for (int i = 0; i < N; i++) {
                islands[i] = new Island(tempX[i], tempY[i]);
            }

            E = Double.parseDouble(br.readLine());

            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    double cost = calculateCost(islands[i], islands[j]);
                    costMatrix[i][j] = cost;
                    costMatrix[j][i] = cost;
                }
            }

            double result = prim();
            System.out.println("#" + c + " " + Math.round(result));
        }
    }//main

    static double calculateCost(Island a, Island b) {
        return (Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2)) * E;
    }//calculate

    static double prim() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(0, 0));

        double totalCost = 0;
        int count = 0;

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int idx = edge.idx;

            if (visited[idx]) 
            	continue;
            visited[idx] = true;
            totalCost += edge.cost;
            count++;

            if (count == N) break;

            for (int i = 0; i < N; i++) {
                if (!visited[i]) {
                    pq.add(new Edge(i, costMatrix[idx][i]));
                }
            }
        }

        return totalCost;
    }// prim
}
