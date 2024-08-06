import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());
        arr = new int[n+1][n+1];
        for (int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = 1;
            arr[y][x] = 1;
        }
        bfs(a, b);

    }
    static int n,m,a,b;
    static int [][] arr;
    static int count = 0;
    static void bfs(int start, int end) {
        Queue<Map<Integer,Integer>> q = new LinkedList<>();
        q.offer();
        while(!q.isEmpty()) {
            int now = q.poll();
            if (now==end) {
                break;
            }
            for (int i=0;i<n+1;i++) {
                if (arr[now][i])
            }
        }
    }
}