package display;

import seat.Row;
import execute.*;

public class CommonPrompt {
	public static final String MENU_PROMPT = "Reserve : 1, Search : 2, Cancel : 3, Quit : 4 >> ";
	public static final String SEAT_TYPE_PROMPT = "Seat type : S(1), A(2), B(3) >> ";

	// 입력받은 menu가 어떤 것인지 생성하고 반환하는 함수
	public static ActionTask inputTask(int num, Row rows[]) {// TODO 변경된 switch문 반영
		return switch (num) {
		case 1 -> new ExecReserve(rows);
		case 2 -> new ExecSearch(rows);
		case 3 -> new ExecCancel(rows);
		case 4 -> new ExecExit();
		default -> {
			System.out.println("유효하지 않은 메뉴입니다.");
			yield null;
		}
		};
	}

	// 공통 프롬프트 출력 함수
	public static void chooseMenu() {
		System.out.print(MENU_PROMPT);
	}

	public static void seatTypePrompt() {
		System.out.print(SEAT_TYPE_PROMPT);
	}
}
