package seat;

import java.util.Map;
import java.util.Objects;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.Optional;

public class Row {
	private char type;
	private Map<Integer, Seat> seat;

	// row의 type을 저장하고, 해당 row에 (좌석 번호, 좌석 객체) map을 1 ~ 16까지 할당.
	public Row(char type) {
		this.type = type;
		seat = IntStream.rangeClosed(1, 16).boxed().collect(Collectors.toMap(i -> i, i -> new Seat()));
	}// map, set, link
		// map 도 순서가 있는 경우 없는 경우 다 다름.
		// 우리는 인터페이스를 사용하고 있기 때문에 내부 구조를 알지 않아도 됨.
		// 

	// 좌석 번호와 이름을 입력 받고
	// 이미 예약이 된 자리 -> 에러처리, 그렇지 않으면 좌석에 예약자 이름 추가.
	public void addName(int seatNum, String name) {
		Seat seatStatus = seat.get(seatNum);// seatStatus -> seat
		// is_Reserved 라는 상태 저장이 따로 되면 좋다. -> 좀 더 명확하게 읽힘.(clean code)
		if (seatStatus.getReservationName() != null) {
			System.out.println("이미 예약된 좌석입니다. 다른 좌석을 선택해주세요.");
		} else {
			seatStatus.setReservationName(name);// 이름 셋팅보다는 reserve의 의미를 좀 더 담으면 좋음.
		} // getter setter를 지양하는 분위기가 있음-> 다른 기능이 추가되는 경우가 많기 때문에.
			// set을 되도록 안쓰는게 좋음 -> private 필드값을 바꾸는 것이기 때문에 위험성이 있음.
	}// Row 클래스 이름과 어울리지 않음 -> 클래스 혹은 메소드 이름 변경

	// 해당 객체의 열에서 입력받은 이름과 일치하는 element를 찾아 그 개수가 1개이면 바로 삭제, 반환값은 일치하는 개수 (1개 이상일
	// 시에 cancel 클래스에서 다룰 예
	public int getMatchSeatCount(String name) {
		int size;

		List<Map.Entry<Integer, Seat>> matched = this.seat.entrySet().stream()
				.filter(e -> Objects.equals(e.getValue().getReservationName(), name)).collect(Collectors.toList());
		size = matched.size();
		return (size);
	}

	// 이름만 입력을 받고 매치되는 것이 하나라면 찾아서 삭제함.
	public boolean deleteName(String name) {
		if (getMatchSeatCount(name) != 1)
			return (false);
		else {
			Optional<Map.Entry<Integer, Seat>> matched = this.seat.entrySet().stream()
					.filter(e -> Objects.equals(e.getValue().getReservationName(), name)).findFirst();
			matched.get().getValue().setReservationName(null);
		}
		return (true);
	}

	// 이름과 자리 번호를 입력받고 삭제
	public boolean deleteName(String name, int seatNum) {
		Optional<Map.Entry<Integer, Seat>> matched = this.seat.entrySet().stream()
				.filter(e -> e.getKey().equals(seatNum)).findFirst();
		if (Objects.equals(matched.get().getValue().getReservationName(), name) == false)
			return (false);// is_present()
		matched.get().getValue().setReservationName(null);
		return true;
	}// 오버로딩은 보통 본체를 호출하는 경우가 많음 -> 중복을 피하기 위해.

	// 맵을 돌면서 row의 좌석의 상태를 출력하는 함수.
	public void printRowStatus() {
		System.out.print(this.type + " >> ");
		for (Map.Entry<Integer, Seat> entry : seat.entrySet()) {
			if (entry.getValue().getReservationName() != null)
				System.out.print(entry.getValue().getReservationName());
			else
				System.out.print(" --- ");
		}
		System.out.println("");
	}
}
//자바는 설계와 원칙을 잘 지키면서 짜는게 중요.
