package execute;

import seat.Row;

import java.util.InputMismatchException;
import java.util.Scanner;

//TODO 수정한 부분
// 1. checkIntInputValidity와 convertNumToRow (구 inputRow)는 Main 클래스에 static 함수로 선언이 되어있었는데, 
// Exec메뉴들의 부모클래스 역할을 하는 ActionTask 클래스를 만들어 그 안에 protected로 선언 -> 외부에서 접근 금지

abstract public class ActionTask {
	protected Row row;
	protected Row[] rows = new Row[3];

	protected ActionTask() {
	};

	protected ActionTask(Row[] rows) {
		this.rows = rows;
	}

	abstract protected void handleIO(Scanner sc);

	abstract protected void execTask(Scanner sc);

	// 인풋을 받을 때, 숫자를 받으면 Int가 맞는지 예외처리 후 올바른 범위 안에 있는지 체크하는 함수
	public static int checkIntInputValidity(Scanner sc, int range) {
		int input;
		boolean isValid = false;

		input = 0;
		while (isValid == false) {
			try {
				input = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("유효하지 않은 숫자입니다. 다시 입력해주세요.");
				continue;
			}
			if (input < 1 || range < input)
				System.out.println("유효하지 않은 숫자입니다. 다시 입력해주세요.");
			else
				isValid = true;
		}
		return (input);
	}

	// 입력받은 row가 어떤 타입인지 반환하는 함수
	protected Row convertNumToRow(int num, Row[] rows) {// TODO 변경된 switch문 반영
		return switch (num) {
		case 1 -> rows[0];
		case 2 -> rows[1];
		case 3 -> rows[2];
		default -> {
			System.out.println("유효하지 않은 좌석 타입입니다.");
			yield null;
		}// 변경된 switch문
		};
	}
}
