import java.util.Arrays;
import java.util.Collection;

public class testForEach {
    enum Fase {ONE,TWO,THREE,FOUR,FIVE,SIX}
    public static  void main(String[] args){
        Collection<Fase> fase = Arrays.asList(Fase.values());
        for(Fase i:fase)
            for(Fase j:fase){
                System.out.println(i+","+j);
            }
    }
}
