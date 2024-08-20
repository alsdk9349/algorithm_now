
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str;
        while ((str=br.readLine())!=null) {
            int result = 0;
            st = new StringTokenizer(str);
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            arr = new int[h][w];
            for (int i=0;i<h;i++) {
                st = new StringTokenizer(br.readLine());
                for (int j=0;j<w;j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i=0;i<h;i++) {
                for (int j=0;j<w;j++) {
                    if (arr[i][j]==1) {
                        arr[i][j]=0;
                        dfs(i,j);
                    }
                }
            }

        }
    }
    static int w,h;
    static int[][] arr;
    static int [] directy = {0,0,1,-1,-1,-1,1,1};
    static int [] directx = {1,-1,0,0,-1,1,-1,1};
    static void dfs (int y, int x) {
        arr[y][x]=0;
        for (int i=0;i<8;i++) {
            int nexty = y + directy[i];
            int nextx = x + directx[i];
            if (0<=nexty && nexty<h && 0<= nextx && nextx<=w && arr[nexty][nextx]==1) {
                dfs(nexty,nextx);
            }
        }
    }
}