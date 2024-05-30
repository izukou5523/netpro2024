package basic;

public class MyClass2 implements Cloneable {

    public int a;
   
    public int b;
   
    MyClass2(int a, int b) {
   
      this.a = a;
   
      this.b = b;
   
    }
   
    public MyClass2 clone(){
   
      MyClass2 myclass = null;
   
      try {
   
        myclass=(MyClass2)super.clone();
   
        //super.value=myclass.value
   
      } catch (CloneNotSupportedException e) {
   
        e.printStackTrace();
   
      }
   
      return myclass;
   
    }
   
    @Override
   
    public String toString() {
   
      return "{ a: " + this.a + ", b: " + this.b + "}";
   
    }
   
   }
   
   
