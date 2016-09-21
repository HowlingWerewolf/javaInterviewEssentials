package example.inheritance;

public class Vehicle {
	
	public Vehicle() {
	}
	
	public Vehicle(Object motor, int speed, int numberOfWheels){
		this.motor = motor;
		this.speed = speed;
		this.numberOfWheels = numberOfWheels;
	}
	
	Object motor;
	int speed;
	int numberOfWheels;
	
	public Object getMotor() {
		return motor;
	}
	public void setMotor(Object motor) {
		this.motor = motor;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getNumberOfWheels() {
		return numberOfWheels;
	}
	public void setNumberOfWheels(int numberOfWheels) {
		this.numberOfWheels = numberOfWheels;
	}
	
	public void publicMethod(){
		
	}
	
	private void privateMethod(){	
		
	}
	
	protected void protectedMethod(){
		
	}
	
	void packageProtectedMethod(){
		
	}
}
