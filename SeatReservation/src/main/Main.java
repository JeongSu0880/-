package main;

import java.util.Scanner;

import	display.*;
import	seat.*;

public class Main {
	public static Menu	setMenu(int num) {
		Menu	menu;
		switch (num) {
		    case 1:
		    	return (new Reserve());
		    case 2:
		    	return (new Search());
		    case 3:
		    	return (new Cancel());
		    case 4:
		    	return (new Exit());
		    default:
		    	System.out.println("유효하지 않은 좌석 타입입니다.");
		    	return (null);
		}
	}
	public static void main(String[] args) {
		Row s = new Row('S');
		Row a = new Row('A');
		Row b = new Row('B');
		Row	inputRow = null;
		Menu	menu;

		Scanner sc = new Scanner(System.in);
		System.out.println("This is the reservation system for music concert");
		CommonPrompt.chooseMenu();
		menu = setMenu(sc.nextInt());
		if (menu == null)
			return ;
		return ;		
	}

}
