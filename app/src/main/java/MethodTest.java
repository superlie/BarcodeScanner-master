import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;

class Car {

    private String mBand;

    private Color mColor;

    public enum Color {
        RED,
        WHITE,
        BLACK,
        BLUE,
        YELLOR
    }



    public Car() {
        super();
        // TODO Auto-generated constructor stub
    }


    public Car(String mBand) {
        this.mBand = mBand;
    }


    public void drive() {
        System.out.println("di di di,开车了！");
    }

    @Override
    public String toString() {
        return "Car [mBand=" + mBand + ", mColor=" + mColor + "]";
    }

    public void test(String[] paraa, List<String> b, HashMap<Integer,Son> maps) {}


}

public class MethodTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Car car = new Car();

        Class clz = car.getClass();

        Method methods[] = clz.getDeclaredMethods();



        for ( Method m : methods ) {
            System.out.println("method name:"+m.getName());

          //  Parameter[] paras = m.getParameters();

         //   for ( Parameter p : paras ) {
             //   System.out.println(" parameter :"+p.getName()+" "+p.getType().getName());
         //   }

            Class[] pTypes = m.getParameterTypes();

            System.out.println("method para types:");
            for ( Class type : pTypes ) {
                System.out.print(" "+ type.getName());
            }
            System.out.println();

            Type[] gTypes = m.getGenericParameterTypes();
            System.out.println("method para generic types:");
            for ( Type type : gTypes ) {
               // System.out.print(" "+ type.getTypeName());
            }
            System.out.println();
            System.out.println("==========================================");

        }
    }

}

