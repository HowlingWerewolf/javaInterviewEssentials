package example.defaultconstructor.inheritance;


class DefaultConstructorInheritance 
{ 
    public static void main (String args []) 
    {
        AA a = new B(); 
        System.out.println("complete"); 
    } 
    
    static class AA 
    { 
        public AA(int x){} 
        


    	/*
    	 * No constructor has been defined for class B therefore it will make a call to the default constructor 
    	 * but since class B extends class A it will also call the Super() default constructor.

    	 * Since a constructor has been defined in class A java will no longer supply a default constructor 
    	 * for class A therefore when class B calls class A's default constructor it will result in a compile error.
    	 */
        public AA(){}; // you need to create that here
    } 
    
    static class B extends AA {
    } 
}