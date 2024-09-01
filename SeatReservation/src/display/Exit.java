package display;

import	seat.Row;
import java.util.Scanner;

public class Exit extends Menu{
	private Row rows[] = new Row[3];

	public Exit(Row[] rows) {
		this.rows = rows;
	}
// exit 으로 프로그램 종료
	public void	printContent(Scanner sc) {
		System.out.println("Thank you!");
		System.exit(0);
	}
}
