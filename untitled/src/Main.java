import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];
        resultarr = new ArrayList<>();
        String s;
        for (int i=0;i<N;i++) {
            s = br.readLine();
            for (int j=0;j<N;j++) {
                arr[i][j] = s.charAt(j)-'0';
            }
        }
        for (int i=0;i<N;i++) {
            for (int j=0;j<N;j++) {
                if (arr[i][j]==1) {
                    result++;
                    bfs(i,j, 1);
                }
            }
        }
        System.out.println(result);
    }
    static int N;
    static int[][]arr;
    static int result = 0;
    static ArrayList<Integer> resultarr;
    static boolean [][] visited;
    static int [] directy = new int [] {0,0,1,-1};
    static int [] directx = new int [] {1,-1,0,0};
    static void bfs(int y, int x, int count){
        Queue<int[]> q = new LinkedList<>();
        visited[y][x] = true;
        arr[y][x] = 0;
        q.offer(new int[]{y,x,count});
        while(!q.isEmpty()) {
            int [] now = q.poll();
            int nowy = now[0];
            int nowx = now[1];
            int nowcount = now[2];
            for (int i=0;i<4;i++) {
                int nexty = nowy+directy[i];
                int nextx = nowx+directx[i];
                if ( 0<= nexty && 0<= nextx && nexty<N && nextx<N && !visited[nexty][nextx] && arr[nexty][nextx]==1) {
                    q.offer(new int[]{nexty,nextx,nowcount+1});
                }
            }
        }
    }
}