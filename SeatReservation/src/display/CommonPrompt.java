package display;

public class CommonPrompt {
	public static final String MENU_PROMPT = "Reserve : 1, Search : 2, Cancel : 3, Quit : 4 >> ";
	public static final String SEAT_TYPE_PROMPT = "Seat type : S(1), A(2), B(3) >> ";

	// 공통 프롬프트 출력 함수
	public static void chooseMenu() {
		System.out.print(MENU_PROMPT);
	}

	public static void seatTypePrompt() {
		System.out.print(SEAT_TYPE_PROMPT);
	}
}
