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
	// 게임판 크기
	static int Height;
	static int Width; 
	// 게임판 정보
	static int[][] GameScore;
	// Query 정보들
	static int[][] Queries;
	// Union 정보 저장
	static Coin[][] union;
	// 점수 저장
	static int[] Coin_score;
	static int[] Null_score;
	// 영역별 칸수저장
	static int[][] Coin_Union;
	static int[][] Null_Union;
	//이미 동전 있는데 또 놓음
	static int[] invalid;
	

	private static void initSetting(int score) {
		//같은 Union인지 값 저장하는 배열
		union = new Coin[Height+2][Width+2];
		//각자 자기 자신을 하나의 Union으로 초기화
		for (int h = 1; h <= Height; h++) {
			for (int w = 1; w <= Width; w++) {
				union[h][w] = new Coin(h, w);
			}
		}
		//코인이나 공백 리스트
		int[][] list = new int[Height*Width][2];
		//몇 개 인지 저장
		int list_len = 0;
		//코인이나 공백이 있는 경우 리스트에 저장하고 GameScore에서는 없앤다.
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
		//코인이나 공백 리스트에서 하나씩 꺼내면서 주변에 같으면 Union으로 묶음
		for (int i = 0; i < list_len; i++) {
			int h = list[i][0];
			int w = list[i][1];
			
			//GameScore[h][w] = score;
			insertThing(h, w, score);
			FindUnion(h, w);
		}
		
	}
	
	private static void insertThing(int h, int w, int score) {
		//코인이나 공백을 점수판에 놓음
		GameScore[h][w] = score;
		if (score == 2) {
			// 2점짜리 영역 개수 1개 증가
			Coin_score[2]++;
			// 같은 Union 이면 아래 정보 합쳐질것.
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
		
		//위 오른쪽 아래 왼쪽 방향으로 같은 상태인지 확인하여 Union
		for (int i = 0; i < col.length; i++) {
			int new_h = h + row[i];
			int new_w = w + col[i];
			if (GameScore[new_h][new_w] == score) {
				Union(h, w, new_h, new_w, score);
			}
		}
	}
	
	private static void Union(int h, int w, int new_h, int new_w, int score) {
		//조상 확인
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
		// 현재 찾는 것의 조상 정보
		Coin finding = union[h][w];
		// 조상을 봤더니 찾는것 자체인 경우
		if(finding.row == h && finding.col == w) return finding;
		// 조상을 재귀로 찾아준다.
		Coin Union_head = Find(finding.row, finding.col);
		// 조상 정보를 현재 위치에 저장
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
