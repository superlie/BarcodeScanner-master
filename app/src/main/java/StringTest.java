import java.lang.reflect.Array;
import java.util.Arrays;

public class StringTest {

    public static  void main(String[] args){
        String sortFields ="nvchrPartRef2";
        String[] sourceStrArray = sortFields.split(",");

        boolean flag = Arrays.asList(sourceStrArray).contains("nvchrPartRef");
        if(flag){
            System.out.println("nvchrPartRef is  exist");
        }
        boolean flag2 = Arrays.asList(sourceStrArray).contains("nvchrPartRef2");
        if(flag2){
            System.out.println("nvchrPartRef2 is  exist");
        }
        for (int i = 0; i < sourceStrArray.length; i++) {
            System.out.println(sourceStrArray[i]);
        }
    }
}

