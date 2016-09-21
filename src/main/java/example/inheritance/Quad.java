package example.inheritance;

public class Quad extends Vehicle {

	Object mirror;
	
	public Quad() {
		publicMethod();
		// privateMethod(); // only visible in Vehicle class
		protectedMethod();
		packageProtectedMethod();
	}

	public Object getMirror() {
		return mirror;
	}

	public void setMirror(Object mirror) {
		this.mirror = mirror;
	}
	
}
