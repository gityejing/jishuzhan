package annotation.domain;

public class Persion {
	private String id;
	private String name;
	
	
	public Persion() {
		super();
	}
	public Persion(String id, String name) {
		super();
		this.id = id;
		this.name = name;
		System.out.println("ππ‘Ïpersion");
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Persion [id=" + id + ", name=" + name + "]";
	}
	
	
}
