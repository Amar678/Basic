package emailapp;

public class EmailApp {
	public static void main(String[] args) {
		EMail email = new EMail("Amar","Kumpati");
		System.out.println(email.showInfo());
		System.out.println("Your alternate Email is ");
		email.setAlternateMail("kumpatiamar@gmail.com");
		System.out.println(email.getAlternateMail());
		}

}
