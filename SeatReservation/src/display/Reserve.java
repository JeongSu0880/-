package display;

import java.util.Scanner;

import main.Main;
import seat.Row;

public class Reserve extends Menu {
	private int seatNum;
	private String name;

	public Reserve(Row[] rows) {
		super(rows);
	}

	// 이름과 좌석 번호 입력받은 후 좌석 정보에 예약자 이름 저장
	public void printContent(Scanner sc) {
		int input;

		CommonPrompt.seatTypePrompt();
		input = Main.checkInputValidity(sc, 3);
		setRow(Main.inputRow(input, rows));
		row.printRowStatus();
		System.out.print("Name >> ");
		this.name = sc.next();
		System.out.print("Seat Number >> ");
		this.seatNum = Main.checkInputValidity(sc, 16);
		this.addReservation(sc);
	}

	public void addReservation(Scanner sc) {
		row.addName(seatNum, name);
	}
}
