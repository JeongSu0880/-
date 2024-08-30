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
	
	public void	printSeatStatus() {
		System.out.print(this.reservationName);
	}
}
