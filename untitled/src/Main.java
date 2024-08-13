import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        // 배열 입력 받기
        arr = new int[N][M];
        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<M;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();
        System.out.println(result);

    }
    static int M, N;
    static int [][] arr;
    static int [] directy = new int [] {0,0,1,-1};
    static int [] directx = new int [] {1,-1,0,0};
    static int result;

    //처음부터 모든 토마토가 익어있는지 확인할 변수
    static boolean flag = false;

    static void bfs() {
        int [] now;
        int nexty,nextx,nextc;
        Queue<int[]> q = new LinkedList<>();

        // q안에 처음부터 익어있는 토마토 다 넣기
        for (int i=0;i<N;i++) {
            for (int j=0;j<M;j++) {
                if (arr[i][j] ==1) {
                    q.offer(new int[]{i,j,0});
                    flag = true;
                }
            }
        }

        // q에 하나도 안들어갔을경우 바로 return
        if (!flag) {
            result = 0;
            return;
        }

        while (!q.isEmpty()) {
            now = q.poll();
            for (int i=0;i<4;i++) {
                nexty = now[0] + directy[i];
                nextx = now[1] + directx[i];
                if ( 0<=nexty && nexty<N && 0<=nextx && nextx<M && arr[nexty][nextx]==0) {
                    arr[nexty][nextx] = 1;
                    q.offer(new int[]{nexty,nextx,now[2]+1});
                    result = now[2]+1;
                }
            }
        }

        // 토마토가 모두 익었는지 확인
        for (int i=0;i<N;i++) {
            for (int j=0;j<M;j++) {
                if (arr[i][j]==0) {
                    result = -1;
                }
            }
        }
    }
}

//2 2
//0 0
//0 0
//일때 -1이어야함