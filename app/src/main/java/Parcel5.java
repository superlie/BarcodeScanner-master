public class Parcel5 {


    public Destination destination(String s ){
        class PDestination implements  Destination{
            private  String lable;
            private  PDestination(String whereto){
                lable = whereto;
            }

            @Override
            public String readLable() {
                return lable;
            }
        }
        System.out.print(s);
        return new PDestination(s);
    }
    public  static void main(String [] args){
        Parcel5 p =new Parcel5();
        Destination d =p.destination("Tesmania");
    }

}

interface  Destination{
    String readLable();
}