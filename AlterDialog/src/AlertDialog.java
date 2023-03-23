import javax.swing.*;

public class AlertDialog {
    String title, text, yesButtonText, noButtonText;

    static class Builder{
        String title, text, yesButtonText, noButtonText;

        public Builder(String title, String text) {
            this.title = title;
            this.text = text;
        }

        public Builder(String title, String text, String yesButtonText, String noButtonText) {
            this.title = title;
            this.text = text;
            this.yesButtonText = yesButtonText;
            this.noButtonText = noButtonText;
        }


        AlertDialog build(){
            AlertDialog a=new AlertDialog();
            a.title=this.title;
            a.text=this.text;
            a.yesButtonText=this.yesButtonText;
            a.noButtonText=this.noButtonText;
            return a;
        }
        Builder setYes(){
            this.yesButtonText = "Ok";
            return this;
        }
        Builder setYes(String a){
            this.yesButtonText = a;
            return this;
        }

        Builder setNo(){
            this.yesButtonText = "Cancel";
            return this;
        }
        Builder setNo(String a){
            this.yesButtonText = a;
            return this;
        }

        void show(){
            AlertDialog alertDialog = build();

            JPanel jPanel = new JPanel();
            jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.PAGE_AXIS));
            jPanel.add(new JLabel(alertDialog.text));
            if (alertDialog.yesButtonText != null)
                jPanel.add(new JButton(alertDialog.yesButtonText));
            if (alertDialog.noButtonText != null)
                jPanel.add(new JButton(alertDialog.noButtonText));


            JFrame jFrame = new JFrame(title);
            jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            jFrame.add(jPanel);
            jFrame.pack();
            jFrame.setLocationRelativeTo(null);
            jFrame.setVisible(true);
        }
    }
}
