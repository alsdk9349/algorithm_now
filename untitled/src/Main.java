import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int count = 0;
        int total = 0;
        for (int i=0;i<20;i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int point = Integer.parseInt(st.nextToken());
            count+=point;
            String score = st.nextToken();
            if (score=="A+") {

            }

        }
    }
}