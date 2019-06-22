package template;

import java.util.ArrayList;
import java.util.List;

public class Bus extends BookingTemplate{
	int defaultPrice =100;
	@Override
	List<TransportDetails> search(String source, String destination) {
		System.out.println("BUS: search");
		List<TransportDetails> list = new ArrayList<>();
		for( int i = 0;i <5; i++ )
			list.add(new TransportDetails()); // fill Transport details specific to BusTransport
		return list; //Note: Return matching(source, destination) transportDetails   -- Default returning all details
	}

	@Override
	TransportDetails select(List<TransportDetails> availableTranportDetails) {
		System.out.println("BUS: select");
		return availableTranportDetails.get(0); // Assuming user selected first Bus
	}

	@Override
	List<Passenger> selectSeats(TransportDetails transportDetails) {
		System.out.println("BUS: selectSeats");
		List<Passenger> passengers = new ArrayList<> ();
		for(int i=0;i<3;i++) { //Assuming user booking tickets for 3 passengers
			passengers.add(new Passenger("customer" +(i+1),12));
		}
		return passengers;
	}

	@Override
	float confirmBooking(List<Passenger> passengers) {
		System.out.println("BUS: confirmBooking");
		return this.defaultPrice*passengers.size();
	}

	@Override
	boolean payment(float price) {
		//card details Are configured with user 
		System.out.println("BUS: payment");
		return true;
	}

	@Override
	void sendMail() {
		System.out.println("BUS: sendMail");
		//Mail the ticket
	}

}
