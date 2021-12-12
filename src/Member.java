
public class Member extends Person{
	private int memberId;
	public int getMemberId() {
		return memberId;
	}
	
	public Member(int id, String sur, String f, String s) {
		super(sur, f, s);
		memberId = id;
	}
	public Member(int id, String sur, String f) {
		super(sur, f);
		memberId = id;
	}
	
	@Override
	public void show() {
		System.out.println(this.toString());
	}
	@Override
	public String toString() {
		String str = "";
		str = "Member_ID." + memberId + ", " + super.toString();
		return str;
	}
}
