package template;

import java.util.List;

public abstract class BookingTemplate {
	
	public boolean bookTicket(String source, String destination) {
		List<TransportDetails> availTransports = search(source, destination);
		TransportDetails transport=select(availTransports);
		List<Passenger> passengers = selectSeats(transport);
		float price = confirmBooking(passengers);
		payment(price);
		sendMail();
		return true;
	}
	abstract List<TransportDetails> search(String source, String destination);
	abstract TransportDetails select(List<TransportDetails> availableTranportDetails);
	abstract List<Passenger> selectSeats(TransportDetails transportDetails);
	abstract float confirmBooking(List<Passenger> passengers);
	abstract boolean payment(float price);
	abstract void sendMail();
	
}

// Defining the required classes 
class Passenger {
	String name;
	int age;
	public Passenger(String name , int age) {
		this.name=name;
		this.age=age;
		
	}
}
class CardDetails {
	
}
class TransportDetails {
	
}
