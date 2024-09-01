package seat;

// 좌석 하나에 대한 정보를 나타내는 클래스.
public class Seat {
	//예약자 이름
	private String	reservationName;
	
	Seat(){
		this.reservationName = null;
	}
	
	public String	getReservationName() { 
		return (this.reservationName); 
	}
	
	public void	setReservationName(String name) { 
		this.reservationName = name;
	}
	//각 좌석의 예약 상태를 출력하는 함수
	public void	printSeatStatus() {
		System.out.print(this.reservationName);
	}
}
