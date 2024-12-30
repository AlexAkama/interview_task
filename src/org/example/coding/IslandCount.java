package org.example.coding;

/*
ЗАДАЧА:
Необходимо посчитать кол-во островов в матрице

--------------------------------------------------------------------------
Возможные решения DFS(BFS)

Потом спросить про UNION-FIND
https://alexakama.github.io/whitebook/content/theory/algorithm/#find_union
--------------------------------------------------------------------------

*/
public class IslandCount {

    /*
    Моя реализация
     */
    private static int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private static char[][] grid;
    private static int n;
    private static int m;

    private static int count;


    public static void main(String[] args) {
        grid = new char[][]{
                {'#', '#', '.', '.'},
                {'#', '#', '.', '#'},
                {'.', '.', '#', '#'},
                {'#', '#', '.', '#'}
        };
        n = grid.length;
        m = grid[0].length;
        UnionFind dsu = new UnionFind(n * m);
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (grid[y][x] == '#') {
                    count++; // Если не будет объединения, значит это новый остров
                    int currentIndex = calculateLineIndex(y, x);
                    for (int[] d : direction) {
                        int nextY = y + d[0];
                        int nextX = x + d[1];
                        if (inGrid(nextY, nextX) && grid[nextY][nextX] == '#') {
                            int nextIndex = calculateLineIndex(nextY, nextX);
                            boolean hasUnion = dsu.union(currentIndex, nextIndex);
                            if (hasUnion) count--; // Если объединились - значит это часть существующего острова
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }

    private static int calculateLineIndex(int y, int x) {
        return y * m + x;
    }

    private static boolean inGrid(int y, int x) {
        return y > -1 && y < grid.length && x > -1 && x < grid[0].length;
    }

    // Реализация UNION-FIND
    static class UnionFind {

        private int[] parent;
        private int[] rank;

        public UnionFind(int size) {
            init(size);
        }

        private void init(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int p) {
            if (parent[p] != p) {
                parent[p] = find(parent[p]); // Рекурсивное сжатие пути
            }
            return parent[p];
        }

        public boolean union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);

            if (rootP == rootQ) {
                return false;
            }

            if (rank[rootP] > rank[rootQ]) {
                parent[rootQ] = rootP;
            } else if (rank[rootP] < rank[rootQ]) {
                parent[rootP] = rootQ;
            } else {
                parent[rootQ] = rootP;
                rank[rootP]++;
            }
            return true;
        }


    }

}
