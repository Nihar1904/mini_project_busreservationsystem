package busreservationsystem;
//functionalities:- 
	//see available destinations
	//ticket booking
	//cancel booking
	//view bill
	//pay bill
	//exit
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class Bookings{
	String bookedDes;
	int passCount;
	String bookedName;
	int billGenerated;
	public String getBookedDes() {
		return bookedDes;
	}
	public void setBookedDes(String bookedDes) {
		this.bookedDes = bookedDes;
	}
	public int getPassCount() {
		return passCount;
	}
	public void setPassCount(int passCount) {
		this.passCount = passCount;
	}
	public String getBookedName() {
		return bookedName;
	}
	public void setBookedName(String bookedName) {
		this.bookedName = bookedName;
	}
	public int getBillGenerated() {
		return billGenerated;
	}
	public void setBillGenerated(int billGenerated) {
		this.billGenerated = billGenerated;
	}
	public Bookings(String bookedDes, int passCount, String bookedName, int billGenerated) {
		super();
		this.bookedDes = bookedDes;
		this.passCount = passCount;
		this.bookedName = bookedName;
		this.billGenerated = billGenerated;
	}
	
}
public class BRS {

	public static void main(String[] args) {
		
		int[] available= {20,20,20,20,20};
		int des=0;
		String[] Des= {"Airoli","Thane","Churchgate","Panvel","Dombivli"};
		int pc=0;
		int bg=0;
		int[] fair= {350,300,150,400,350};
		ArrayList<Bookings> bookings= new ArrayList<Bookings>();
		String bname="";
		Scanner sc= new Scanner(System.in);
		for(int z=1;z==1;) {
			System.out.println("********* Bus Reservation System *********");
			System.out.println("** 1) Destinations with available seats **");
			System.out.println("** 2) Ticket Booking                    **");
			System.out.println("** 3) Cancel Booking                    **");
			System.out.println("** 4) View Bill                         **");
			System.out.println("** 5) Exit                              **");
			System.out.println("******************************************");
			System.out.println("Enter your choice:- ");
			int choice=sc.nextInt();
			
			switch(choice) {
			case 1:
				System.out.println("-- Destination ----- Fair ----- Seats --");
				System.out.println("|  1) Airoli     |  Rs. 350  |    "+available[0]+"   |");
				System.out.println("|  2) Thane      |  Rs. 300  |    "+available[1]+"   |");
				System.out.println("|  3) Churchgate |  Rs. 150  |    "+available[2]+"   |");
				System.out.println("|  4) Panvel     |  Rs. 400  |    "+available[3]+"   |");
				System.out.println("|  5) Dombivli   |  Rs. 350  |    "+available[4]+"   |");
				System.out.println("----------------------------------------");
				break;
			case 2:
				System.out.println("************ Ticket Booking ************");
				System.out.println("-- Destination ----- Fair ----- Seats --");
				System.out.println("|  1) Airoli     |  Rs. 350  |    "+available[0]+"   |");
				System.out.println("|  2) Thane      |  Rs. 300  |    "+available[1]+"   |");
				System.out.println("|  3) Churchgate |  Rs. 150  |    "+available[2]+"   |");
				System.out.println("|  4) Panvel     |  Rs. 400  |    "+available[3]+"   |");
				System.out.println("|  5) Dombivli   |  Rs. 350  |    "+available[4]+"   |");
				System.out.println("----------------------------------------");
				
				for(int x=1;x==1;) {
					System.out.println("Enter Destination number:- ");
					des=sc.nextInt();
					if(des<1 || des>5) {
						System.out.println("Enter a valid desitnation number.");
						x=1;
					}
					else {
						x=0;
					}
				}
				for(int x=1;x==1;) {
					System.out.println("Enter number of Passangers:- ");
					pc=sc.nextInt();
					if(pc>available[des-1] || pc<1) {
						System.out.println("Enter a valid passanger count.");
						x=1;
					}
					else {
						x=0;
						available[des-1]=available[des-1]-pc;
					}
				}
				for(int x=1;x==1;) {
					System.out.println("Enter booking name:- ");
					bname=sc.next();
					Iterator<Bookings> ib= bookings.iterator();
					while(ib.hasNext()) {
						Bookings b=ib.next();
						if(b.bookedName.equalsIgnoreCase(bname)) {
							System.out.println("Already reserved with this name. Plz enter another name.");
							x=1;
						}
						else {
							x=0;
						}
					}
					x=0;
				}
				
				if(des==1) {
					bg=(pc*350);
				}else if(des==2) {
					bg=(pc*300);
				}else if(des==3) {
					bg=(pc*150);
				}else if(des==4) {
					bg=(pc*400);
				}else if(des==5) {
					bg=(pc*350);
				}
				
				bookings.add(new Bookings(Des[des-1], pc, bname, bg));
				break;
			case 3:
				System.out.println("Enter name:- ");
				String n1=sc.next();
				Iterator<Bookings> ib1= bookings.iterator();
				if(ib1.hasNext()) {
					while(ib1.hasNext()) {
						Bookings b=ib1.next();
						if(b.bookedName.equalsIgnoreCase(n1)) {
							if(b.bookedDes.equals("Airoli")) {
								available[0]=available[0]+b.passCount;
							}else if(b.bookedDes.equals("Thane")) {
								available[1]=available[1]+b.passCount;
							}else if(b.bookedDes.equals("Churchgate")) {
								available[2]=available[2]+b.passCount;
							}else if(b.bookedDes.equals("Panvel")) {
								available[3]=available[3]+b.passCount;
							}else if(b.bookedDes.equals("Dombivli")) {
								available[4]=available[4]+b.passCount;
							}
							ib1.remove();
						}
						else {
							System.out.println("Name does not exist.");
						}
					}
					System.out.println("Booking cancelled.");
				}
				else {
					System.out.println("Name does not exist.");
				}
				break;
			case 4:
				int billid=0;
				int amount=0;
				System.out.println("Enter name:- ");
				String n=sc.next();
				Iterator<Bookings> ib= bookings.iterator();
				if(ib.hasNext()) {
				while(ib.hasNext()) {
					Bookings b=ib.next();
					if(b.bookedName.equalsIgnoreCase(n)) {
						billid=b.bookedName.indexOf(n);
						System.out.println("Bill:- ");
						System.out.println("Name:- "+b.bookedName);
						System.out.println("Passanger count:- "+b.passCount);
						System.out.println("Destination:- "+b.bookedDes);
						if(b.bookedDes.equals("Airoli")) {
							System.out.println("Fair:- "+fair[0]);
						}else if(b.bookedDes.equals("Thane")) {
							System.out.println("Fair:- "+fair[1]);
						}else if(b.bookedDes.equals("Churchgate")) {
							System.out.println("Fair:- "+fair[2]);
						}else if(b.bookedDes.equals("Panvel")) {
							System.out.println("Fair:- "+fair[3]);
						}else if(b.bookedDes.equals("Dombivli")) {
							System.out.println("Fair:- "+fair[4]);
						}
						System.out.println("Total amount payable:- "+b.billGenerated);
					}
					else {
						System.out.println("Name does not exist.");
					}
				}
				}else {
					System.out.println("Name does not exist.");
				}
				break;
			case 5:
				System.out.println("***** Thank you *****");
				System.exit(0);
				break;
			default:
				System.out.println("Enter a valid choice.");
			}
		}
	}
}