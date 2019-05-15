import java.util.Timer;
import java.util.TimerTask;

public class Reminder {
    Timer timer;
    public Reminder(int seconds){
        timer = new Timer();
        timer.schedule(new ReminderTask(),seconds*1000);
    }
    class ReminderTask extends TimerTask{
        @Override
        public void run() {
            System.out.print("Tims 's up!");
            timer.cancel();
        }
    }
    public  static  void main(String[] args){
        System.out.println("About the Schedule task.");
        new Reminder(5);
        System.out.println("Schedule task!");
    }
}
