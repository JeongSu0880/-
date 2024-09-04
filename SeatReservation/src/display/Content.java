package display;

import seat.Row;
import java.util.Scanner;

//TODO 수정한 부분
// content 출력 클래스를 따로 빼는 대신 함수형 인터페이스를 선언함.

@FunctionalInterface
public interface Content {
	void display(Scanner sc);
}
