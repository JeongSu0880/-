package display;

import	seat.Row;

public class Search extends Menu {
	private Row[]		row = new Row[3];

	public void setRows(Row r1, Row r2, Row r3) {
		row[0] = r1;
		row[1] = r2;
		row[2] = r3;
	}

	public void	printContent() {
		row[0].printRowStatus();
		row[1].printRowStatus();
		row[3].printRowStatus();
		System.out.println("This is the end of the search.");
	}
}
