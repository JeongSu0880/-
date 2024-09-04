package execute;

import seat.Row;
import display.Content;
import display.CommonPrompt;
import java.util.Scanner;

public class ExecReserve extends ActionTask {
	private int seatNum;
	private String name;
	
	public ExecReserve(Row[] rows) {
		super(rows);
	}
	
	public void handleIO(Scanner sc) {
		Content content = (scanner) -> {
			int input;
			CommonPrompt.seatTypePrompt();
			input = checkIntInputValidity(sc, 3);
			this.row = convertNumToRow(input, rows);
			row.printRowStatus();
			System.out.print("Name >> ");
			this.name = sc.next();
			System.out.print("Seat Number >> ");
			this.seatNum = checkIntInputValidity(sc, 16);
		};
	}
	
	public void	execTask(Scanner sc) {
		row.addName(seatNum, name);
	}
}
