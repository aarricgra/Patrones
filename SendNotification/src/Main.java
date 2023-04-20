abstract class Notification{
    String destination;

    void Notification(String destination){
        this.destination=destination;
    }
    abstract void sendNotification();
    static Notification factory(String destination){
        if(destination.contains(" ")){
            return new SMSNotification();
        } else if (destination.substring(0,4).equals("http")) {
            return new PushNotification();
        }else{
            return new EmailNotification();
        }
    }
}

class SMSNotification extends Notification{
    @Override
    void sendNotification() {
        System.out.println("Sending sms to: "+destination);
    }
}
class EmailNotification extends Notification{
    @Override
    void sendNotification() {
        System.out.println("Sending email to: "+destination);
    }
}
class PushNotification extends Notification{
    @Override
    void sendNotification() {
        System.out.println("Sending push to: "+destination);
    }
}

public class Main {

        public static void main(String[] args) {

            Notification.factory("gerard@benigaslo.com").sendNotification();
            Notification.factory("http://benigaslo.com/gerard").sendNotification();
            Notification.factory("+34 678 789 890").sendNotification();
        }


}