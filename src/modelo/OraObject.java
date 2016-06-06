package modelo;

public class OraObject {
	private String name;
	private int version;
	
	public OraObject(String name, int version) {
		super();
		this.name = name;
		this.version = version;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getVersion() {
		return version;
	}
	
	public void setVersion(int version) {
		this.version = version;
	}
}
