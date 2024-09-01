package main;

import java.util.Scanner;
import java.util.InputMismatchException;

import	display.*;
import	seat.*;

public class Main {
	
	// 입력받은 menu가 어떤 것인지 생성하고 반환하는 함수
	public static Menu	inputMenu(int num, Row rows[]) {
		Menu	menu;
		switch (num) {
		    case 1:
		    	return (new Reserve(rows));
		    case 2:
		    	return (new Search(rows));
		    case 3:
		    	return (new Cancel(rows));
		    case 4:
		    	return (new Exit(rows));
		    default:
		    	System.out.println("유효하지 않은 메뉴입니다.");
		    	return (null);
		}
	}

	// 입력받은 row가 어떤 타입인지 반환하는 함수
	public static Row	inputRow (int num, Row[] rows) {
		switch (num) {
		    case 1:
		    	return (rows[0]);
		    case 2:
		    	return (rows[1]);
		    case 3:
		    	return (rows[2]);
		    default:
		    	System.out.println("유효하지 않은 좌석 타입입니다.");
		    	return (null);
		}
	}

	// 인풋을 받을 때, 숫자를 받으면 Int가 맞는지 예외처리 후 올바른 범위 안에 있는지 체크하는 함수
	public	static int	checkInputValidity(Scanner sc, int range) {
		int	input;

		input = 0;
		try {
			input = sc.nextInt();
		}
		catch (InputMismatchException e) {
			 System.out.println("Invalid input. Please enter a valid integer.");
             System.exit(1);
		}
		if (input < 1 || range < input) {
			 System.out.println("Invalid input. Please enter a valid range.");
             System.exit(1);
		}
		return (input);
	}

	// 프로그램 종료 메뉴 (exit)을 누르기 전까지 무한 while문을 돌면서 프로그램 실행
	public static void main(String[] args) {
		Row[]	rows = new Row[3];
		rows[0] = new Row('S');
		rows[1] = new Row('A');
		rows[2] = new Row('B');
		Row	rowType = null;
		Menu	menu;
		int		input;

		Scanner sc = new Scanner(System.in);
		System.out.println("This is the reservation system for music concert");
		while (true) {
			CommonPrompt.chooseMenu();
			input = checkInputValidity(sc, 4);
			menu = inputMenu(input, rows);
			menu.printContent(sc);
			System.out.println("");
		}
	}
}
