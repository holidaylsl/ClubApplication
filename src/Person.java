
public class Person {
	private String surname;
	private String firstName;
	private String secondName;
	
	public Person(String sur, String f, String s) {
		surname = sur;
		firstName = f;
		secondName = s;
	}
	public Person(String sur, String f) {
		surname = sur;
		firstName = f;
		secondName = null;
	}
	
	public String getSurName() {
		return surname;
	} 
	public String getFirstName() {
		return firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	
	public void show() {
		System.out.println(this.toString());
	}
	@Override
	public String toString() {
		String str = "";
		if(secondName==null)
			str = surname + " " + firstName;
		else
			str = surname + " " + firstName + " " + secondName;
		return str;
	}
	
	
}
