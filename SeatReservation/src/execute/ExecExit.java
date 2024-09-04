package execute;

import java.util.Scanner;

public class ExecExit extends ActionTask {

	public ExecExit() {
		super();
	}

	public void handleIO(Scanner sc) {

	}

	public void execTask(Scanner sc) {
		System.out.println("Thank you!");
		System.exit(0);
	}
}
