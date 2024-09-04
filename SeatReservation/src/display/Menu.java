package display;

import seat.Row;
import java.util.Scanner;

abstract public class Menu {
	protected Row row;
	protected Row[] rows = new Row[3];

	public Menu(Row[] rows) {
		this.rows = rows;
	}

	public abstract void printContent(Scanner sc);

	public void setRow(Row row) {
		this.row = row;
	}
}
