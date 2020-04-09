import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class JavaAssignment1 {
	public static void main(String[] args) {
		User user = new User("Madhukar");
		PhoneNumber phoneNumber = new PhoneNumber(user, "3232332332");
		Mobile mobile = new Mobile(phoneNumber);
		mobile.dial("97012223213");
		mobile.dial("97012223213");
		mobile.dial("45474848444");
		mobile.dial("97012223216");
		mobile.showHistory();
	}
}
interface Telecommunication {
	public void receiveCall(String number); 
	public void dial(String number);
	public boolean connect(PhoneNumber phoneNumbwer);
}
class Mobile implements Telecommunication{
	//TODO: use contacts 
	Map<String, List<Call>> dialedCalls;
	Map<String, List<Call>> receivedCalls;
	//Assuming one mobile have only one sim(i.e one number)
	PhoneNumber mobileNumber;
	public Mobile(PhoneNumber mobileNumber) {
		this.mobileNumber = mobileNumber;
		this.dialedCalls = new HashMap<>();
		this.receivedCalls= new HashMap<>();
	}
	public void receiveCall(String number) {
	}
	public void dial(String number) {
		PhoneNumber details = this.getNumberDetails(number);
		boolean isConnected = this.connect(details);
		Date startTime=new Date(), endTime; 
		if(isConnected) {
			startTime = new Date();
			try {
				//By default callduration = 2 seconds
				Thread.sleep(2000);
			}catch(InterruptedException ie) {System.out.println(ie.getMessage());}
		}
		disconnect(details);
		endTime = new Date();
		Call call = new Call(details, startTime, endTime);
		if(this.dialedCalls.containsKey(details.number)) {
			this.dialedCalls.get(details.number).add(call);
		}else {
			List<Call> calls = new ArrayList<>();
			calls.add(call);
			this.dialedCalls.put(details.number, calls);
		}
	}
	public PhoneNumber getNumberDetails(String number) {
		//TODO: Search in contacts and send the number details
		return new PhoneNumber(new User("Srujan"), number);
	}
	//Showing History for a particular number
	public void showHistory(PhoneNumber phoneNumber) {
	}
	//showingHistory of all calls
	public void showHistory() {
		System.out.println(this.mobileNumber.number + ": Dialed-History");
		for(Map.Entry<String, List<Call>> entry: this.dialedCalls.entrySet()) {
			System.out.println("\nNumber:" + entry.getKey() + "---Durations");
			List<Call> calls = entry.getValue();
		
			calls.forEach(e->System.out.println("startTime:" + e.startTime + "-------- endTime:" + e.endTime));
		}
		System.out.println(this.mobileNumber.number + ": Received-History");
		for(Map.Entry<String, List<Call>> entry: this.receivedCalls.entrySet()) {
			System.out.println("\nNumber:" + entry.getKey() + "---Durations");
			List<Call> calls = entry.getValue();
			calls.forEach(e->System.out.println("startTime:" + e.startTime + "-------- endTime:" + e.endTime));
		}
	}
	//NOTE: use the NetworkConnection to connect to a particular number
	public boolean connect(PhoneNumber phoneNumber) {
		return true;
	}
	public void disconnect(PhoneNumber phoneNumber) {
		
	}
}
class Landline{
	Map<PhoneNumber, Call> dialedCalls;
	Map<PhoneNumber,Call> receivedCalls;
	PhoneNumber mobileNumber;
	public void receiveCall(int number) {} 
	public void dial(int number) {}
	public boolean connect(PhoneNumber phoneNumbwer) {
		return true;
		
	}
}
class PhoneNumber{
	User user;
	String number;
	String networkOperator;
	boolean isActive;
	//Assigning default values;
	PhoneNumber() {
		this.networkOperator = "Airtel";
		this.isActive = true;
	}
	public PhoneNumber(User user, String number){
		this();
		this.user = user;
		this.number = number;
	}
	public boolean deactivate() {
		return true;
	}
	public boolean activate() {
		return true;	
	}
	public boolean changeUser(User user){
		return true;
	}
	public boolean changeNetworkOperator(String networkOperator){
		return true;
	}
}
class User{
	String name;
	String address;
	String aadharNo;
	public User(String name) {
		this.name= name;
	}
}
class Call {
	PhoneNumber phoneNumber;
	Date startTime;
	Date endTime;
	public Call(PhoneNumber phoneNumber, Date startTime, Date endTime) {
		this.phoneNumber = phoneNumber;
		this.startTime = startTime;
		this.endTime = endTime;
	}
}



