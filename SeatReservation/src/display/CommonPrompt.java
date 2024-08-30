package display;

public class CommonPrompt{
	public static final String menuPrompt = "Reserve : 1, Search : 2, Cancel : 3, Quit : 4 >> ";
	public static final String seatTypePrompt = "Seat type : S(1), A(2), B(3) >> ";
	
	public static void	chooseMenu() {
		System.out.println(menuPrompt);
	}
	public static void seatTypePrompt() {
		System.out.println(seatTypePrompt);
	}
}
