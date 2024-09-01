package display;

import	seat.Row;
import	java.util.Scanner;

import main.Main;

import java.util.Scanner;

public class Cancel extends Menu{
	private String name;
	private int	seatNum;
	private Row rows[] = new Row[3];

	public Cancel(Row[] rows) {
		this.rows = rows;
	}

	//취소할 좌석타입의 상태를 출력하는 함수.
	public void printContent(Scanner sc) {
		int input;

		CommonPrompt.seatTypePrompt();
		input = Main.checkInputValidity(sc, 3);
		setRow(Main.inputRow(input, rows));
		row.printRowStatus();
		System.out.print("Name >> ");
		this.name = sc.next();
		this.deleteReservation(sc);
	}

	// 예매된 좌석이 있다면 좌석이 취소될 때까지 
	public void	deleteReservation(Scanner sc) {

		if (row.getMatchSeatCount(name) == 0) {
			System.out.println("예매 내역이 없습니다.");
			return ;
		}
		if (row.deleteName(name) == true)
			return ;
		System.out.println("올바른 좌석 번호와 함께 다시 골라주세요");
		do {
			System.out.print("Seat num >> ");
			seatNum = sc.nextInt();
		}
		while (row.deleteName(name, seatNum) != true);
	}
}
