import java.util.HashMap;

public class testHashAndEqual {
    public static  void main(String[] args){

        Student s1 = new Student("xiaoming",18);
        Student s2 = new Student("xiaoming",18);
        System.out.print(s1.equals(s2));
        System.out.print(s1.hashCode()==s2.hashCode());
    }

}
class Student{
    String name;
    int age;
    public Student(String name,int age){
        this.name =name;
        this.age  =age;
    }
    @Override
    public int hashCode() {
        final  int prime =31;
        int result =1;
        result = prime*result+age;
        result = prime*result+((name == null)?0:name.hashCode());
        return  result;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass()!=obj.getClass())
            return false;
        Student other = (Student)obj;
        if(age!=other.age)
            return false;
        if(name == null){
            if(other.name != null)
                return false;
        }else if(!name.equals(other.name)){
            return  false;
        }
        return true;
    }
}