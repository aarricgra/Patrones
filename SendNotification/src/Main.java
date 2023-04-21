abstract class Notification{
    String destination;

    void Notification(String destination){
        this.destination=destination;
    }
    abstract void sendNotification();
    static Notification factory(String destination){
        if(destination.contains(" ")){
            return new SMSNotification(destination);
        } else if (destination.substring(0,4).equals("http")) {
            return new PushNotification(destination);
        }else{
            return new EmailNotification(destination);
        }
    }
}

class SMSNotification extends Notification{
    String destination;

    public SMSNotification(String destination) {
        this.destination = destination;
    }

    @Override
    void sendNotification() {
        System.out.println("Sending sms to: "+destination);
    }
}
class EmailNotification extends Notification{
    String destination;

    public EmailNotification(String destination) {
        this.destination = destination;
    }
    @Override
    void sendNotification() {
        System.out.println("Sending email to: "+destination);
    }
}
class PushNotification extends Notification{
    String destination;

    public PushNotification(String destination) {
        this.destination = destination;
    }
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