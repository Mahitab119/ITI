
package functioninterface;
@FunctionalInterface
interface Square {
    //int area(int x);
    void area(int x);
}

public class FunctionInterface {

    
    public static void main(String[] args) {
       
        int a = 5;
  
      /*  // lambda expression 
        Square s = (x) -> x * x;
        int ans = s.area(a);
        System.out.println(ans);*/
    
        
     Square s =(x) -> {System.out.println(x * x);};
    s.area(a);
    
    }
    
    
}
