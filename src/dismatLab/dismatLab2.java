package dismatLab;
import java.util.*;

class dismatLab2 {
    public static void main(String[] args) {
        int n, k1, k2, k3, k4;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Unesite prirodan broj n: ");
        n = scanner.nextInt();
        System.out.println("Unesite vrijednost prirodnog broja k_1: ");
        k1 = scanner.nextInt();
        System.out.println("Unesite vrijednost prirodnog broja k_2: ");
        k2 = scanner.nextInt();
        System.out.println("Unesite vrijednost prirodnog broja k_3: ");
        k3 = scanner.nextInt();
        System.out.println("Unesite vrijednost prirodnog broja k_4: ");
        k4 = scanner.nextInt();

        int[][] adj = new int[n][n];
        int[] visited = new int[n];
        ArrayList<Integer> sequence = new ArrayList<>();
                                                                                                                                                                                


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (Math.abs(i - j) == k1 || Math.abs(i - j) == k2 || Math.abs(i - j) == k3 || Math.abs(i - j) == k4) {
                    adj[i-1][j-1] = 1;
                }else
                    adj[i-1][j-1] = 0;
            }
        }
        boolean flag = isVisited(adj, visited, 0);
        if(!flag){
            System.out.println("Graf G nije povezan graf");
            System.out.println("Graf G nije hamiltonovski graf");
        }
        else{
            System.out.println("Graf G je povezan graf");
            if(isHamiltonian(adj, 0, sequence))
                System.out.println("Graf G je hamiltonovski graf"+"; duljina hamiltonovskog ciklusa: " + n);
            else System.out.println("Graf G nije hamiltonovski graf");
        }
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
    static boolean isHamiltonian(int[][] adj, int pos, ArrayList<Integer> sequence){
            //for every vertex visit neighbours that are not in sequence, add that vertex to seq and check its neighbours, if seq.size=n and last vertex is connected to first its hamiltonian
            // else delete last vertex added and go back through other path
        sequence.add(pos);
        if(hamCheck(sequence, adj)) return true;
        for(int i = 0; i < adj.length; i++){
            if(adj[pos][i] == 1 && !sequence.contains(i)){
                isHamiltonian(adj, i, sequence);
                if(hamCheck(sequence, adj)) return true;
                sequence.remove(sequence.size()-1);
            }
        }
        return hamCheck(sequence, adj);
    }
    static boolean hamCheck(ArrayList<Integer> sequence, int[][] adj){
            //checks if sequence visited all vertexes and is last vertex connected to first one

        return sequence.size() == adj.length && adj[sequence.get(sequence.size()-1)][0] == 1;
    }
    static boolean isConnected(int[] visited){
            //checks if all vertexes were visited
        for(int a : visited){
            if(a != 1)
                return false;
        }
        return true;
    }

}
