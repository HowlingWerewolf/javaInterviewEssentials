package example.defaultconstructor.inheritance;

/*
 * What will be the output of the program?
 */

class Base
{ 
    Base()
    {
        System.out.print("Base");
    }
} 

public class DefaultConstructorInheritance2 extends Base
{ 
    public static void main(String[] args)
    { 
        new DefaultConstructorInheritance2(); 
        new Base(); 
    } 
}
