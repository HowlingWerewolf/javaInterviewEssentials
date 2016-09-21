package example.inheritance;

public class InheritanceApplication {
	
    public static void main(String[] args) {    	
    	Quad quad = new Quad();
    	quad.setMotor(new String("Renault"));
    	
    	// constructor will not inherit from the ancestor class! this will not compile:
    	// Quad faultyQuad = new Quad(new Object(), 0, 4);    	
	}  

}
