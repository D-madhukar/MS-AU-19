import java.util.*;
public class LiftProblem {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		List<PersonFloorPair> list =new ArrayList<>();
		System.out.println("Enter number of Persons Waiting for Lift");
		int n = scan.nextInt();
		System.out.println("Enter Floor Numbers for each person");
		for(int i=1;i<=n;i++) {
			int  floorNumber =scan.nextInt();
			list.add(new PersonFloorPair(i,floorNumber));
		}
		System.out.println("Enter lift Position");
		int liftPosition =scan.nextInt();
		//Sorting in descending order of their floor numbers 
		Collections.sort(list, new Comparator<PersonFloorPair>() {
			public int compare(PersonFloorPair a, PersonFloorPair b) {
				return a.floor<b.floor?1:-1;
			}
		});
		//For odd  number of persons we need to find the lift for mid person(mid in the list after sorting) 
		int temp=n/2;
		if(n%2==1) {
			int midFloor = list.get(temp).floor;
			int midLeftFloor = list.get(temp-1).floor;
			int midRightFloor = list.get(temp+1).floor;
			if(Math.abs(midFloor-midLeftFloor) < Math.abs(midFloor-midRightFloor)) {
				temp = (n/2)+1;
			}
		}
		System.out.print("Lift-A->");
		for(int i=n/2-1;i>=0;i--)
			System.out.print(list.get(i).personNumber + " ");
		System.out.print("\nLift-B->");
		for(int i=temp;i<list.size();i++)
			System.out.print(list.get(i).personNumber + " ");		
		
	}
	/*static void printOrder(List<PersonFloorPair> list, int liftPosition, int from, int to) {
		int firstSmaller=from , firstGreater=from;
		for(int i=from;i<=to;i++) {
			if(list.get(i).floor> liftPosition)
				firstGreater = i;
		}
		for(int i=to;i>=to;i--) {
			if(list.get(i).floor < liftPosition)
				firstSmaller = i;
		}
		if(list.get(firstGreater).floor - liftPosition < liftPosition-list.get(firstSmaller).floor) {}
		
	} */

}
class PersonFloorPair {
	int personNumber;
	int floor;
	PersonFloorPair(int personNumber, int floor) {
		this.personNumber = personNumber;
		this.floor = floor;
	}
}
