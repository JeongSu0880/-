package main;

import java.util.InputMismatchException;
import java.util.Scanner;

import execute.*;
import display.*;
import seat.Row;

public class Main {
	// 프로그램 종료 메뉴 (exit)을 누르기 전까지 무한 while문을 돌면서 프로그램 실행
	public static void main(String[] args) {
		Row[] rows = new Row[3];
		ActionTask	task;
		int input;

		rows[0] = new Row('S');
		rows[1] = new Row('A');
		rows[2] = new Row('B');
		Scanner sc = new Scanner(System.in);
		System.out.println("This is the reservation system for music concert");
		while (true) {
			CommonPrompt.chooseMenu();
			input = checkIntInputValidity(sc, 4);
			menu = inputMenu(input, rows);
			menu.printContent(sc);
			System.out.println("");
		}
	}
}
