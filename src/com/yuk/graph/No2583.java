import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No2583 {

    static int[][] grid;
    static boolean[][] visited;
    static int M, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        grid = new int[M][N];
        visited = new boolean[M][N];

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            drawRectangle(x1, y1, x2, y2);
        }

        List<Integer> areas = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j] && grid[i][j] == 0) {
                    areas.add(dfs(j, i));
                }
            }
        }

        Collections.sort(areas);
        System.out.println(areas.size());
        for (int i = 0; i < areas.size(); i++) {
            System.out.print(areas.get(i)+" ");
        }

        br.close();
    }

    static void drawRectangle (int x1 , int y1, int x2, int y2) {
        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                grid[j][i] = 1;
            }
        }
    }

    static int dfs(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= M || grid[y][x] == 1 || visited[y][x]) {
            return 0;
        }
        visited[y][x] = true;
        int area = 1;
        area += dfs(x - 1, y);
        area += dfs(x + 1, y);
        area += dfs(x, y - 1);
        area += dfs(x, y + 1);
        return area;
    }
}