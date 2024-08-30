package display;

import java.util.Scanner;

import seat.Row;

public class Reserve extends Menu{
	private int		seatNum;
	private Row		row;

	public void	setRow(Row row) {
		this.row = row;
	}
	
	public void	setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}
	
	public void printContent() {
		row.printRowStatus();
	}
	
	public void	addReservation() {
		String name;
		Scanner sc = new Scanner(System.in);
		
		printContent();
		System.out.println("Name >> ");
		name = sc.next();
		row.addName(seatNum, name);
	}
}
