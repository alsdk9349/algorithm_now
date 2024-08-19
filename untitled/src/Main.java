import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<M;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // break하기 전까지 계속
        while (true) {
            // 빙하 녹이기
            year++;
            arr =  melting().clone();
            int count = check();
            if (count>=2) {
                System.out.println(year);
                break;
            } else if (count==0) {
                System.out.println(0);
                break;
            }
        }
    }
    static int N,M;
    static int [][] arr;
    static int [] directy = new int[]{0,0,1,-1};
    static int [] directx = new int[]{1,-1,0,0};
    static boolean [][] visited;
    static int island;
    static int year = 0;
    static void bfs(int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y,x});
        while(!q.isEmpty()) {
            int [] now = q.poll();
            for (int i=0;i<4;i++) {
                int nexty = now[0] + directy[i];
                int nextx = now[1] + directx[i];
                if (!visited[nexty][nextx]
                        && arr[nexty][nextx]>0) {
                    visited[nexty][nextx] = true;
                    q.offer(new int []{nexty,nextx});
                }
            }
        }
    }
    // 섬의 개수 세는 함수
    static int check() {
        visited = new boolean[N][M];
        island = 0;
        for (int i=1;i<N-1;i++) {
            for (int j=1;j<M-1;j++) {
                if (arr[i][j]>0 && !visited[i][j]) {
                    visited[i][j]= true;
                    island++;
                    bfs(i,j);
                }
            }
        }
        return island;
    }
    static int[][] melting() {

        int [][] lst = new int[N][M];
        for (int i=1;i<N-1;i++) {
            for (int j=1;j<M-1;j++) {
                lst[i]=  arr[i].clone();
            }
        }
        for (int i=1;i<N-1;i++) {
            for (int j=1;j<M-1;j++) {
                if (arr[i][j]>0) {
                    int zero = 0;
                    for (int k=0;k<4;k++) {
                        int zeroy = i + directy[k];
                        int zerox = j + directx[k];
                        if (arr[zeroy][zerox]==0) {
                            zero++;
                        }
                    }
                    if (arr[i][j]-zero>=0) {
                        lst[i][j] =arr[i][j]-zero;
                    } else {
                        lst[i][j] = 0;
                    }
                }
            }
        }
        return lst;
    }
}