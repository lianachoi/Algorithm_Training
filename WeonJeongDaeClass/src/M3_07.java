import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Person{
	int y;
	int x;
	int cnt;
	Person(int y, int x, int cnt){
		this.y = y;
		this.x = x;
		this.cnt = cnt;
	}
}
public class M3_07 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


	public static void main(String[] args) throws IOException {
		char[][] Paint = new char[10][11];
		for (int i = 1; i < Paint.length-1; i++) {
			String s = 	br.readLine();
			for (int j = 1; j < Paint[i].length-1; j++) {
				Paint[i][j] = s.charAt(j-1);
			}
		}
		
		int [] move_y = {-1, 0};
		int [] move_x = { 0, 1};
		
		int[][] check  = new int[10][11];
		Queue<Person> person = new LinkedList<Person>();
		Queue<Person> find_person = new LinkedList<Person>();
		
		person.add(new Person(8,1,0));
		
		while (!person.isEmpty()) {
			Person now = person.poll();
			for (int i = 0; i < move_x.length; i++) {
				int next_y = now.y+move_y[i];
				int next_x = now.x+move_x[i];
				if ((int)Paint[next_y][next_x] != 0
						&& check[next_y][next_x] == 0) {
					if (Paint[next_y][next_x] == '_') {
						find_person.add(new Person(next_y,next_x,1));
					}else {
						person.add(new Person(next_y,next_x,0));
					}
					check[next_y][next_x] = 1;
				}
			}
		}
		
		while (!find_person.isEmpty()) {
			Person now = find_person.poll();
			for (int i = 0; i < move_x.length; i++) {
				int next_y = now.y+move_y[i];
				int next_x = now.x+move_x[i];
				if ((int)Paint[next_y][next_x] != 0
						&& check[next_y][next_x] == 0) {
					if (Paint[next_y][next_x] == '#') {
						bw.write((now.cnt)+"");
						find_person.clear();
						break;
					}else {
						find_person.add(new Person(next_y,next_x,now.cnt+1));
					}
				}
			}
		}
		br.close();
		bw.close();
	}

}
