import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class NO1_Buffered {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//�Է¿�
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));//��¿�
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());// <- String���� ������ �����ִ� ���� \t \n ����
        int a = Integer.parseInt(st.nextToken()); // <- �� �� �Է� return String
        bw.write(a + " "); // <- ��� <- char ��� or String
        int b = Integer.parseInt(st.nextToken()); // <- �� �� �Է� return String
        bw.write(b + " "); // <- ��� <- char ��� or String
        int c = Integer.parseInt(st.nextToken()); // <- �� �� �Է� return String
        bw.write(c + " "); // <- ��� <- char ��� or String
        int d = Integer.parseInt(st.nextToken()); // <- �� �� �Է� return String
        bw.write(d + " "); // <- ��� <- char ��� or String

        br.close();
        bw.close(); // Buffer ��� ���, Buffer�� ��� ��, close : �����鼭 ���۸� �����(���鼭 ���)
    }
}

//1 2 3 4



// n * n
// 1
// N*N
// 10000 * 10000 <- 1�� �� <- 1�� 
// 1�� C���
// JAVA���� C����
//


