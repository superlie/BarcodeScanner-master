public class Parcel3 {
    class Contents{
        private int i=11;
        public  int value(){
            return i;
        }
    }
    class Destination{
        private String lable;
        Destination(String whererto){
            lable =whererto;
        }
        String readLable(){
            return lable;
        }
    }
    public static  void main(String[] args){
        Parcel3 p =new Parcel3();
        Parcel3.Contents c = p.new Contents();
        Parcel3.Destination d = p.new Destination("Tasmania");
    }

}
