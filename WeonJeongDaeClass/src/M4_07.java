import java.awt.geom.Area;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Coin {
	int row, col;
	Coin(int row, int col){
		this.row = row;
		this.col = col;
	}
}
public class M4_07 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	// ������ ũ��
	static int Height;
	static int Width; 
	// ������ ����
	static int[][] GameScore;
	// Query ������
	static int[][] Queries;
	// Union ���� ����
	static Coin[][] union;
	// ���� ����
	static int[] Coin_score;
	static int[] Null_score;
	// ������ ĭ������
	static int[][] Coin_Union;
	static int[][] Null_Union;
	//�̹� ���� �ִµ� �� ����
	static int[] invalid;
	

	private static void initSetting(int score) {
		//���� Union���� �� �����ϴ� �迭
		union = new Coin[Height+2][Width+2];
		//���� �ڱ� �ڽ��� �ϳ��� Union���� �ʱ�ȭ
		for (int h = 1; h <= Height; h++) {
			for (int w = 1; w <= Width; w++) {
				union[h][w] = new Coin(h, w);
			}
		}
		//�����̳� ���� ����Ʈ
		int[][] list = new int[Height*Width][2];
		//�� �� ���� ����
		int list_len = 0;
		//�����̳� ������ �ִ� ��� ����Ʈ�� �����ϰ� GameScore������ ���ش�.
		for (int h = 1; h <= Height; h++) {
			for (int w = 1; w <= Width; w++) {
				if (GameScore[h][w] == score) {
					list[list_len][0] = h;
					list[list_len][1] = w;
					list_len++;
					
					if (score == 2) {
						GameScore[h][w] = 1;
					}else {
						GameScore[h][w] = 2;
					}
				}
			}
		}
		//�����̳� ���� ����Ʈ���� �ϳ��� �����鼭 �ֺ��� ������ Union���� ����
		for (int i = 0; i < list_len; i++) {
			int h = list[i][0];
			int w = list[i][1];
			
			//GameScore[h][w] = score;
			insertThing(h, w, score);
			FindUnion(h, w);
		}
		
	}
	
	private static void insertThing(int h, int w, int score) {
		//�����̳� ������ �����ǿ� ����
		GameScore[h][w] = score;
		if (score == 2) {
			// 2��¥�� ���� ���� 1�� ����
			Coin_score[2]++;
			// ���� Union �̸� �Ʒ� ���� ��������.
			Coin_Union[h][w] = 1;
		}else {
			Null_score[1]++;
			Null_Union[h][w] = 1;
		}
			
	}

	static void FindUnion(int h, int w) {
		int[] row = {-1,0,1, 0};
		int[] col = { 0,1,0,-1};
		
		int score = GameScore[h][w];
		
		//�� ������ �Ʒ� ���� �������� ���� �������� Ȯ���Ͽ� Union
		for (int i = 0; i < col.length; i++) {
			int new_h = h + row[i];
			int new_w = w + col[i];
			if (GameScore[new_h][new_w] == score) {
				Union(h, w, new_h, new_w, score);
			}
		}
	}
	
	private static void Union(int h, int w, int new_h, int new_w, int score) {
		//���� Ȯ��
		Coin a;
		a = Find(h, w);
		Coin one = new Coin(a.row,a.col);
		a = Find(new_h, new_w);
		Coin two = new Coin(a.row,a.col);
		
		if (one.row == two.row && one.col == two.col) return;  
		
		union[two.row][two.col].row = one.row;
		union[two.row][two.col].col = one.col;
		
		if (score == 2) {
			int oneCnt = Coin_Union[one.row][one.col];
			int twoCnt = Coin_Union[two.row][two.col];
			
			Coin_score[oneCnt * score]--;
			Coin_score[twoCnt * score]--;

			Coin_Union[one.row][one.col] += Coin_Union[two.row][two.col];
			Coin_Union[two.row][two.col] = 0;
			
			int head_cnt = Coin_Union[one.row][one.col];
			Coin_score[head_cnt * score]++;
		}else {
			int oneCnt = Null_Union[one.row][one.col];
			int twoCnt = Null_Union[two.row][two.col];
			
			Null_score[oneCnt * score]--;
			Null_score[twoCnt * score]--;

			Null_Union[one.row][one.col] += Null_Union[two.row][two.col];
			Null_Union[two.row][two.col] = 0;
			
			int head_cnt = Null_Union[one.row][one.col];
			Null_score[head_cnt * score]++;

		}		
	}

	static Coin Find(int h, int w) {
		// ���� ã�� ���� ���� ����
		Coin finding = union[h][w];
		// ������ �ô��� ã�°� ��ü�� ���
		if(finding.row == h && finding.col == w) return finding;
		// ������ ��ͷ� ã���ش�.
		Coin Union_head = Find(finding.row, finding.col);
		// ���� ������ ���� ��ġ�� ����
		union[h][w].row = Union_head.row;
		union[h][w].col = Union_head.col;
		return Union_head;		
	}
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		Height = Integer.parseInt(st.nextToken());
		Width = Integer.parseInt(st.nextToken());
		
		GameScore = new int[Height+2][Width+2];
		
		for (int i = 1; i <= Height; i++) {
			String s = br.readLine();
			for (int j = 1; j <= Width; j++) {
				if (s.charAt(j-1) == '_') {
					GameScore[i][j] = 1;
				}else {
					GameScore[i][j] = 2;
				}
			}
		}
		

		int Q = Integer.parseInt(br.readLine());
		
		Queries = new int[Q][3];
		invalid = new int[Q];
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			Queries[i][0] = Integer.parseInt(st.nextToken());
			if(Queries[i][0] == 1) {
				Queries[i][1] = Integer.parseInt(st.nextToken())+1;
				Queries[i][2] = Integer.parseInt(st.nextToken())+1;
				
			}else {
				Queries[i][1] =  Integer.parseInt(st.nextToken());
			
			}
		}
		
		
		
		Coin_score = new int[(Height*Width+1)*2];
		Null_score = new int[Height*Width+1];
		Coin_Union = new int[Height+2][Width+2];
		Null_Union = new int[Height+2][Width+2];
		
		int result = 0;
		initSetting(2);
		for (int i = 0; i < Q; i++) {
			if (Queries[i][0] == 2) {
				result += Coin_score[Queries[i][1]];
			}else {
				int h = Queries[i][1];
				int w = Queries[i][2];
				if (GameScore[h][w] == 2) {
					invalid[i] = 1;
				}else {
					insertThing(h, w, 2);
					FindUnion(h, w);
				}
			}
		}
		initSetting(1);
		for (int i = Q-1; i >= 0 ; i--) {
			if (Queries[i][0] == 2) {
				result += Null_score[Queries[i][1]];
			}else {
				if (invalid[i] == 1) {
					continue;
				}else {
					int h = Queries[i][1];
					int w = Queries[i][2];
					insertThing(h, w, 1);
					FindUnion(h, w);
				}
			}
		}
		
		bw.write(result+"");
		br.close();
		bw.close();
	}

}
