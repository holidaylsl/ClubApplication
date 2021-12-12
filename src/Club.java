import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Club {
	private List<Member> members;
	private int memberIdCount;
	private Map<String, Facility> facilities;
	private BookingRegister bookRegisters;
	
	public Club() {
		members = new ArrayList<>();
		memberIdCount = 0;
		facilities = new HashMap<>();
		bookRegisters = new BookingRegister();
	}
	
	//sorting related:
	public void showFacilitiesSortedByName() {
		Object[] tmpList = facilities.values().stream().toArray();
		List<Facility> fList = new ArrayList<>();
		for(Object f: tmpList) {
			Facility ff = (Facility)f;
			fList.add(ff);
		}
		Collections.sort(fList);
		fList.stream().forEach(x->x.show());
	}
	public void showFacilitiesSortedByDescription() {
		Object[] tmpList = facilities.values().stream().toArray();
		List<Facility> fList = new ArrayList<>();
		for(Object f: tmpList) {
			Facility ff = (Facility)f;
			fList.add(ff);
		}
		Collections.sort(fList, new Comparator<Facility>(){
			@Override
			public int compare(Facility f1, Facility f2) {
				return f1.getDescription().compareTo(f2.getDescription());
			}
		});
		fList.forEach(x->x.show());
	}
	//sort members: surname, then first name, then second name
	public void showMembersSorted() {
		List<Member> mList = new ArrayList<Member>();
		members.stream().forEach(x->mList.add(x));
		Collections.sort(mList, 
				Comparator.comparing(Person::getSurName).thenComparing(Person::getFirstName).thenComparing(Person::getSecondName));
		mList.forEach(x->x.show());
	}
	
	//booking related:
	public void addBooking(int m_id, String f_name, LocalDateTime start, LocalDateTime end) {
		Member m = findMember(m_id);
		Facility f = getFacility(f_name);
		bookRegisters.addBooking(m, f, start, end);
		
	}
	public ArrayList<Booking> getBookings(String f_name, LocalDateTime start, LocalDateTime end) {
		Facility f = getFacility(f_name);
		return bookRegisters.getBookings(f, start, end);
	}
	public void showBookings(String f_name, LocalDateTime start, LocalDateTime end) {
		Facility f = getFacility(f_name);
		ArrayList<Booking> books = bookRegisters.getBookings(f, start, end);
		for(Booking b: books) {
			b.show();
		}
	}
	
	//members related methods: 
	//getMember, addMember, removerMember, showMembers, getMembers, findMember
	public Member getMember(int i) {
		return members.get(i-1);
	}
	public Member addMember(Person p) {
		Member m = new Member(memberIdCount+1, p.getSurName(), p.getFirstName(), p.getSecondName());
		memberIdCount++;
		members.add(m);
		return m;
	}
	public void removeMember(int id) {
		Member m = null;
		for(Member mem: members) {
			if(mem.getMemberId()==id) {
				m = mem;
				break;
			}
		}
		if(m!=null)
			members.remove(m);
	}
	public void showMembers() {
		for(Member m: members) {
			m.show();
		}
	}
	public List<Member> getMembers() {
		return members;
	}
	public Member findMember(int id) {
		Object[] ml = members.stream().filter(x->x.getMemberId()==id).toArray();
		List<Member> mll = new ArrayList<>();
		for(Object m: ml) {
			mll.add((Member)m);
		}
		return mll.get(0);
	}
	
	//facilities related methods:
	//getFacility(String name), getFacilities(), addFacility(), removeFacility(), showFacilities() 
	public Facility getFacility(String name){
		Facility f = facilities.get(name);
		return f;
	}
	public List<Facility> getFacilities(){
		return (List<Facility>) facilities.values();
	}
	public Facility addFacility(Facility f) {
		facilities.put(f.getName(), f);
		return f;
	}
	public Facility addFacility(String name, String des) {
		Facility f = new Facility(name, des);
		facilities.put(name, f);
		return f;
	}
	public void removeFacility(String name) {
		facilities.remove(name);
	}
	public void showFacilities() {
		for(Facility f: facilities.values()) {
			f.show();
		}
	}
	
	public void show() {
		showMembers();
		System.out.print("\n");
		showFacilities();
	}
	
}
