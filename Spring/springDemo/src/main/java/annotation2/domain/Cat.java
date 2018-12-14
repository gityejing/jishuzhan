package annotation2.domain;

public class Cat {

	private String name;
	
	public Cat() {
		super();
		System.out.println(" create cat ");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Cat [name=" + name + "]";
	}
	
	
	
}
