import javax.swing.*;
import java.awt.*;

public class Tisch extends JPanel{
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawOval(200, 200, 400, 400);
        g.drawLine(100, 100, 500, 500);
    }
}