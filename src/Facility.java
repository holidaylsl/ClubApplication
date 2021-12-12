
public class Facility implements Comparable<Facility>{
	private String name;
	private String description;
	
	public Facility(String n) {
		name = n;
		description = null;
	}
	public Facility(String n, String des) {
		this(n);
		description = des;
	}
	
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	
	public void show() {
		System.out.println(this.toString());
	}
	@Override
	public String toString() {
		String str = "";
		if(description==null)
			str = name;
		else
			str = name + ": " + description;
		return str;
	}
	@Override
	public int compareTo(Facility f) {
		return name.compareTo(f.getName());
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + name.hashCode();
		return result;

	}
	@Override
	public boolean equals(Object o) {
		Facility f = (Facility)o;
		return f.getName() == name;
	}
	
}
