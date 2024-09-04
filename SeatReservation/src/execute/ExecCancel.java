package execute;

import seat.Row;
import display.Content;
import display.CommonPrompt;
import java.util.Scanner;

//TODO 고친 피드백 내용
// 1. 이전 취소 기능 클래스 이름이 Cancel에서 execCancel로 바꾸어 기능 실행을 포함하고 있는 클래스임을 나타냄
// 2. 예매 내역이 0, 1, 다수일 때의 코드 실행 경로가 다소 복잡했음. -> 차라리 private 함수 isEmpty, isMultipleReservation 을 두어서
// 좀 더 보기 편하게 나누어 놓았고, 구조를 맨 처음에 개수에 따라 분기시켜서 조금 더 깔끔해짐.
// --> 프린트 클래스 따로, 기능 클래스를 따로 두려고 하였으나 생각한 구조 상에서 출력을 함수 인터페이스로 만들어서 클래스 안에 넣어놓고 
// 대신에 클래스의 이름을 "실행"이라는 포괄적인 의미로 대체.

public class ExecCancel extends ActionTask {
	private String name;
	private int seatNum;

	public ExecCancel(Row[] rows) {
		super(rows);
	}
	
	private boolean isEmpty(String name) {
		if (row.getMatchSeatCount(name) == 0)
			return true;
		return false;
	}
	
	private boolean isMultipleReservation(String name) {
		int	count = row.getMatchSeatCount(name);
		if (count == 1 || count <= 0)
			return false;
		return true;
	}

	//Cancel 메뉴를 선택했을 때 입출력 내용을 담당하는 함수
	public void handleIO(Scanner sc) {
		Content content = (scanner) -> {
			int input;
			CommonPrompt.seatTypePrompt();
			input = checkIntInputValidity(sc, 3);
			this.row = convertNumToRow(input, rows);
			row.printRowStatus();
			System.out.print("Name >> ");
			this.name = sc.next();
		};
	}
	
	// 실제 기능을 실행하는 함수 -> 부모의 추상메소드를 오버라이딩하여 메인함수에서 모든 메뉴의 실행을 한 이름으로 진행할 수 있도록.
	public void	execTask(Scanner sc) {
		if (isEmpty(name)) {
			System.out.println("예매 내역이 없습니다.");
		}// 예약 내역이 없을 때
		else if (isMultipleReservation(name)) {
			do {
				System.out.println("올바른 좌석 번호와 함께 다시 골라주세요");
				seatNum = sc.nextInt();
			} while (row.deleteName(name, seatNum) == false);
		}// 예약 내역이 2개 이상일 때
		else
			row.deleteName(name);// 예약 내역이 1개일 때
	}
}

//TODO getMatchedSeatCount 이름 바꾸기
//TODO count를 저장하고 있을지...
//TODO ROW 객체의 deleteName 메소드 이름 변경하기