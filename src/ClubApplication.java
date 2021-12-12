import java.time.LocalDateTime;

public class ClubApplication {

	public static void main(String[] args) {
		Club c1 = new Club();
		Person p1 = new Person("Wang","Xiao","Ming");
		Person p2 = new Person("Li","Xiaoming");
		Person p3 = new Person("Zhang","Xiao","Ming");
		Person p4 = new Person("Wu","Xiao","Ming");
		Person p5 = new Person("Xu","Xiao","Ming");
		Person p6 = new Person("He","Xiao");
		Facility f1 = new Facility("room1","first meeting room");
		Facility f2 = new Facility("room2", "second meeting room");
		Facility f3 = new Facility("room3", "third meeting room");
		
		c1.addMember(p1);
		c1.addMember(p2);
		c1.addMember(p3);
		c1.addMember(p4);
		c1.addMember(p5);
		c1.addMember(p6);
		c1.removeMember(4);
		
		c1.addFacility(f1);
		c1.addFacility(f2);
		c1.addFacility(f3);
		c1.addFacility("room4", "fourth meeting room");
		c1.show();
		System.out.println();
		
		
		c1.addBooking(1, "room1", LocalDateTime.now(), LocalDateTime.now().plusHours(3));
		c1.addBooking(2, "room2", LocalDateTime.now(), LocalDateTime.now().plusHours(3));
		c1.addBooking(3, "room3", LocalDateTime.now(), LocalDateTime.now().plusHours(3));
		c1.addBooking(1, "room3", LocalDateTime.of(2021, 12, 23, 15, 20, 0), LocalDateTime.of(2021, 12, 23, 15, 20, 0).plusHours(3));
		
		c1.showBookings("room1", LocalDateTime.of(2020, 11, 1, 11, 11, 0), LocalDateTime.of(2022, 1, 1, 1, 1, 0));
		c1.showBookings("room2", LocalDateTime.of(2020, 11, 1, 11, 11, 0), LocalDateTime.of(2022, 1, 1, 1, 1, 0));
		c1.showBookings("room3", LocalDateTime.of(2020, 11, 1, 11, 11, 0), LocalDateTime.of(2022, 1, 1, 1, 1, 0));
		
		c1.showFacilitiesSortedByName();
		System.out.println();
		c1.showFacilitiesSortedByDescription();
		System.out.println();
		c1.showMembersSorted();
		
		

	}

}
