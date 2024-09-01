package display;

import	seat.Row;
import java.util.Scanner;

public class Search extends Menu {
	private Row[]		rows = new Row[3];

	public Search(Row[] rows) {
		this.rows = rows;
	}
	// 모든 열의 좌석 상태를 출력
	public void	printContent(Scanner sc) {
		rows[0].printRowStatus();
		rows[1].printRowStatus();
		rows[2].printRowStatus();
		System.out.println("This is the end of the search.");
	}
}
