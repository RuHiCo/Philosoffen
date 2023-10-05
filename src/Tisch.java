import javax.swing.*;
import java.awt.*;

public class Tisch extends JPanel{
    int[] tisch;
    int[][] philosophen;
    public Tisch(int[] tisch,int [][] philosophen){
        this.tisch=tisch;
        this.philosophen=philosophen;
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawOval(this.tisch[0],this.tisch[1],this.tisch[2],this.tisch[3]);
        for(int[] philosoph:this.philosophen){
            g.drawOval(philosoph[0],philosoph[1],philosoph[2],philosoph[3]);
        }
    }
}