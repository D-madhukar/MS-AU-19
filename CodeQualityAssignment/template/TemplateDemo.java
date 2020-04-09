package template;

public class TemplateDemo {

	public static void main(String[] args) {
		BookingTemplate bd = new Bus();
		bd.bookTicket("Jagitial", "Bangalore");
		bd=new Train();
		bd.bookTicket("mancherial", "Bangalore");
	}

}
