package example.inheritance.app;

import example.inheritance.Quad;
import example.inheritance.Vehicle;

public class InheritanceApplication {
	
    public static void main(String[] args) {    	
    	Quad quad = new Quad();
    	quad.setMotor(new String("Renault"));
    	
    	// constructor will not inherit from the ancestor class! this will not compile:
    	// Quad faultyQuad = new Quad(new Object(), 0, 4);   
    	
    	Vehicle vehicle = new Vehicle();
    	vehicle.publicMethod();
    	// vehicle.privateMethod(); // private method can't be called 
    	// vehicle.protectedMethod(); // not inherited, so you can't see this from here
    	// vehicle.packageProtectedMethod(); // not the same package also
	}  

}
