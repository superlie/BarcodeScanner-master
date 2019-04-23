import java.lang.reflect.Constructor;
import  java.lang.reflect.Field;
class Father{
    public  int a;
    private int b;
    public   int f;
    public  Father(){
        super();
    }
}
class Son extends  Father{
    int c;
    private String d ;
    protected  float e;
    public  int g;
    private Son(){
        super();
    }
    private Son(int c,String d){
        super();
        this.c = c;
        this.d = d;
    }

}

public class FieldTest {
    public static void main(String[] args){
        Class cls = Son.class;
        try{
            Field field = cls.getDeclaredField("b");
        }catch (NoSuchFieldException e){
            e.printStackTrace();
            System.out.println("getDeclaredField :"+e.getMessage());
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("getDeclaredField "+e.getMessage());
        }
        try {
            Field field = cls.getField("b");

        } catch (NoSuchFieldException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("getField "+e.getMessage());
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("getField "+e.getMessage());
        }





        Field[] filed1 = cls.getDeclaredFields();

        for ( Field f : filed1 ) {
            System.out.println("Declared Field :"+f.getName());
        }

        Field[] filed2 = cls.getFields();

        for ( Field f : filed2 ) {
            System.out.println("Field :"+f.getName());
        }


        //testConstructor
        try{
            Class clz = Class.forName("Son");
            Constructor[] constructor = clz.getConstructors();
            for(Constructor c:constructor){
                System.out.println("getConstructor :"+c.toString());
            }
            constructor = clz.getDeclaredConstructors();
            for(Constructor c :constructor){
                System.out.println("getDeclaredConstructors :"+c.toString());
            }
        }catch (ClassNotFoundException e){

        }




    }
}
