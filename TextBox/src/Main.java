public class Main {
    public static void main(String[] args) {
        System.out.println(new TextBox.Builder(null,1,1).build());
        System.out.println(new TextBox.Builder("Texto",0,1).build());
        System.out.println(new TextBox.Builder("Texto largo",5,14).build());
    }
}