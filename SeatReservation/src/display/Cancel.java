package display;

import java.util.Scanner;

import main.Main;
import seat.Row;

public class Cancel extends Menu { // menu 라는 것은 UI적인
	private String name;
	private int seatNum;

	public Cancel(Row[] rows) {
		super(rows);
	}

	// 취소할 좌석타입의 상태를 출력하는 함수.
	public void printContent(Scanner sc) {// print + 기능 -> 메소드 이름을 좀 더 명확히
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
	public void deleteReservation(Scanner sc) {// delete 보다는 remove

		if (row.getMatchSeatCount(name) == 0) {
			System.out.println("예매 내역이 없습니다.");
			return;
		} // 이 메소드가 여기에 들어갈 이유는 없을 것 같다.
			// private으로 다로 놓고 이를 이용해서
			// Cancel객체에 등록 여부를 나타내는 함수 따로, 다중 등록을 나타내는 함수 따로 만드는 것이 더 이상적.
		if (row.deleteName(name) == true)
			return;// 먼저 호출하는 것이 의문을 불러일으킬 수 있다. 한번에 깔끔한 흐름이 더 나음.
		System.out.println("올바른 좌석 번호와 함께 다시 골라주세요");
		do {
			System.out.print("Seat num >> ");
			seatNum = sc.nextInt();
		} while (row.deleteName(name, seatNum) == false);
	}
	// int 변수를 두어서 count값을 저장한 뒤 if 문으로 나누는 것이 나을 것.
}
// 가장 먼저 메소드, 클래스 명명하는 것을 연습을 많이 하도록.
// 클래스, 메소드가 하는일을 적어보는 것.