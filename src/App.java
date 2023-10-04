import javax.swing.*;

public class App{
    public static void main(String[] args) {
        JFrame f=new JFrame("Philosoffen");//creating instance of JFrame
        Tisch t=new Tisch();

        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.add(t);//adding Tisch in JFrame
        f.setSize(800,800);//400 width and 500 height
        f.setLocation(100,100);
        f.setVisible(true);//making the frame visible
    }
}  