package display;

import	seat.Row;
import	java.util.Scanner;

public class Cancel extends Menu{
	private Row		row;

	public void setRow(Row row) {
		this.row = row;
	}

	//취소할 좌석타입의 상태를 출력하는 함수.
	public void printContent() {
		row.printRowStatus();
	}

	// 예매된 좌석이 있다면 좌석이 취소될 때까지 
	public void	deleteReservation() {
		String name;
		Scanner sc = new Scanner(System.in);
		int	seatNum;

		printContent();
		System.out.println("Name >> ");
		name = sc.next();
		if (row.getMatchSeatCount(name) == 0) {
			System.out.println("예매 내역이 없습니다.");
			return ;
		}
		if (row.deleteName(name) == true)
			return ;
		System.out.println("올바른 좌석 번호와 함께 다시 골라주세요");
		do {
			seatNum = sc.nextInt();
		}
		while (row.deleteName(name, seatNum) == true);
	}

}
