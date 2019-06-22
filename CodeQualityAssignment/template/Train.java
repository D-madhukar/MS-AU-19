package template;

import java.util.List;

public class Train extends BookingTemplate{

	@Override
	List<TransportDetails> search(String source, String destination) {
		System.out.println("TRAIN: search");
		return null;
	}

	@Override
	TransportDetails select(List<TransportDetails> availableTranportDetails) {
		System.out.println("TRAIN: select");
		return null;
	}

	@Override
	List<Passenger> selectSeats(TransportDetails transportDetails) {
		System.out.println("TRAIN: selectSeats");
		return null;
	}

	@Override
	float confirmBooking(List<Passenger> passengers) {
		System.out.println("TRAIN: confirmBooking");
		return 0;
	}

	@Override
	boolean payment(float price) {
		System.out.println("TRAIN: payment");
		return false;
	}

	@Override
	void sendMail() {
		System.out.println("TRAIN: sendMail");
	}

}
