package com.leetCode;

import java.util.*;

public class trial {
    public static void main(String[] args) {
        int numCities = 4;
        int numRoads = 5;
        int numTypes = 2;
        int[] fromCity = new int[]{3, 0, 0, 2, 1};
        int[] toCity = new int[]{2, 3, 2, 1, 3};
        int[] roadType = new int[]{1, 0, 0, 1, 1};
        ArrayList<ArrayList<Point>> road_type_segregated = new ArrayList<>();
        for(int i = 0; i< numTypes;i++){
            road_type_segregated.add(new ArrayList<>());
        }
        for(int i =0; i < numRoads;i++){
            ArrayList<Point> temp = road_type_segregated.get(roadType[i]);
            temp.add(new Point(fromCity[i],toCity[i]));
            road_type_segregated.set(roadType[i],temp);
        }
        ArrayList<Graph> graphsArrayList = new ArrayList<>();
        for(ArrayList<Point> a : road_type_segregated){
            Graph temp = new Graph(a.size());
            for(Point p : a){
                temp.addEdge(p.x,p.y);
            }
            temp.dfs_cycle(1,0);
            graphsArrayList.add(temp);
        }
        int[] answer = new int[numTypes];
        for(int i =0;i < answer.length;i++){
            answer[i] = graphsArrayList.get(i).getEdgeCount() - graphsArrayList.get(i).getCycleNumber();
        }

        for(int a : answer){
            System.out.println(a);
        }
    }
}


class Graph {
    private int N = 10000;
    private int edgeCount;
    private int[] color;
    private int[] par;
    private int[] mark;
    @SuppressWarnings("unchecked")
    Vector<Integer>[] graph;
    @SuppressWarnings("unchecked")
    Vector<Integer>[] cycles;

    public Graph(int edgeCount) {
        this.edgeCount = edgeCount;
        this.graph = new Vector[N];
        this.cycles = new Vector[N];
        this.color = new int[N];
        this.par  = new int[N];
        this.mark = new int[N];
        for (int i = 0; i < N; i++)
        {
            this.graph[i] = new Vector<>();
            this.cycles[i] = new Vector<>();
        }
    }
    private int cycleNumber;
    
    protected int getCycleNumber(){
        return cycleNumber;
    }

    protected int getEdgeCount(){
        return edgeCount;
    }
    protected void dfs_cycle(int u, int p) {
        if (color[u] == 2) {
            return;
        }
        if (color[u] == 1) {
            cycleNumber++;
            int cur = p;
            mark[cur] = cycleNumber;
            while (cur != u) {
                cur = par[cur];
                mark[cur] = cycleNumber;
            }
            return;
        }
        par[u] = p;
        color[u] = 1;
        for (int v : graph[u]) {
            if (v == par[u]) {
                continue;
            }
            dfs_cycle(v, u);
        }
        color[u] = 2;
    }

    public void addEdge(int u, int v) {
        graph[u].add(v);
        graph[v].add(u);
    }

    public void printCycles(int edges) {
        for (int i = 1; i <= edges; i++) {
            if (mark[i] != 0)
                cycles[mark[i]].add(i);
        }
        for (int i = 1; i <= cycleNumber; i++) {
            System.out.printf("Cycle edgeCountumber %d: ", i);
            for (int x : cycles[i])
                System.out.printf("%d ", x);
            System.out.println();
        }
    }

}

class Point {
    public int x;
    public int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point position = (Point) o;

        if (x != position.x) return false;
        if (y != position.y) return false;

        return true;
    }

    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}