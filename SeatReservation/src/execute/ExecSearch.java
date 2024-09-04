package execute;

import java.util.Scanner;
import seat.Row;

public class ExecSearch extends ActionTask {

	public ExecSearch(Row[] rows) {
		super(rows);
	}

	public void handleIO(Scanner sc) {
	};
	
	public void	execTask(Scanner sc) {
		rows[0].printRowStatus();
		rows[1].printRowStatus();
		rows[2].printRowStatus();
		System.out.println("This is the end of the search.");
	}
}
