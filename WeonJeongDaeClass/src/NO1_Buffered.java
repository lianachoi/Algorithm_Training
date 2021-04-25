import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class NO1_Buffered {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//입력용
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));//출력용
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());// <- String에서 공백을 나눠주는 역할 \t \n 띄어쓰기
        int a = Integer.parseInt(st.nextToken()); // <- 한 줄 입력 return String
        bw.write(a + " "); // <- 출력 <- char 출력 or String
        int b = Integer.parseInt(st.nextToken()); // <- 한 줄 입력 return String
        bw.write(b + " "); // <- 출력 <- char 출력 or String
        int c = Integer.parseInt(st.nextToken()); // <- 한 줄 입력 return String
        bw.write(c + " "); // <- 출력 <- char 출력 or String
        int d = Integer.parseInt(st.nextToken()); // <- 한 줄 입력 return String
        bw.write(d + " "); // <- 출력 <- char 출력 or String

        br.close();
        bw.close(); // Buffer 모두 기록, Buffer를 비울 때, close : 닫으면서 버퍼를 비워요(비우면서 출력)
    }
}

//1 2 3 4



// n * n
// 1
// N*N
// 10000 * 10000 <- 1억 번 <- 1초 
// 1차 C언어
// JAVA느림 C빠름
//


