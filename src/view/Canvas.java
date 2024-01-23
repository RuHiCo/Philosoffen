package view;

import javax.swing.*;
import java.awt.*;

public class Canvas extends JPanel{
    GraphischerPhilosoph[] philosophen;
    GraphischeGabel[] gabeln;

    int anzahl;
    int durchmesser;
    int mitteX;
    int mitteY;
    int groesseX;
    int groesseY;

    public Canvas(int size_x,int size_y, int n){
        this.anzahl=n;
        this.philosophen=new GraphischerPhilosoph[n];
        this.gabeln=new GraphischeGabel[n];
        this.setGroesse(size_x,size_y);

        int[] philosoph_location,gabel_aussen,gabel_innen;
        for(int i=0;i<n;i++){
            philosoph_location=getLocation(n,i,this.durchmesser /1.2, this.mitteX, this.mitteY,0);
            philosophen[i]= new GraphischerPhilosoph(philosoph_location[0], philosoph_location[1],this.durchmesser *3/14);
            gabel_aussen=getLocation(n,i,this.durchmesser /2.1, this.mitteX, this.mitteY,Math.PI/n);
            gabel_innen=getLocation(n,i,this.durchmesser /3.5, this.mitteX, this.mitteY,Math.PI/n);
            gabeln[i]=new GraphischeGabel(gabel_aussen[0], gabel_aussen[1],gabel_innen[0], gabel_innen[1]);
        }
    }

    public void setGroesse(int x,int y){
        this.groesseX =x;
        this.groesseY =y;
        this.mitteX =x/2;
        this.mitteY =y/2;
        this.durchmesser =x/3;
    }

    public static int[] getLocation(int anzahl,int id,double factor, int center_x,int center_y,double offset){
        int x= Double.valueOf(Math.cos(2*Math.PI/anzahl*id+offset)*factor).intValue()+center_x;
        int y= Double.valueOf(Math.sin(2*Math.PI/anzahl*id+offset)*factor).intValue()+center_y;
        return new int[]{x,y};
    }

    public static void drawCircle(int x,int y,int r,Graphics g){
        g.drawOval(x-r,y-r,2*r,2*r);
    }
    public static void fillCircle(int x,int y,int r,Graphics g){
        g.fillOval(x-r,y-r,r*2,r*2);
    }
    public void paintPhilosophs(Graphics g){
        GraphischerPhilosoph philosoph;
        for(int i=0;i<this.philosophen.length;i++){
            philosoph = this.philosophen[i];
            drawCircle(philosoph.x,philosoph.y,philosoph.r,g);
            if (!philosoph.lebt){
                fillCircle(philosoph.x,philosoph.y,philosoph.r,g);
            }
            if (philosoph.links){
                g.drawLine(philosoph.x,philosoph.y,this.gabeln[i].x1,this.gabeln[i].y1);
            }
            if (philosoph.rechts){
                g.drawLine(philosoph.x,philosoph.y,this.gabeln[(i+this.anzahl-1)%this.anzahl].x1,this.gabeln[(i+this.anzahl-1)%this.anzahl].y1);
            }
            if (philosoph.isst){
                drawCircle(philosoph.x,philosoph.y,philosoph.r/2,g);
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
        drawCircle(this.mitteX,this.mitteY,this.durchmesser/2,g);
        paintPhilosophs(g);
        paintGabel(g);
    }

    public void philosophNimmtGabel(int philosoph,String gabel){
        this.philosophen[philosoph].nimmGabel(gabel);
        repaint();
    }

    public void philosophLegtGabelAb(int philosoph,String gabel){
        this.philosophen[philosoph].legGabelAb(gabel);
        repaint();
    }

    public void philophStirbt(int philosoph){
        this.philosophen[philosoph].stirbt();
        repaint();
    }

    public void philophIsst(int philosoph){
        this.philosophen[philosoph].isst();
        repaint();
    }

    public void philophIsstNichtMehr(int philosoph){
        this.philosophen[philosoph].isstNichtMehr();
        repaint();
    }

}