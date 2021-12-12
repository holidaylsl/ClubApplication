import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Booking {
	public static final String dateFormat = "yyyy-MMM-dd H:mm";
	private Member m;
	private Facility f;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	
    public Booking(Member m, Facility f, LocalDateTime start, LocalDateTime end) throws Exception {
    	BadBookingException bbe = new BadBookingException("Invalid booking");
    	if(m==null || f==null || start==null || end==null || start.isAfter(end) )
			throw bbe;
		this.m = m;
		this.f = f;
		startTime = start;
		endTime = end;
	}
    
	public Member getMember() {
		return m;
	}

	public Facility getFacility() {
		return f;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public boolean overlaps(Booking book) {
		if(book.getFacility() != f) {
			return false;
		}
		else {
			ZoneId sg = ZoneId.of("Asia/Singapore");
			ZonedDateTime zdtStart1 = ZonedDateTime.of(startTime, sg);
			ZonedDateTime zdtEnd1 = ZonedDateTime.of(endTime, sg);
			ZonedDateTime zdtStart2 = ZonedDateTime.of(book.getStartTime(), sg);
			ZonedDateTime zdtEnd2 = ZonedDateTime.of(book.getEndTime(), sg);
			if(zdtEnd2.toEpochSecond()<zdtStart1.toEpochSecond() || zdtStart2.toEpochSecond()>zdtEnd1.toEpochSecond())
				return false;
			else
				return true;
		}
	}
	
	@Override
	public String toString() {
		String str = "";
		DateTimeFormatter df = DateTimeFormatter.ofPattern(dateFormat);
		str = "(" + m.toString() + "\nbooked: " + f.toString() + "\nfrom: " + 
								startTime.format(df) +"\nto:   " + endTime.format(df) + ")";
		return str;
	}
	public void show() {
		System.out.println(this);
	}
	
}
