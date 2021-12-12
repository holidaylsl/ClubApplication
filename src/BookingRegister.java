import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingRegister {
	private Map<Facility,ArrayList<Booking>> f_bookings;
	
	public BookingRegister() {
		f_bookings = new HashMap<>();
	}
	
	public void addBooking(Member m, Facility f, LocalDateTime start, LocalDateTime end) {
		try{
			Booking book = new Booking(m,f,start,end);
			if(f_bookings.containsKey(f)) {
				ArrayList<Booking> books = f_bookings.get(f);
				for(Booking b: books) {
					if(b.overlaps(book))
						throw new BadBookingException("Overlap Booking");
				}
				books.add(book);
			}
			else {
				ArrayList<Booking> bookings = new ArrayList<>();
				bookings.add(book);
				f_bookings.put(f, bookings);
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public ArrayList<Booking> getBookings(Facility f, LocalDateTime start, LocalDateTime end) {
		Object[] books = f_bookings.get(f).stream().filter(x ->
								x.getStartTime().isAfter(start) && x.getEndTime().isBefore(end)).toArray();
		ArrayList<Booking> bks = new ArrayList<>();
		for(Object b: books) {
			Booking bb = (Booking)b;
			bks.add(bb);
		}
		return bks;
	}
	
	public void removeBooking(Booking b) {
		f_bookings.get(b.getFacility()).remove(b);
	}
	
}
