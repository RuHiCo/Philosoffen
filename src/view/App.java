package view;

import javax.swing.*;

public class App extends JFrame{
    Canvas leinwand;
    int anzahl;
    public App(int sizeX, int sizeY,int n){
        this.anzahl=n;
        this.leinwand =new Canvas(sizeX,sizeY,n);
        this.setSize(sizeX,sizeY);
        this.setLocation(100,100);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.add(leinwand);
        this.setVisible(true);
    }

    public void philophStirbt(int philosoph){
        this.leinwand.philophStirbt(philosoph);
    }

    public void philosophIsst(int philosoph){
        this.leinwand.philophIsst(philosoph);
    }

    public void philosophIsstNichtMehr(int philosoph){
        this.leinwand.philophIsstNichtMehr(philosoph);
    }

    public void philosopherGrabsFork(int philosoph, String gabel){
        this.leinwand.philosophNimmtGabel(philosoph, gabel);
    }

    public void philosopherDropsFork(int philosoph, String gabel){
        this.leinwand.philosophLegtGabelAb(philosoph, gabel);
    }
}