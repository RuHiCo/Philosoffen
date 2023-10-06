import javax.swing.*;
import java.awt.*;

public class Canvas extends JPanel{
    int[] tisch;
    GraphischerPhilosoph[] philosophen;
    GraphischeGabel[] gabeln;
    public Canvas(int[] tisch, GraphischerPhilosoph[] philosophen, GraphischeGabel[] gabeln){
        this.tisch=tisch;
        this.philosophen=philosophen;
        this.gabeln=gabeln;
    }
    public static void drawCircle(int x,int y,int r,Graphics g){
        g.drawOval(x-r,y-r,2*r,2*r);
    }
    public static void fillCircle(int x,int y,int r,Graphics g){
        g.fillOval(x-r,y-r,r*2,r*2);
    }
    public void paintTable(Graphics g){
        drawCircle(this.tisch[0],this.tisch[1],this.tisch[2],g);
    }
    public void paintPhilosophs(Graphics g){
        for(GraphischerPhilosoph philosoph:this.philosophen){
            drawCircle(philosoph.x,philosoph.y,philosoph.r,g);
            if (!philosoph.isAlive){
                fillCircle(philosoph.x,philosoph.y,philosoph.r,g);
            }
        }
    }
    public void paintGabel(Graphics g){
        for(GraphischeGabel gabel:this.gabeln){
            g.drawLine(gabel.x1,gabel.y1,gabel.x2,gabel.y2);
        }
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        paintTable(g);
        paintPhilosophs(g);
        paintGabel(g);
    }
}