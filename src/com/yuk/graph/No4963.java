import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No4963 {

    static int[][] matrix;
    static boolean[][] visited;
    static int w, h;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        while(!(w == 0 && h ==0)) {

            matrix = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if(!visited[i][j] && matrix[i][j] == 1) {
                        dfs(j,i);
                        count++;
                    }
                }
            }

            System.out.println(count);

            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

        }
    }

    public static void dfs (int x, int y) {
        if(x >= w || y >= h || x < 0 || y < 0) {
            return;
        }
        if(visited[y][x]) {
            return;
        }

        if(matrix[y][x] == 0) {
            return;
        }

        visited[y][x] = true;

        dfs(x-1, y-1);
        dfs(x, y-1);
        dfs(x+1, y-1);
        dfs(x-1, y);
        dfs(x+1, y);
        dfs(x-1, y+1);
        dfs(x, y+1);
        dfs(x+1, y+1);
        return;
    }
}
