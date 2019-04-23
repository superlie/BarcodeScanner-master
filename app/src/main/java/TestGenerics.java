import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class TestGenerics {

    public static void main(String[] args){
        List<String> l1 =new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        System.out.print(l1.getClass()==l2.getClass());


        Sub sub = new Sub();
        Base base = sub;

        List<Sub> lsub = new ArrayList<>();
        //List<Base> lbase = lsub;

        List<?>[] li2 = new ArrayList<?>[5];
        List<?>[] li3 = new ArrayList<?>[10];
        li3[1] = new ArrayList<String>();
        List<?> v = li3[1];
        //Class
    }
}
class Base{}

class Sub extends Base{}

