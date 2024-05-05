package FinalProject;

public class CelebrityProblem {
    private int[][] graph;

    // Constructor to initialize the graph
    public CelebrityProblem(int[][] graph) {
        this.graph = graph;
    }

    // Helper method to check if a knows b
    private boolean knows(int a, int b) {
        return graph[a][b] == 1;
    }

    public int findCelebrity(int n) {
        int candidate = 0;

        // First pass to find the celebrity candidate
        for (int i = 1; i < n; i++) {
            if (knows(candidate, i)) {
                candidate = i;
            }
        }

        // Second pass to verify the candidate
        for (int i = 0; i < n; i++) {
            if (i != candidate && (knows(candidate, i) || !knows(i, candidate))) {
                return -1; // No celebrity found
            }
        }

        return candidate; // Candidate is the celebrity
    }
}
