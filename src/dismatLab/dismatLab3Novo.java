package dismatLab;

import java.util.*;
public class dismatLab3Novo {
    static class Edge implements Comparable<Edge>{
        int v1, v2, weight;
        Edge(){}
        Edge(int v1, int v2, int weight){
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge e) {
            return this.weight - e.weight;
        }
    }

    public static void main(String[] args) {
        int n, a, b, c;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Unesite prirodan broj n: ");
        n = scanner.nextInt();
        System.out.println("Unesite vrijednost prirodnog broja a: ");
        a = scanner.nextInt();
        System.out.println("Unesite vrijednost prirodnog broja b: ");
        b = scanner.nextInt();
        System.out.println("Unesite vrijednost prirodnog broja c: ");
        c = scanner.nextInt();

        int[][] adj = new int[n][n];
        int[] visited = new int[n];
        ArrayList<Edge> edges = new ArrayList<>();




        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int weight = Math.abs(a*i - b*j) / c;
                if(weight != 0 && i != j) {
                    if(j < i) continue;
                    adj[i - 1][j - 1] = 1;
                    adj[j - 1][i - 1] = 1;
                    edges.add(new Edge(i - 1, j - 1, weight));
                }else{
                    adj[i - 1][j - 1] = 0;
                }
            }
        }
        boolean flag = isVisited(adj, visited, 0);

        if(!flag){
            System.out.println("Graf G nije povezan graf");
        }else{
            Collections.sort(edges);
            System.out.println("Graf G je povezan graf");
            int[][] minTree = new int[n][n];
            HashMap<Integer, Integer> vertexSizes = getMinTree(edges, minTree);
            List<Integer> list = getPruferCode(minTree, vertexSizes);
            System.out.println(list);
        }
    }
    static boolean hasCycleHelper(int[][] adj, int pos){
        int[] visited = new int[adj.length];
        return hasCycle(adj, visited, pos, -1);
    }
    static boolean hasCycle(int[][] adj, int[] visited, int pos, int parent){
        visited[pos] = visited[pos] + 1;
        for(int i = 0; i < adj.length; i++){
            if(adj[pos][i] == 1 && visited[i] != 1 ){
                if(hasCycle(adj, visited, i, pos))
                    return true;
            }else if(i != parent && adj[pos][i] == 1){
                return true;
            }
        }
        return false;
    }
    static boolean isVisited(int[][] adj, int[] visited, int pos){
        visited[pos] = 1;
        if(isConnected(visited)) return true;
        for(int i = 0; i < adj.length; i++){
            if(adj[pos][i] == 1 && visited[i] != 1){
                isVisited(adj, visited, i);
            }
        }
        return isConnected(visited);
    }

    static boolean isConnected(int[] visited){
        //checks if all vertexes were visited
        for(int a : visited){
            if(a != 1)
                return false;
        }
        return true;
    }

    static HashMap<Integer, Integer> getMinTree(List<Edge> edges, int[][] minTree){
        HashMap<Integer, Integer> map = new HashMap<>();
        int numOfNewEdges = 0;
        for(Edge e : edges){
            if(numOfNewEdges == minTree.length-1)
                break;
            boolean flag = false;
            minTree[e.v1][e.v2] = 1;
            minTree[e.v2][e.v1] = 1;
            for(int i = 0; i < minTree.length; i++){
                flag = hasCycleHelper(minTree, i);
                if(flag) break;
            }
            if(!flag){
                map.merge(e.v1, 1, Integer::sum);
                map.merge(e.v2, 1, Integer::sum);
                numOfNewEdges++;
            }else{
                minTree[e.v1][e.v2] = 0;
                minTree[e.v2][e.v1] = 0;
            }
        }
        return map;
    }
    static List<Integer> getPruferCode(int[][] adj, HashMap<Integer, Integer> map){
        List<Integer> list = new ArrayList<>();
        while(map.size() > 2){
            for(int i = 0; i < adj.length; i++){
                if(map.get(i) == null) continue;
                if(map.get(i) == 1){
                    int ind = findConnectedVertex(adj[i]);
                    list.add(ind+1);
                    adj[i][ind] = 0;
                    adj[ind][i] = 0;
                    map.remove(i);
                    map.put(ind, map.get(ind) - 1);
                    break;
                }
            }
        }
        return list;
    }
    static int findConnectedVertex(int[] adj){
        int ind = 0;
        for(int i = 0; i < adj.length; i++){
            if(adj[i] == 1)
                ind = i;
        }
        return ind;
    }
}







